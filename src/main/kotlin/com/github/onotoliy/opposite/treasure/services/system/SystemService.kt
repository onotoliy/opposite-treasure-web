package com.github.onotoliy.opposite.treasure.services.system

import com.github.onotoliy.opposite.treasure.store.actions.SetAlert
import com.github.onotoliy.opposite.treasure.store.actions.SetLoading
import com.github.onotoliy.opposite.treasure.store.appStore

object SystemService {

    fun setAlert(message: String) {
        appStore.dispatch(SetAlert(message))
    }

    fun setLoading(loading: Boolean) {
        appStore.dispatch(SetLoading(loading))
    }
}
