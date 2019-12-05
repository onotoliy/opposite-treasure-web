package com.github.onotoliy.opposite.treasure.store

import com.github.onotoliy.opposite.treasure.store.reducers.State
import com.github.onotoliy.opposite.treasure.store.reducers.combinedReducers
import redux.createStore
import redux.rEnhancer

val appStore = createStore(
        combinedReducers(), State(), rEnhancer()
)
