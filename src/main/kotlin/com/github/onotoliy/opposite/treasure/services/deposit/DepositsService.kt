package com.github.onotoliy.opposite.treasure.services.deposit

import com.github.onotoliy.opposite.treasure.store.actions.SetDeposit
import com.github.onotoliy.opposite.treasure.store.actions.SetDeposits
import com.github.onotoliy.opposite.treasure.store.appStore

object DepositsService {

    suspend fun loadDeposit(person: String) {
        appStore.dispatch(SetDeposit(DepositsApi.getDeposit(person)))
    }

    suspend fun loadDeposits() {
        appStore.dispatch(SetDeposits(DepositsApi.getDeposits()))
    }
}