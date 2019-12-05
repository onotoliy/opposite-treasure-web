package com.github.onotoliy.opposite.treasure.services.transaction

import com.github.onotoliy.opposite.data.TransactionType
import com.github.onotoliy.opposite.treasure.store.actions.SetTransaction
import com.github.onotoliy.opposite.treasure.store.actions.SetTransactions
import com.github.onotoliy.opposite.treasure.store.appStore

object TransactionsService {

    suspend fun loadTransaction(uuid: String) {
        appStore.dispatch(SetTransaction(TransactionsApi.getTransaction(uuid)))
    }

    suspend fun loadTransactions(
        name: String = "",
        user: String = "",
        event: String = "",
        type: TransactionType = TransactionType.NONE,
        offset: Int = 0,
        numberOfRows: Int = 10
    ) {
        appStore.dispatch(SetTransactions(
            TransactionsApi.getTransactions(name, user, event, type, offset, numberOfRows)))
    }
}
