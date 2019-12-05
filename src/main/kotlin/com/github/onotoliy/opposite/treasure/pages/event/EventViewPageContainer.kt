package com.github.onotoliy.opposite.treasure.pages.event

import com.github.onotoliy.opposite.treasure.store.reducers.State
import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory

interface EventViewPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
}

val eventViewPageContainer: RClass<EventViewPageContainerProps> =
        rConnect<State, EventViewPageContainerProps, EventViewPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    history = ownProps.history
                    uuid = ownProps.uuid
                    event = state.events.event
                    roles = state.users.currentRoles
                }
        )(EventViewPage::class.js.unsafeCast<RClass<EventViewPageProps>>())
