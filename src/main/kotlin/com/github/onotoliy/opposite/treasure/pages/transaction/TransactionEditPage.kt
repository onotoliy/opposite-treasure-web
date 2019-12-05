package com.github.onotoliy.opposite.treasure.pages.transaction

import com.github.onotoliy.kotlinx.materialui.*
import com.github.onotoliy.kotlinx.materialui.button.mButtonGroup
import com.github.onotoliy.kotlinx.materialui.design.button.adButton
import com.github.onotoliy.kotlinx.materialui.design.shadowWrapper
import com.github.onotoliy.kotlinx.materialui.form.mFormControl
import com.github.onotoliy.kotlinx.materialui.menu.mMenuItem
import com.github.onotoliy.kotlinx.now
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toISO
import com.github.onotoliy.kotlinx.uuid
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsApi
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsService
import com.github.onotoliy.opposite.treasure.services.user.UsersService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.marginRight
import kotlinx.css.px
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import react.*
import react.router.dom.RouteResultHistory

class TransactionEditorState : RState {
    var name: String = ""
    var cash: String = ""
    var creationDate: String = now()
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
        Configuration.scope.launch {
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
        shadowWrapper {
            mTypography("Транзакция", MTypographyVariant.h6)

            mTextFieldSelect(
                    label = "Тип",
                    value = state.type.name,
                    fullWidth = true,
                    disabled = props.uuid != "0",
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
                mTextField("Денежные средства", required = true, disabled = props.uuid != "0", value = state.cash, fullWidth = true, onChange = { e ->
                    val value = e.targetInputValue
                    setState { cash = value }
                })
            }

            mTextFieldSelect(
                    label = "Член клуба",
                    value = state.personUUID,
                    disabled = when {
                        state.type == TransactionType.NONE || state.type == TransactionType.COST -> true
                        else -> props.uuid != "0"
                    },
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
                    disabled = props.uuid != "0",
                    onChange = { e ->
                        val value = e.targetValue as String
                        setState {
                            eventUUID = value
                        }
                    }
            ) {
                props.events.map { mMenuItem(it.name, value = it.uuid, key = it.uuid) }
            }

            mFormControl {
                mTextField("Дата платежа", required = true, value = state.creationDate, type = InputType.date, onChange = { e ->
                    val value = e.targetInputValue
                    setState { creationDate = value }
                })
            }
        }

        shadowWrapper {
            mButtonGroup {
                adButton(label = "Сохранить", disabled = validate(), width = "150px") {
                    css.marginRight = 15.px
                    attrs.onClickFunction = {
                        save()
                    }
                }

                buttonLink(if (props.uuid == "0") RoutePath.EVENT_PAGE else RoutePath.EVENT_PAGE + props.uuid, "Назад")
            }
        }
    }

    private fun validate(): Boolean {
        if (state.type == TransactionType.NONE || state.name.isEmpty() || state.cash.isEmpty()) {
            return true
        }

        return state.type != TransactionType.COST && state.personUUID.isEmpty()
    }

    private fun save() {
        Configuration.scope.launch {
            val event = Transaction(
                    uuid = if (props.uuid == "0") uuid() else props.uuid,
                    name = state.name,
                    cash = state.cash,
                    type = state.type,
                    author = props.author,
                    creationDate = state.creationDate.toISO(),
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
