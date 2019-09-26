package com.github.onotoliy.opposite.treasure.pages

import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory
import com.github.onotoliy.opposite.treasure.store.reducers.State

interface EventEditPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
}

val eventEditPageContainer: RClass<EventEditPageContainerProps> =
        rConnect<State, EventEditPageContainerProps, EventEditPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    history = ownProps.history
                    uuid = ownProps.uuid
                    author = state.users.currentUser
                    event = state.events.event
                }
        )(EventEditPage::class.js.unsafeCast<RClass<EventEditPageProps>>())