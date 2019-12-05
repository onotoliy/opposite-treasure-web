package com.github.onotoliy.opposite.treasure.store.reducers

import com.github.onotoliy.opposite.treasure.store.actions.SetAlert
import com.github.onotoliy.opposite.treasure.store.actions.SetLoading
import redux.RAction

data class SystemReducer(
    // количество текущих загрузок
    val loading: Int = 0,
    val alertMessage: String = ""
)

fun system(state: SystemReducer = SystemReducer(), action: RAction): SystemReducer = when (action) {
    is SetLoading -> state.copy(loading = if (action.loading) state.loading + 1 else state.loading - 1)
    is SetAlert -> state.copy(alertMessage = action.message)
    else -> state
}
