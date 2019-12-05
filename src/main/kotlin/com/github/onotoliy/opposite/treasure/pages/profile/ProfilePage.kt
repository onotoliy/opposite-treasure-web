package com.github.onotoliy.opposite.treasure.pages.profile

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.kotlinx.materialui.MTypographyVariant
import com.github.onotoliy.kotlinx.materialui.design.shadowWrapper
import com.github.onotoliy.kotlinx.materialui.fieldRow
import com.github.onotoliy.kotlinx.materialui.mTypography
import com.github.onotoliy.kotlinx.materialui.table.*
import com.github.onotoliy.kotlinx.materialui.tablePagination
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.data.*
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.cashbox.CashboxService
import com.github.onotoliy.opposite.treasure.services.deposit.*
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsService
import com.github.onotoliy.opposite.treasure.services.user.UsersService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.routeLink

interface ProfilePageProps : RProps {
    var scope: CoroutineScope
    var user: Option
    var deposit: Deposit
    var cashbox: Cashbox
    var debts: ReqListResult<Event>
    var transactions: ReqListResult<Transaction>
}

class ProfilePage : RComponent<ProfilePageProps, RState>() {
    override fun componentDidMount() {
        Configuration.scope.launch {
            UsersService.loadCurrentUser()
            DepositsService.loadDeposit(props.user.uuid)
            CashboxService.loadCasbox()

            loadTransactions()
            loadDebts()
        }
    }

    override fun RBuilder.render() {
        shadowWrapper {
            mTypography("Касса", MTypographyVariant.h6)
            fieldRow("Сумма", props.cashbox.deposit)
            fieldRow("Дата изменения", props.cashbox.lastUpdateDate.toSimpleDate())
        }

        shadowWrapper {
            mTypography("Мой депозит", MTypographyVariant.h6)
            fieldRow("Сумма", props.deposit.deposit)
        }

        if (props.transactions.meta.total > 0) {
            shadowWrapper {
                mTypography("Мои платежи", MTypographyVariant.h6)
                mTable {
                    mTableHead {
                        mTableRow {
                            mTableCell {
                                +"Название"
                            }
                            mTableCell {
                                +"Событие"
                            }
                            mTableCell {
                                +"Сумма"
                            }
                            mTableCell {
                                +"Дата платежа"
                            }
                        }
                    }
                    mTableBody {
                        props.transactions.data.mapIndexed { _, transaction ->
                            mTableRow {
                                mTableCell {
                                    routeLink(RoutePath.TRANSACTION_PAGE + transaction.uuid, className = "router-link") {
                                        +(transaction.name)
                                    }
                                }
                                mTableCell {
                                    routeLink(RoutePath.EVENT_PAGE + transaction.event?.uuid, className = "router-link") {
                                        +(transaction.event?.name ?: "")
                                    }
                                }
                                mTableCell {
                                    +(transaction.cash)
                                }
                                mTableCell {
                                    +(transaction.creationDate.toSimpleDate())
                                }
                            }
                        }
                    }
                }
                tablePagination(props.transactions.meta, { page -> loadTransactions(offset = page) }, { size -> loadTransactions(numberOfRows = size) })
            }
        }

        if (props.debts.meta.total > 0) {
            shadowWrapper {
                mTypography("Мои долги", MTypographyVariant.h6)
                mTable {
                    mTableHead {
                        mTableRow {
                            mTableCell {
                                +"Название"
                            }
                            mTableCell {
                                +"Сумма"
                            }
                            mTableCell {
                                +"Дата платежа"
                            }
                        }
                    }
                    mTableBody {
                        props.debts.data.mapIndexed { _, debt ->
                            mTableRow {
                                mTableCell {
                                    routeLink(RoutePath.EVENT_PAGE + debt.uuid, className = "router-link") {
                                        +(debt.name)
                                    }
                                }
                                mTableCell {
                                    +(debt.contribution)
                                }
                                mTableCell {
                                    +(debt.deadline.toSimpleDate())
                                }
                            }
                        }
                    }
                }
                tablePagination(props.debts.meta, { page -> loadDebts(offset = page) }, { size -> loadDebts(numberOfRows = size) })
            }
        }
    }

    private fun loadTransactions(offset: Int? = null, numberOfRows: Int? = null) {
        Configuration.scope.launch {
            TransactionsService.loadTransactions(
                    user = props.user.uuid,
                    offset = offset ?: props.transactions.meta.start,
                    numberOfRows = numberOfRows ?: props.transactions.meta.size)
        }
    }

    private fun loadDebts(offset: Int? = null, numberOfRows: Int? = null) {
        Configuration.scope.launch {
            EventsService.loadDebts(
                    person = props.user.uuid,
                    offset = offset ?: props.debts.meta.start,
                    numberOfRows = numberOfRows ?: props.debts.meta.size)
        }
    }
}
