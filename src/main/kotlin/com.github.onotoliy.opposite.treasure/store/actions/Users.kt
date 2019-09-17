package com.github.onotoliy.opposite.treasure.store.actions

import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.treasure.models.RequestStatus
import redux.RAction

class SetCurrentUser(val currentUser: Option) : RAction

class SetUser(val user: Option) : RAction

class SetListUsers(val status: RequestStatus, val listUsers: List<Option> = emptyList()) : RAction
