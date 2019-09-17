package com.github.onotoliy.opposite.treasure.store.actions

import redux.RAction

class SetLoading(val loading: Boolean) : RAction

class SetAlert(val message: String) : RAction