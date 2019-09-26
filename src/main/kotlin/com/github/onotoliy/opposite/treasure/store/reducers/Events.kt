package com.github.onotoliy.opposite.treasure.store.reducers

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import redux.RAction
import com.github.onotoliy.opposite.treasure.store.actions.SetDebts
import com.github.onotoliy.opposite.treasure.store.actions.SetEvent
import com.github.onotoliy.opposite.treasure.store.actions.SetEvents
import com.github.onotoliy.opposite.treasure.store.actions.SetListEvents
import com.github.onotoliy.kotlinx.toReqListResult

data class EventsReducer(
    val event: Event = Event(),
    val debts: ReqListResult<Event> = ReqListResult(),
    val listEvents: List<Option> = emptyList(),
    val events: ReqListResult<Event> = ReqListResult()
)

fun events(state: EventsReducer = EventsReducer(), action: RAction): EventsReducer = when (action) {
    is SetEvent -> state.copy(event = action.event)
    is SetEvents -> state.copy(events = action.events.toReqListResult())
    is SetListEvents -> state.copy(listEvents = action.listEvents.toList())
    is SetDebts -> state.copy(debts = action.debts.toReqListResult())
    else -> state
}