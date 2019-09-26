package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.*
import com.github.onotoliy.kotlinx.materialui.components.MTypographyVariant
import com.github.onotoliy.kotlinx.materialui.components.fieldRow
import com.github.onotoliy.kotlinx.materialui.components.mTypography
import com.github.onotoliy.kotlinx.materialui.components.styled.shadowContainer
import com.github.onotoliy.kotlinx.materialui.components.table.*
import com.github.onotoliy.kotlinx.materialui.components.tablePagination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.routeLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.*
import com.github.onotoliy.opposite.treasure.utils.toReadableDateString

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
        props.scope.launch {
            UsersService.loadCurrentUser()
            DepositsService.loadDeposit(props.user.uuid)
            CashboxService.loadCasbox()

            loadTransactions()
            loadDebts()
        }
    }

    override fun RBuilder.render() {
        shadowContainer {
            mTypography("Касса", MTypographyVariant.h6)
            fieldRow("Сумма", props.cashbox.deposit)
            fieldRow("Дата изменения", props.cashbox.lastUpdateDate.toReadableDateString())
        }

        shadowContainer {
            mTypography("Мой депозит", MTypographyVariant.h6)
            fieldRow("Сумма", props.deposit.deposit)
        }

        if (props.transactions.meta.total > 0) {
            shadowContainer {
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
                                    +(transaction.creationDate.toReadableDateString())
                                }
                            }
                        }
                    }
                }
                tablePagination(props.transactions.meta, { page -> loadTransactions(offset = page) }, { size -> loadTransactions(numberOfRows = size) })
            }
        }

        if (props.debts.meta.total > 0) {
            shadowContainer {
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
                                    +(debt.deadline.toReadableDateString())
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
        props.scope.launch {
            TransactionsService.loadTransactions(
                    type = TransactionType.CONTRIBUTION,
                    user = props.user.uuid,
                    offset = offset ?: props.transactions.meta.start,
                    numberOfRows = numberOfRows ?: props.transactions.meta.size)
        }
    }

    private fun loadDebts(offset: Int? = null, numberOfRows: Int? = null) {
        props.scope.launch {
            EventsService.loadDebts(
                    person = props.user.uuid,
                    offset = offset ?: props.debts.meta.start,
                    numberOfRows = numberOfRows ?: props.debts.meta.size)
        }
    }
}