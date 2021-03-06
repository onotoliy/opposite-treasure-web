package com.github.onotoliy.opposite.treasure.services.cashbox

import com.github.onotoliy.opposite.treasure.store.actions.SetCashbox
import com.github.onotoliy.opposite.treasure.store.appStore

object CashboxService {

    suspend fun loadCasbox() {
        appStore.dispatch(SetCashbox(CashboxApi.getCashbox()))
    }
}
