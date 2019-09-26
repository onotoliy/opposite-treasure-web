package com.github.onotoliy.opposite.treasure.services.user

import com.github.onotoliy.opposite.data.Option
import kotlinx.coroutines.await
import kotlinx.serialization.list
import com.github.onotoliy.kotlinx.services.Network

object UsersApi {

    private const val API: String = "/api/treasure/v1/user"

    suspend fun getCurrentUser(): Option =
            Network.request(Option.serializer(), Network.Method.GET, "$API/current").await()

    suspend fun getUser(uuid: String): Option =
            Network.request(Option.serializer(), Network.Method.GET, "$API/$uuid").await()

    suspend fun getListUsers(): List<Option> =
            Network.request(Option.serializer().list, Network.Method.GET, "$API/list").await()
}