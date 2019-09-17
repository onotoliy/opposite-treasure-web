package com.github.onotoliy.opposite.treasure.services.deposits

import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.data.page.Page
import kotlinx.coroutines.await
import com.github.onotoliy.opposite.treasure.services.Network

object TransactionsApi {

    private const val API: String = "/api/treasure/v1/transaction"

    suspend fun getTransaction(uuid: String): Transaction =
            Network.request(Transaction.serializer(), Network.Method.GET, "$API/$uuid").await()

    suspend fun getTransactions(
        name: String = "",
        user: String = "",
        event: String = "",
        type: TransactionType = TransactionType.NONE,
        offset: Int = 0,
        numberOfRows: Int = 10
    ): Page<Transaction> =
            Network.request(
                    Page.serializer(Transaction.serializer()),
                    Network.Method.GET,
                    "$API?name=$name&user=$user&event=$event&type=$type&offset=$offset&numberOfRows=$numberOfRows").await()

    suspend fun delete(uuid: String) =
            Network.request(Transaction.serializer(), Network.Method.DELETE, "$API/$uuid").await()

    suspend fun create(transaction: Transaction): Transaction =
            Network.send(Transaction.serializer(), Network.Method.POST, transaction, API).await()

    suspend fun update(transaction: Transaction): Transaction =
            Network.send(Transaction.serializer(), Network.Method.POST, transaction, API).await()
}