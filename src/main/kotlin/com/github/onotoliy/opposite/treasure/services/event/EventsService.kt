package com.github.onotoliy.opposite.treasure.services.event

import com.github.onotoliy.opposite.treasure.services.debts.DebtsApi
import com.github.onotoliy.opposite.treasure.store.actions.SetDebts
import com.github.onotoliy.opposite.treasure.store.actions.SetEvent
import com.github.onotoliy.opposite.treasure.store.actions.SetEvents
import com.github.onotoliy.opposite.treasure.store.actions.SetListEvents
import com.github.onotoliy.opposite.treasure.store.appStore

object EventsService {

    suspend fun loadEvent(uuid: String) {
        appStore.dispatch(SetEvent(EventsApi.getEvent(uuid)))
    }

    suspend fun loadEvents(name: String = "", offset: Int = 0, numberOfRows: Int = 10) {
        appStore.dispatch(SetEvents(EventsApi.getEvents(name, offset, numberOfRows)))
    }

    suspend fun loadListEvents() {
        appStore.dispatch(SetListEvents(EventsApi.getListEvents()))
    }

    suspend fun loadDebts(person: String, offset: Int = 0, numberOfRows: Int = 10) {
        appStore.dispatch(SetDebts(DebtsApi.getDebts(person = person)))
    }
}
