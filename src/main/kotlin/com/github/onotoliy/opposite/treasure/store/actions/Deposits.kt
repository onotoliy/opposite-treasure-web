package com.github.onotoliy.opposite.treasure.store.actions

import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.data.page.Page
import redux.RAction

class SetDeposit(val deposit: Deposit) : RAction

class SetDeposits(val deposits: Page<Deposit> = Page()) : RAction