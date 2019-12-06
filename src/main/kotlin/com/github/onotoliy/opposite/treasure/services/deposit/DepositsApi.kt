package com.github.onotoliy.opposite.treasure.services.deposit

import com.github.onotoliy.kotlinx.services.Network
import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await

object DepositsApi {

    private const val API: String = "/api/treasure/v1/deposit"

    suspend fun getDeposit(person: String): Deposit =
            Network.get("$API/$person", Deposit.serializer()).await()

    suspend fun getDeposits(offset: Int = 0, numberOfRows: Int = 20): Page<Deposit> =
            Network.get("$API?offset=$offset&numberOfRows=$numberOfRows", Page.serializer(Deposit.serializer())).await()
}
