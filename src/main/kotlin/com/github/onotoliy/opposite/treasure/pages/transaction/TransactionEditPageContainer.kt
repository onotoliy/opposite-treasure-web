package com.github.onotoliy.opposite.treasure.pages.transaction

import com.github.onotoliy.opposite.treasure.store.reducers.State
import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory

interface TransactionEditPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
}

val transactionEditPageContainer: RClass<TransactionEditPageContainerProps> =
        rConnect<State, TransactionEditPageContainerProps, TransactionEditPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    history = ownProps.history
                    uuid = ownProps.uuid
                    transaction = state.transactions.transaction
                    author = state.users.currentUser
                    events = state.events.listEvents
                    persons = state.users.listUsers
                }
        )(TransactionEditPage::class.js.unsafeCast<RClass<TransactionEditPageProps>>())
