package com.github.onotoliy.opposite.treasure.services.user

import com.github.onotoliy.opposite.treasure.store.actions.SetCurrentRoles
import com.github.onotoliy.opposite.treasure.store.actions.SetCurrentUser
import com.github.onotoliy.opposite.treasure.store.actions.SetListUsers
import com.github.onotoliy.opposite.treasure.store.actions.SetUser
import com.github.onotoliy.opposite.treasure.store.appStore

object UsersService {

    suspend fun loadUser(uuid: String) {
        appStore.dispatch(SetUser(UsersApi.getUser(uuid)))
    }

    suspend fun loadCurrentUser() {
        appStore.dispatch(SetCurrentUser(UsersApi.getCurrentUser()))
    }

    suspend fun loadCurrentRoles() {
        appStore.dispatch(SetCurrentRoles(UsersApi.getCurrentRoles()))
    }

    suspend fun loadListUsers() {
        appStore.dispatch(SetListUsers(UsersApi.getListUsers()))
    }
}