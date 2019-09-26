package com.github.onotoliy.opposite.treasure.store.reducers

import com.github.onotoliy.opposite.data.Cashbox
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import com.github.onotoliy.opposite.treasure.store.actions.SetCashbox
import com.github.onotoliy.opposite.treasure.store.actions.SetCashboxs
import com.github.onotoliy.opposite.treasure.utils.toReqListResult
import redux.RAction

data class CashboxReducer(
    val cashbox: Cashbox = Cashbox(),
    val cashboxs: ReqListResult<Cashbox> = ReqListResult()
)

fun cashbox(state: CashboxReducer = CashboxReducer(), action: RAction): CashboxReducer = when (action) {
    is SetCashbox -> state.copy(cashbox = action.cashbox)
    is SetCashboxs -> state.copy(cashboxs = action.cashboxs.toReqListResult(action.status))
    else -> state
}