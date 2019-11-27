package com.github.onotoliy.opposite.treasure.pages.event

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.kotlinx.components.buttonLink
import com.github.onotoliy.kotlinx.components.form.mFormControl
import com.github.onotoliy.kotlinx.components.mTextField
import com.github.onotoliy.kotlinx.components.styled.flexColumn
import com.github.onotoliy.kotlinx.components.styled.flexRow
import com.github.onotoliy.kotlinx.components.table.*
import com.github.onotoliy.kotlinx.components.tablePagination
import com.github.onotoliy.kotlinx.components.targetInputValue
import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.FlexDirection
import kotlinx.css.flexDirection
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
                    buttonLink(RoutePath.EVENT_PAGE + "0/edit", "Добавить событие")
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
        props.scope.launch {
            EventsService.loadEvents(
                name = name,
                offset = offset ?: props.events.meta.start,
                numberOfRows = numberOfRows ?: props.events.meta.size)
        }
    }
}