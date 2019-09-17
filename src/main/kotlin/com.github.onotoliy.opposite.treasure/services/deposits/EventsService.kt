package com.github.onotoliy.opposite.treasure.services.deposits

import com.github.onotoliy.opposite.treasure.models.RequestStatus
import com.github.onotoliy.opposite.treasure.store.actions.SetDebts
import com.github.onotoliy.opposite.treasure.store.actions.SetEvent
import com.github.onotoliy.opposite.treasure.store.actions.SetEvents
import com.github.onotoliy.opposite.treasure.store.actions.SetListEvents
import com.github.onotoliy.opposite.treasure.store.appStore

object EventsService {

    suspend fun loadEvent(uuid: String) {
        appStore.dispatch(SetEvent(EventsApi.getEvent(uuid)))
    }

    suspend fun loadEvents(name: String = "") {
        appStore.dispatch(SetEvents(RequestStatus.SUCCESS, EventsApi.getEvents()))
    }

    suspend fun loadListEvents() {
        appStore.dispatch(SetListEvents(RequestStatus.SUCCESS, EventsApi.getListEvents()))
    }

    suspend fun loadDebts(person: String) {
        appStore.dispatch(SetDebts(RequestStatus.SUCCESS, EventsApi.getDebts(person = person)))
    }
}