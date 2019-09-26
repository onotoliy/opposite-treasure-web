package com.github.onotoliy.opposite.treasure.store.reducers

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.treasure.store.actions.SetDeposit
import com.github.onotoliy.opposite.treasure.store.actions.SetDeposits
import redux.RAction
import com.github.onotoliy.kotlinx.toReqListResult

data class DepositsReducer(
    val deposit: Deposit = Deposit(),
    val deposits: ReqListResult<Deposit> = ReqListResult()
)

fun deposits(state: DepositsReducer = DepositsReducer(), action: RAction): DepositsReducer = when (action) {
    is SetDeposit -> state.copy(deposit = action.deposit)
    is SetDeposits -> state.copy(deposits = action.deposits.toReqListResult())
    else -> state
}