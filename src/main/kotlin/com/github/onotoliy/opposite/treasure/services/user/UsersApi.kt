package com.github.onotoliy.opposite.treasure.services.user

import com.github.onotoliy.kotlinx.services.NewNetwork
import com.github.onotoliy.opposite.data.Option
import kotlinx.coroutines.await
import kotlinx.serialization.list

object UsersApi {

    private const val API: String = "/api/treasure/v1/user"

    suspend fun getCurrentUser(): Option =
            NewNetwork.get("$API/current", Option.serializer()).await()

    suspend fun getUser(uuid: String): Option =
            NewNetwork.get("$API/$uuid", Option.serializer()).await()

    suspend fun getListUsers(): List<Option> =
            NewNetwork.get("$API/list", Option.serializer().list).await()
}