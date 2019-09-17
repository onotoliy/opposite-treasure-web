package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.treasure.components.buttonLink
import com.github.onotoliy.opposite.treasure.components.styled.shadowContainer
import com.github.onotoliy.opposite.treasure.components.*
import com.github.onotoliy.opposite.treasure.components.form.mFormControl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.html.InputType
import react.*
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.EventsApi
import com.github.onotoliy.opposite.treasure.services.deposits.EventsService
import com.github.onotoliy.opposite.treasure.utils.Funcs.createUUID
import com.github.onotoliy.opposite.treasure.utils.getCurrentDate

class EventEditorState : RState {
    var uuid: String = ""
    var name: String = ""
    var total: String = ""
    var deadline: String = getCurrentDate()
    var contribution: String = ""
}

interface EventEditPageProps : RProps {
    var scope: CoroutineScope
    var uuid: String
    var author: Option
    var event: Event
}

class EventEditPage : RComponent<EventEditPageProps, EventEditorState>() {
    init {
        state = EventEditorState()
    }

    override fun componentDidMount() {
        props.scope.launch {
            setState(state.apply {
                if (props.uuid != "0") {
                    EventsService.loadEvent(uuid = props.uuid)

                    uuid = props.uuid
                    name = props.event.name
                    total = props.event.total
                    deadline = props.event.deadline
                    contribution = props.event.contribution
                }
            }) {
            }
        }
    }

    override fun RBuilder.render() {
        shadowContainer {
            mTypography("Мероприятие", MTypographyVariant.h6)

            mFormControl {
                mTextField("Название", required = true, value = state.name, onChange = { e ->
                    val value = e.targetInputValue
                    setState { name = value }
                })
            }
            mFormControl {
                mTextField("Взнос с одного человека", required = true, value = state.contribution, onChange = { e ->
                    val value = e.targetInputValue
                    setState { contribution = value }
                })
            }
            mFormControl {
                mTextField("Общая сумма", required = true, value = state.total, onChange = { e ->
                    val value = e.targetInputValue
                    setState { total = value }
                })
            }
            mFormControl {
                mTextField("Сдать до", required = true, value = state.deadline, type = InputType.date, onChange = { e ->
                    val value = e.targetInputValue
                    setState { deadline = value }
                })
            }
        }

        mButton(caption = "Сохранить", primary = true, onClick = { save() }, disabled = validate(), variant = MButtonVariant.contained)

        if (props.uuid == "0") {
            buttonLink(RoutePath.EVENT_PAGE, "Назад")
        } else {
            buttonLink(RoutePath.EVENT_PAGE + props.uuid, "Назад")
        }
    }

    private fun validate(): Boolean {
        return state.name.trim() == "" || state.total.trim() == "" || state.contribution.trim() == "" || state.deadline.trim() == "" || state.deadline.trim() == "дд.мм.гггг"
    }

    private fun save() {
        props.scope.launch {
            val event = Event(
                    uuid = if (props.uuid == "0") createUUID() else props.uuid,
                    name = state.name,
                    author = props.author,
                    contribution = state.contribution,
                    total = state.total,
                    deadline = state.deadline)

            if (props.uuid == "0") {
                EventsApi.create(event)
            } else {
                EventsApi.update(event)
            }
        }
    }
}