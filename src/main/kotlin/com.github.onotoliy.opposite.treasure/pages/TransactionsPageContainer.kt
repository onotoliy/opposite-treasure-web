package com.github.onotoliy.opposite.treasure.pages

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
                }
        )(TransactionsPage::class.js.unsafeCast<RClass<TransactionsPageProps>>())