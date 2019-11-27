package com.github.onotoliy.opposite.treasure.pages.event

import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory
import com.github.onotoliy.opposite.treasure.store.reducers.State

interface EventsPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
}

val eventsPageContainer: RClass<EventsPageContainerProps> =
        rConnect<State, EventsPageContainerProps, EventsPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    events = state.events.events
                    roles = state.users.currentRoles
                }
        )(EventsPage::class.js.unsafeCast<RClass<EventsPageProps>>())