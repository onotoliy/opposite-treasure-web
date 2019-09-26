package com.github.onotoliy.opposite.treasure.pages.transaction

import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory
import com.github.onotoliy.opposite.treasure.store.reducers.State

interface TransactionsPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
}

val transactionsPageContainer: RClass<TransactionsPageContainerProps> =
        rConnect<State, TransactionsPageContainerProps, TransactionsPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    transactions = state.transactions.transactions
                    events = state.events.listEvents
                    persons = state.users.listUsers
                }
        )(TransactionsPage::class.js.unsafeCast<RClass<TransactionsPageProps>>())