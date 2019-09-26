package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.treasure.components.*
import com.github.onotoliy.opposite.treasure.components.form.mFormControl
import com.github.onotoliy.opposite.treasure.components.styled.shadowContainer
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.EventsService
import com.github.onotoliy.opposite.treasure.services.deposits.TransactionsApi
import com.github.onotoliy.opposite.treasure.services.deposits.TransactionsService
import com.github.onotoliy.opposite.treasure.services.deposits.UsersService
import com.github.onotoliy.opposite.treasure.utils.Funcs.createUUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.*
import react.router.dom.RouteResultHistory

class TransactionEditorState : RState {
    var name: String = ""
    var cash: String = ""
    var type: TransactionType = TransactionType.NONE
    var personUUID: String = ""
    var eventUUID: String = ""
}

interface TransactionEditPageProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
    var transaction: Transaction
    var author: Option
    var events: List<Option>
    var persons: List<Option>
}

class TransactionEditPage : RComponent<TransactionEditPageProps, TransactionEditorState>() {
    init {
        state = TransactionEditorState()
    }

    override fun componentDidMount() {
        props.scope.launch {
            UsersService.loadListUsers()
            EventsService.loadListEvents()

            if (props.uuid != "0") {
                TransactionsService.loadTransaction(uuid = props.uuid)

                setState {
                    name = props.transaction.name
                    cash = props.transaction.cash
                    type = props.transaction.type
                    personUUID = props.transaction.person?.uuid ?: ""
                    eventUUID = props.transaction.event?.uuid ?: ""
                }
            }
        }
    }

    override fun RBuilder.render() {
        shadowContainer {
            mTypography("Транзакция", MTypographyVariant.h6)

            mTextFieldSelect(
                    label = "Тип",
                    value = state.type.name,
                    fullWidth = true,
                    onChange = { event ->
                        val value = TransactionType.valueOf(event.targetValue as String)
                        setState { type = value }
                    }
            ) {
                TransactionType.values().map { unit ->
                    mMenuItem(unit.label, value = unit.name, key = unit.name)
                }
            }

            mFormControl {
                mTextField("Название", required = true, value = state.name, fullWidth = true, onChange = { e ->
                    val value = e.targetInputValue
                    setState { name = value }
                })
            }

            mFormControl {
                mTextField("Денежные средства", required = true, value = state.cash, fullWidth = true, onChange = { e ->
                    val value = e.targetInputValue
                    setState { cash = value }
                })
            }

            mTextFieldSelect(
                    label = "Член клуба",
                    value = state.personUUID,
                    disabled = personDisabled(),
                    onChange = { event ->
                        val value = event.targetValue as String
                        setState {
                            personUUID = value
                        }
                    }
            ) {
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
                    }
            ) {
                props.events.map { mMenuItem(it.name, value = it.uuid, key = it.uuid) }
            }
        }

        mButton(caption = "Сохранить", primary = true, onClick = { save() }, disabled = validate(), variant = MButtonVariant.contained)

        if (props.uuid == "0") {
            buttonLink(RoutePath.TRANSACTION_PAGE, "Назад")
        } else {
            buttonLink(RoutePath.TRANSACTION_PAGE + props.uuid, "Назад")
        }
    }

    private fun personDisabled(): Boolean {
        return when {
            state.type == TransactionType.NONE || state.type == TransactionType.COST -> true
            else -> props.uuid != "0"
        }
    }

    private fun validate(): Boolean {
        if (state.type == TransactionType.NONE || state.name.isEmpty() || state.cash.isEmpty()) {
            return true
        }

        return state.type != TransactionType.COST && state.personUUID.isEmpty()
    }

    private fun save() {
        props.scope.launch {
            val event = Transaction(
                    uuid = if (props.uuid == "0") createUUID() else props.uuid,
                    name = state.name,
                    cash = state.cash,
                    type = state.type,
                    author = props.author,
                    person = if (state.personUUID.isNotEmpty()) Option(state.personUUID, "") else null,
                    event = if (state.eventUUID.isNotEmpty()) Option(state.eventUUID, "") else null)

            if (props.uuid == "0") {
                TransactionsApi.create(event)
            } else {
                TransactionsApi.update(event)
            }

            props.history.push(RoutePath.TRANSACTION_PAGE + event.uuid)
        }
    }
}