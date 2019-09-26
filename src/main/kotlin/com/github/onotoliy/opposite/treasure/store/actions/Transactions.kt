package com.github.onotoliy.opposite.treasure.store.actions

import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.data.page.Page
import com.github.onotoliy.opposite.treasure.models.RequestStatus
import redux.RAction

class SetTransaction(val transaction: Transaction) : RAction

class SetTransactions(val status: RequestStatus, val transactions: Page<Transaction> = Page()) : RAction