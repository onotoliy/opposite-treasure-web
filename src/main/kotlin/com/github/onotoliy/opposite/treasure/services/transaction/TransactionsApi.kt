package com.github.onotoliy.opposite.treasure.services.transaction

import com.github.onotoliy.kotlinx.services.Network
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await

object TransactionsApi {

    private const val API: String = "/api/treasure/v1/transaction"

    suspend fun getTransaction(uuid: String): Transaction =
            Network.get("$API/$uuid", Transaction.serializer()).await()

    suspend fun getTransactions(
        name: String = "",
        user: String = "",
        event: String = "",
        type: TransactionType = TransactionType.NONE,
        offset: Int = 0,
        numberOfRows: Int = 10
    ): Page<Transaction> =
            Network.get(
                    "$API?name=$name&user=$user&event=$event&type=$type&offset=$offset&numberOfRows=$numberOfRows",
                    Page.serializer(Transaction.serializer())).await()

    suspend fun delete(uuid: String) =
            Network.delete("$API/$uuid").await()

    suspend fun create(event: Transaction): Transaction =
            Network.post(API, event, Transaction.serializer()).await()

    suspend fun update(event: Transaction): Transaction =
            Network.put(API, event, Transaction.serializer()).await()
}