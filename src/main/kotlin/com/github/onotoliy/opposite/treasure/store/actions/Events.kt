package com.github.onotoliy.opposite.treasure.store.actions

import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.data.page.Page
import redux.RAction

class SetEvent(val event: Event) : RAction

class SetListEvents(val listEvents: List<Option> = emptyList()) : RAction

class SetEvents(val events: Page<Event> = Page()) : RAction

class SetDebts(val debts: Page<Event> = Page()) : RAction