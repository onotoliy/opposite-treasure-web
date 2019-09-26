package com.github.onotoliy.opposite.treasure.store.actions

import com.github.onotoliy.opposite.data.Cashbox
import com.github.onotoliy.opposite.data.page.Page
import com.github.onotoliy.opposite.treasure.models.RequestStatus
import redux.RAction

class SetCashbox(val cashbox: Cashbox) : RAction

class SetCashboxs(val status: RequestStatus, val cashboxs: Page<Cashbox> = Page()) : RAction