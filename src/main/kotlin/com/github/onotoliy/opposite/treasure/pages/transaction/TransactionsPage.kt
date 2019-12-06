package com.github.onotoliy.opposite.treasure.pages.transaction

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.materialui.buttonLink
import com.github.onotoliy.kotlinx.materialui.design.button.ADButtonType
import com.github.onotoliy.kotlinx.materialui.design.flexColumn
import com.github.onotoliy.kotlinx.materialui.design.flexRow
import com.github.onotoliy.kotlinx.materialui.form.mFormControl
import com.github.onotoliy.kotlinx.materialui.mTextField
import com.github.onotoliy.kotlinx.materialui.mTextFieldSelect
import com.github.onotoliy.kotlinx.materialui.menu.mMenuItem
import com.github.onotoliy.kotlinx.materialui.table.*
import com.github.onotoliy.kotlinx.materialui.tablePagination
import com.github.onotoliy.kotlinx.materialui.targetInputValue
import com.github.onotoliy.kotlinx.materialui.targetValue
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsService
import com.github.onotoliy.opposite.treasure.services.user.UsersService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.*
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
    var roles: List<String>
}

class TransactionsPage : RComponent<TransactionsPageProps, TransactionsPageState>() {
    init {
        state = TransactionsPageState()
    }

    override fun componentDidMount() {
        Configuration.scope.launch {
            UsersService.loadListUsers()
            EventsService.loadListEvents()
        }

        loadTransactions()
    }

    override fun RBuilder.render() {
        flexColumn {
            if (Auth.isModifier(props.roles)) {
                flexRow {
                    css.flexDirection = FlexDirection.rowReverse
                    buttonLink(
                            to = RoutePath.TRANSACTION_PAGE + "0/edit",
                            label = "Добавить транзакцию",
                            width = "250px",
                            type = ADButtonType.Apple)
                }
            }

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
                            +(transaction.type.label)
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
                            +(transaction.creationDate.toSimpleDate())
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
        Configuration.scope.launch {
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
