package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.treasure.components.buttonLink
import com.github.onotoliy.opposite.treasure.components.*
import com.github.onotoliy.opposite.treasure.components.form.mFormControl
import com.github.onotoliy.opposite.treasure.components.table.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import org.w3c.dom.events.KeyboardEvent
import react.*
import react.router.dom.routeLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.TransactionsService

class TransactionsPageState : RState {
    var name: String = ""
    var type: TransactionType = TransactionType.NONE
    var personUUID: String = ""
    var eventUUID: String = ""
}

interface TransactionsPageProps : RProps {
    var scope: CoroutineScope
    var transactions: ReqListResult<Transaction>
    var events: List<Option>
    var persons: List<Option>
}

class TransactionsPage : RComponent<TransactionsPageProps, TransactionsPageState>() {
    init {
        state = TransactionsPageState()
    }

    override fun componentDidMount() {
        loadTransactions()
    }

    override fun RBuilder.render() {
        buttonLink(RoutePath.TRANSACTION_PAGE + "0/edit", "Добавить транзакцию")

        mFormControl {
            mTextField("Название", value = state.name, fullWidth = true, onKeyDown = ::handleSearchQueryKeyDown, onChange = { e ->
                val value = e.targetInputValue
                setState { name = value }
            })
        }

        mTextFieldSelect(
                label = "Член клуба",
                value = state.personUUID,
                onChange = { event ->
                    val value = event.targetValue as String
                    setState {
                        personUUID = value
                    }
                    loadTransactions()
                }
        ) {
            mMenuItem("", value = "", key = "")
            props.persons.map { mMenuItem(it.name, value = it.uuid, key = it.uuid) }
        }

        mTextFieldSelect(
                label = "Мероприятие",
                value = state.eventUUID,
                onChange = { e ->
                    val value = e.targetValue as String
                    setState {
                        eventUUID = value
                    }
                    loadTransactions()
                }
        ) {
            mMenuItem("", value = "", key = "")
            props.events.map { mMenuItem(it.name, value = it.uuid, key = it.uuid) }
        }

        mTable {
            mTableHead {
                mTableRow {
                    mTableCell {
                        +"Тип"
                    }
                    mTableCell {
                        +"Название"
                    }
                    mTableCell {
                        +"Пользователь"
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
                            +(transaction.type.name)
                        }
                        mTableCell {
                            routeLink(RoutePath.TRANSACTION_PAGE + transaction.uuid, className = "router-link") {
                                +(transaction.name)
                            }
                        }
                        mTableCell {
                            routeLink(RoutePath.DEPOSIT_PAGE + transaction.person?.uuid, className = "router-link") {
                                +(transaction.person?.name ?: "")
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
                            +(transaction.creationDate)
                        }
                    }
                }
            }
        }
    }

    private fun handleSearchQueryKeyDown(event: KeyboardEvent) {
        if (event.key == "Enter") {
            event.preventDefault()
            loadTransactions()
        }
    }

    private fun loadTransactions() {
        props.scope.launch {
            TransactionsService.loadTransactions(
                    type = state.type,
                    name = state.name,
                    user = state.personUUID,
                    event = state.eventUUID)
        }
    }
}