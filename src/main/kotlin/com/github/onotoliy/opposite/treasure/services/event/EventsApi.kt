package com.github.onotoliy.opposite.treasure.services.event

import com.github.onotoliy.kotlinx.services.NewNetwork
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await
import kotlinx.serialization.list

object EventsApi {

    private const val API: String = "/api/treasure/v1/event"

    suspend fun getEvent(uuid: String): Event =
            NewNetwork.get("$API/$uuid", Event.serializer()).await()

    suspend fun getEvents(name: String = "", offset: Int = 0, numberOfRows: Int = 10): Page<Event> =
            NewNetwork.get(
                    "$API?name=$name&offset=$offset&numberOfRows=$numberOfRows",
                    Page.serializer(Event.serializer())).await()

    suspend fun getListEvents(): List<Option> =
            NewNetwork.get("$API/list", Option.serializer().list).await()

    suspend fun delete(uuid: String) =
            NewNetwork.delete("$API/$uuid").await()

    suspend fun create(event: Event): Event =
            NewNetwork.post(API, event, Event.serializer()).await()

    suspend fun update(event: Event): Event =
            NewNetwork.put(API, event, Event.serializer()).await()
}