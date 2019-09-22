package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.treasure.components.*
import com.github.onotoliy.opposite.treasure.components.form.mFormControl
import com.github.onotoliy.opposite.treasure.components.styled.flexColumn
import com.github.onotoliy.opposite.treasure.components.styled.flexRow
import com.github.onotoliy.opposite.treasure.components.table.*
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.EventsService
import com.github.onotoliy.opposite.treasure.services.deposits.TransactionsService
import com.github.onotoliy.opposite.treasure.services.deposits.UsersService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.pct
import kotlinx.css.width
import org.w3c.dom.events.KeyboardEvent
import react.*
import react.router.dom.routeLink
import styled.css

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
        props.scope.launch {
            UsersService.loadListUsers()
            EventsService.loadListEvents()
        }

        loadTransactions()
    }

    override fun RBuilder.render() {
        flexColumn {
            buttonLink(RoutePath.TRANSACTION_PAGE + "0/edit", "Добавить транзакцию")

            flexRow {

                mFormControl {
                    css {
                        width = 40.pct
                    }
                    mTextField("Название", value = state.name, fullWidth = true, onKeyDown = ::handleSearchQueryKeyDown, onChange = { e ->
                        val value = e.targetInputValue
                        setState { name = value }
                    })
                }

                flexColumn {
                    css {
                        width = 30.pct
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
                }

                flexColumn {
                    css {
                        width = 30.pct
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
                }
            }
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
        tablePagination(props.transactions.meta, { page -> loadTransactions(offset = page) }, { size -> loadTransactions(numberOfRows = size) })
    }

    private fun handleSearchQueryKeyDown(event: KeyboardEvent) {
        if (event.key == "Enter") {
            event.preventDefault()
            loadTransactions()
        }
    }

    private fun loadTransactions(offset: Int? = null, numberOfRows: Int? = null) {
        props.scope.launch {
            TransactionsService.loadTransactions(
                    type = state.type,
                    name = state.name,
                    user = state.personUUID,
                    event = state.eventUUID,
                    offset = offset ?: props.transactions.meta.start,
                    numberOfRows = numberOfRows ?: props.transactions.meta.size)
        }
    }
}