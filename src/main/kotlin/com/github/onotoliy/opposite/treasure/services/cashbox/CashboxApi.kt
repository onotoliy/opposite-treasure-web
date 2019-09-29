package com.github.onotoliy.opposite.treasure.services.cashbox

import com.github.onotoliy.kotlinx.services.NewNetwork
import com.github.onotoliy.opposite.data.Cashbox
import kotlinx.coroutines.await

object CashboxApi {

    private const val API: String = "/api/treasure/v1/cashbox"

    suspend fun getCashbox(): Cashbox =
        NewNetwork.get(API, Cashbox.serializer()).await()
}