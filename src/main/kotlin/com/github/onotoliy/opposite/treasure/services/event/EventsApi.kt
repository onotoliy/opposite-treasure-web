package com.github.onotoliy.opposite.treasure.services.event

import com.github.onotoliy.kotlinx.services.Network
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await
import kotlinx.serialization.list

object EventsApi {

    private const val API: String = "/api/treasure/v1/event"

    suspend fun getEvent(uuid: String): Event =
            Network.get("$API/$uuid", Event.serializer()).await()

    suspend fun getEvents(name: String = "", offset: Int = 0, numberOfRows: Int = 10): Page<Event> =
            Network.get(
                    "$API?name=$name&offset=$offset&numberOfRows=$numberOfRows",
                    Page.serializer(Event.serializer())).await()

    suspend fun getListEvents(): List<Option> =
            Network.get("$API/list", Option.serializer().list).await()

    suspend fun delete(uuid: String) =
            Network.delete("$API/$uuid").await()

    suspend fun create(event: Event): Event =
            Network.post(API, event, Event.serializer()).await()

    suspend fun update(event: Event): Event =
            Network.put(API, event, Event.serializer()).await()
}
