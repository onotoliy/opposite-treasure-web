package com.github.onotoliy.opposite.treasure.pages.event

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.materialui.buttonLink
import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.button.ADButtonType
import com.github.onotoliy.kotlinx.materialui.design.flexColumn
import com.github.onotoliy.kotlinx.materialui.design.flexRow
import com.github.onotoliy.kotlinx.materialui.form.mFormControl
import com.github.onotoliy.kotlinx.materialui.mTextField
import com.github.onotoliy.kotlinx.materialui.table.*
import com.github.onotoliy.kotlinx.materialui.tablePagination
import com.github.onotoliy.kotlinx.materialui.targetInputValue
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.FlexDirection
import kotlinx.css.flexDirection
import kotlinx.css.marginTop
import kotlinx.css.px
import org.w3c.dom.events.KeyboardEvent
import react.*
import react.router.dom.routeLink

interface EventsPageProps : RProps {
    var scope: CoroutineScope
    var events: ReqListResult<Event>
    var roles: List<String>
}

class EventsPageState : RState {
    var name: String = ""
}

class EventsPage : RComponent<EventsPageProps, EventsPageState>() {
    init {
        state = EventsPageState()
    }

    override fun componentDidMount() {
        loadEvent()
    }

    override fun RBuilder.render() {
        flexColumn {
            if (Auth.isModifier(props.roles)) {
                flexRow {
                    css.flexDirection = FlexDirection.rowReverse
                    buttonLink(
                            to = RoutePath.EVENT_PAGE + "0/edit",
                            label = "Добавить событие",
                            width = "250px",
                            type = ADButtonType.Apple)
                }
            }
            mFormControl {
                mTextField("Название", value = state.name, fullWidth = true, onKeyDown = ::handleSearchQueryKeyDown, onChange = { e ->
                    val value = e.targetInputValue
                    setState { name = value }
                })
            }
        }

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
                props.events.data.mapIndexed { _, event ->
                    mTableRow {
                        mTableCell {
                            routeLink(RoutePath.EVENT_PAGE + event.uuid, className = "router-link") {
                                +(event.name)
                            }
                        }
                        mTableCell {
                            +(event.contribution)
                        }
                        mTableCell {
                            +(event.deadline.toSimpleDate())
                        }
                    }
                }
            }
        }
        tablePagination(props.events.meta, { page -> loadEvent(offset = page) }, { size -> loadEvent(numberOfRows = size) })
    }

    private fun handleSearchQueryKeyDown(event: KeyboardEvent) {
        if (event.key == "Enter") {
            event.preventDefault()
            loadEvent(name = state.name)
        }
    }

    private fun loadEvent(name: String = "", offset: Int? = null, numberOfRows: Int? = null) {
        Configuration.scope.launch {
            EventsService.loadEvents(
                name = name,
                offset = offset ?: props.events.meta.start,
                numberOfRows = numberOfRows ?: props.events.meta.size)
        }
    }
}
