package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.treasure.components.fieldRow
import com.github.onotoliy.opposite.treasure.components.styled.shadowContainer
import com.github.onotoliy.opposite.treasure.components.MTypographyVariant
import com.github.onotoliy.opposite.treasure.components.mTypography
import com.github.onotoliy.opposite.treasure.components.table.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.routeLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.DepositsService
import com.github.onotoliy.opposite.treasure.services.deposits.EventsService
import com.github.onotoliy.opposite.treasure.services.deposits.TransactionsService
import com.github.onotoliy.opposite.treasure.utils.toReadableDateString

interface DepositViewPageProps : RProps {
    var scope: CoroutineScope
    var person: String
    var deposit: Deposit
    var contributions: ReqListResult<Transaction>
    var debts: ReqListResult<Event>
}

class DepositViewPage : RComponent<DepositViewPageProps, RState>() {
    override fun componentDidMount() {
        props.scope.launch {
            DepositsService.loadDeposit(person = props.person)
            TransactionsService.loadTransactions(user = props.person, type = TransactionType.CONTRIBUTION)
            EventsService.loadDebts(person = props.person)
        }
    }

    override fun RBuilder.render() {
        shadowContainer {
            mTypography("Депозит", MTypographyVariant.h6)
            fieldRow("Пользователь", props.deposit.person.name)
            fieldRow("Депозин", props.deposit.deposit)
        }

        shadowContainer {
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
                                +(contribution.creationDate.toReadableDateString())
                            }
                        }
                    }
                }
            }
        }

        shadowContainer {
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
                                +(debt.deadline.toReadableDateString())
                            }
                        }
                    }
                }
            }
        }
    }
}