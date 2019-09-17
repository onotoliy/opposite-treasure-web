package com.github.onotoliy.opposite.treasure.store

import redux.createStore
import redux.rEnhancer
import com.github.onotoliy.opposite.treasure.store.reducers.State
import com.github.onotoliy.opposite.treasure.store.reducers.combinedReducers

val appStore = createStore(
        combinedReducers(), State(), rEnhancer()
)