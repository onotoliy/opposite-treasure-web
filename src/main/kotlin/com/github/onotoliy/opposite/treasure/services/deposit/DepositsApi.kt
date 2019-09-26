package com.github.onotoliy.opposite.treasure.services.deposit

import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await
import com.github.onotoliy.kotlinx.services.Network

object DepositsApi {

    private const val API: String = "/api/treasure/v1/deposit"

    suspend fun getDeposit(person: String): Deposit =
            Network.request(Deposit.serializer(), Network.Method.GET, "$API/$person").await()

    suspend fun getDeposits(): Page<Deposit> =
            Network.request(Page.serializer(Deposit.serializer()), Network.Method.GET, API).await()
}
