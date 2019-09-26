package com.github.onotoliy.opposite.treasure.store.reducers

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.kotlinx.toReqListResult
import com.github.onotoliy.opposite.data.Cashbox
import com.github.onotoliy.opposite.treasure.store.actions.SetCashbox
import com.github.onotoliy.opposite.treasure.store.actions.SetCashboxs
import redux.RAction

data class CashboxReducer(
    val cashbox: Cashbox = Cashbox(),
    val cashboxs: ReqListResult<Cashbox> = ReqListResult()
)

fun cashbox(state: CashboxReducer = CashboxReducer(), action: RAction): CashboxReducer = when (action) {
    is SetCashbox -> state.copy(cashbox = action.cashbox)
    is SetCashboxs -> state.copy(cashboxs = action.cashboxs.toReqListResult())
    else -> state
}