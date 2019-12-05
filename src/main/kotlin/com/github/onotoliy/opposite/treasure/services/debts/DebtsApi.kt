package com.github.onotoliy.opposite.treasure.services.debts

import com.github.onotoliy.kotlinx.services.Network
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await

object DebtsApi {

    private const val API: String = "/api/treasure/v1/debt"

    suspend fun getDebts(person: String): Page<Event> =
        Network.get("$API/person/$person", Page.serializer(Event.serializer())).await()
}
