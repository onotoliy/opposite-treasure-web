package com.github.onotoliy.opposite.treasure.pages.event

import com.github.onotoliy.kotlinx.fromISO
import com.github.onotoliy.kotlinx.materialui.*
import com.github.onotoliy.kotlinx.materialui.button.mButtonGroup
import com.github.onotoliy.kotlinx.materialui.design.button.adButton
import com.github.onotoliy.kotlinx.materialui.design.shadowWrapper
import com.github.onotoliy.kotlinx.materialui.form.mFormControl
import com.github.onotoliy.kotlinx.now
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toISO
import com.github.onotoliy.kotlinx.uuid
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.event.EventsApi
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.marginRight
import kotlinx.css.px
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import react.*
import react.router.dom.RouteResultHistory

class EventEditorState : RState {
    var uuid: String = ""
    var name: String = ""
    var total: String = ""
    var deadline: String = now()
    var contribution: String = ""
}

interface EventEditPageProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
    var author: Option
    var event: Event
}

class EventEditPage : RComponent<EventEditPageProps, EventEditorState>() {
    init {
        state = EventEditorState()
    }

    override fun componentDidMount() {
        Configuration.scope.launch {
            setState(state.apply {
                if (props.uuid != "0") {
                    EventsService.loadEvent(uuid = props.uuid)

                    uuid = props.uuid
                    name = props.event.name
                    total = props.event.total
                    deadline = props.event.deadline.fromISO()
                    contribution = props.event.contribution
                }
            }) {
            }
        }
    }

    override fun RBuilder.render() {
        shadowWrapper {
            mTypography("Мероприятие", MTypographyVariant.h6)

            mFormControl {
                mTextField("Название", required = true, value = state.name, onChange = { e ->
                    val value = e.targetInputValue
                    setState { name = value }
                })
            }
            mFormControl {
                mTextField("Взнос с одного человека", required = true, disabled = props.uuid != "0", value = state.contribution, onChange = { e ->
                    val value = e.targetInputValue
                    setState { contribution = value }
                })
            }
            mFormControl {
                mTextField("Общая сумма", required = true, disabled = props.uuid != "0", value = state.total, onChange = { e ->
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
        return state.name.trim() == "" || state.total.trim() == "" || state.contribution.trim() == "" || state.deadline.trim() == "" || state.deadline.trim() == "дд.мм.гггг"
    }

    private fun save() {
        Configuration.scope.launch {
            val event = Event(
                    uuid = if (props.uuid == "0") uuid() else props.uuid,
                    name = state.name,
                    author = props.author,
                    contribution = state.contribution,
                    total = state.total,
                    deadline = state.deadline.toISO())

            when {
                props.uuid == "0" -> EventsApi.create(event)
                else -> EventsApi.update(event)
            }

            props.history.push(RoutePath.EVENT_PAGE + event.uuid)
        }
    }
}
