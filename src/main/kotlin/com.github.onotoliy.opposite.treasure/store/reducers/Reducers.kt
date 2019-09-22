package com.github.onotoliy.opposite.treasure.store.reducers

import redux.RAction
import redux.Reducer
import redux.combineReducers

data class State(
    val events: EventsReducer = EventsReducer(),
    val transactions: TransactionsReducer = TransactionsReducer(),
    val deposits: DepositsReducer = DepositsReducer(),
    val users: UsersReducer = UsersReducer(),
    val system: SystemReducer = SystemReducer(),
    val cashbox: CashboxReducer = CashboxReducer()
)

fun combinedReducers() = combineReducers<State, RAction>(
        mapOf<String, Reducer<*, RAction>>(
                "transactions" to ::transactions,
                "events" to ::events,
                "deposits" to ::deposits,
                "cashbox" to ::cashbox,
                "users" to ::users,
                "system" to ::system
        )
)
