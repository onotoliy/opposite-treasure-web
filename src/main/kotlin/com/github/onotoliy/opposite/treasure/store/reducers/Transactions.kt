package com.github.onotoliy.opposite.treasure.store.reducers

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.opposite.data.Transaction
import redux.RAction
import com.github.onotoliy.opposite.treasure.store.actions.SetTransaction
import com.github.onotoliy.opposite.treasure.store.actions.SetTransactions
import com.github.onotoliy.kotlinx.toReqListResult

data class TransactionsReducer(
    val transaction: Transaction = Transaction(),
    val transactions: ReqListResult<Transaction> = ReqListResult()
)

fun transactions(state: TransactionsReducer = TransactionsReducer(), action: RAction): TransactionsReducer = when (action) {
    is SetTransaction -> state.copy(transaction = action.transaction)
    is SetTransactions -> state.copy(transactions = action.transactions.toReqListResult())
    else -> state
}