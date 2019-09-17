package com.github.onotoliy.opposite.treasure.store.actions

import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.page.Page
import com.github.onotoliy.opposite.treasure.models.RequestStatus
import redux.RAction

class SetEvent(val event: Event) : RAction

class SetListEvents(val status: RequestStatus, val listEvents: List<Option> = emptyList()) : RAction

class SetEvents(val status: RequestStatus, val events: Page<Event> = Page()) : RAction

class SetDebts(val status: RequestStatus, val debts: Page<Event> = Page()) : RAction