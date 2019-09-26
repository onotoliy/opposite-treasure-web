package com.github.onotoliy.opposite.treasure.store.actions

import com.github.onotoliy.opposite.data.Cashbox
import com.github.onotoliy.opposite.data.page.Page
import redux.RAction

class SetCashbox(val cashbox: Cashbox) : RAction

class SetCashboxs(val cashboxs: Page<Cashbox> = Page()) : RAction