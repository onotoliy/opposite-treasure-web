package com.github.onotoliy.opposite.treasure.services.deposits

import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await
import kotlinx.serialization.list
import com.github.onotoliy.opposite.treasure.services.Network

object EventsApi {

    private const val API: String = "/api/treasure/v1/event"

    suspend fun getEvent(uuid: String): Event =
            Network.request(Event.serializer(), Network.Method.GET, "$API/$uuid").await()

    suspend fun getEvents(): Page<Event> =
            Network.request(Page.serializer(Event.serializer()), Network.Method.GET, API).await()

    suspend fun getListEvents(): List<Option> =
            Network.request(Option.serializer().list, Network.Method.GET, "$API/list").await()

    suspend fun getDebts(person: String): Page<Event> =
            Network.request(Page.serializer(Event.serializer()), Network.Method.GET, "$API/person/$person/debts").await()

    suspend fun delete(uuid: String) =
            Network.request(Event.serializer(), Network.Method.DELETE, "$API/$uuid").await()

    suspend fun create(event: Event): Event =
            Network.send(Event.serializer(), Network.Method.POST, event, API).await()

    suspend fun update(event: Event): Event =
            Network.send(Event.serializer(), Network.Method.POST, event, API).await()
}