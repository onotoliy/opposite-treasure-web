package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.treasure.components.buttonLink
import com.github.onotoliy.opposite.treasure.components.*
import com.github.onotoliy.opposite.treasure.components.form.mFormControl
import com.github.onotoliy.opposite.treasure.components.styled.flexColumn
import com.github.onotoliy.opposite.treasure.components.table.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import org.w3c.dom.events.KeyboardEvent
import react.*
import react.router.dom.routeLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.EventsService

interface EventsPageProps : RProps {
    var scope: CoroutineScope
    var events: ReqListResult<Event>
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
            buttonLink(RoutePath.EVENT_PAGE + "0/edit", "Добавить событие")

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
                            +(event.deadline)
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