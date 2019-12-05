package com.github.onotoliy.opposite.treasure.pages.deposit

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.kotlinx.materialui.MTypographyVariant
import com.github.onotoliy.kotlinx.materialui.design.shadowWrapper
import com.github.onotoliy.kotlinx.materialui.fieldRow
import com.github.onotoliy.kotlinx.materialui.mTypography
import com.github.onotoliy.kotlinx.materialui.table.*
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposit.DepositsService
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.routeLink

interface DepositViewPageProps : RProps {
    var scope: CoroutineScope
    var person: String
    var deposit: Deposit
    var contributions: ReqListResult<Transaction>
    var debts: ReqListResult<Event>
}

class DepositViewPage : RComponent<DepositViewPageProps, RState>() {
    override fun componentDidMount() {
        Configuration.scope.launch {
            DepositsService.loadDeposit(person = props.person)
            TransactionsService.loadTransactions(user = props.person)
            EventsService.loadDebts(person = props.person)
        }
    }

    override fun RBuilder.render() {
        shadowWrapper {
            mTypography("Депозит", MTypographyVariant.h6)
            fieldRow("Пользователь", props.deposit.person.name)
            fieldRow("Депозин", props.deposit.deposit)
        }

        shadowWrapper {
            mTypography("Платежи", MTypographyVariant.h6)

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
                    props.contributions.data.mapIndexed { _, contribution ->
                        mTableRow {
                            mTableCell {
                                routeLink(RoutePath.TRANSACTION_PAGE + contribution.uuid, className = "router-link") {
                                    +(contribution.name)
                                }
                            }
                            mTableCell {
                                routeLink(RoutePath.EVENT_PAGE + contribution.event?.uuid, className = "router-link") {
                                    +(contribution.event?.name ?: "")
                                }
                            }
                            mTableCell {
                                +(contribution.cash)
                            }
                            mTableCell {
                                +(contribution.creationDate.toSimpleDate())
                            }
                        }
                    }
                }
            }
        }

        shadowWrapper {
            mTypography("Долги", MTypographyVariant.h6)
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
        }
    }
}
