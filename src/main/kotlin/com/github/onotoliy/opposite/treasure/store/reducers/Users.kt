package com.github.onotoliy.opposite.treasure.store.reducers

import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.treasure.store.actions.SetCurrentRoles
import redux.RAction
import com.github.onotoliy.opposite.treasure.store.actions.SetCurrentUser
import com.github.onotoliy.opposite.treasure.store.actions.SetListUsers
import com.github.onotoliy.opposite.treasure.store.actions.SetUser

data class UsersReducer(
    val user: Option = Option(),
    val currentUser: Option = Option(),
    val currentRoles: List<String> = emptyList(),
    val listUsers: List<Option> = emptyList()
)

fun users(state: UsersReducer = UsersReducer(), action: RAction): UsersReducer = when (action) {
    is SetUser -> state.copy(user = action.user)
    is SetCurrentRoles -> state.copy(currentRoles = action.currentRoles)
    is SetCurrentUser -> state.copy(currentUser = action.currentUser)
    is SetListUsers -> state.copy(listUsers = action.listUsers.toList())
    else -> state
}