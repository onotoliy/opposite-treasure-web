package com.github.onotoliy.opposite.treasure.pages.transaction

import com.github.onotoliy.opposite.treasure.store.reducers.State
import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory

interface TransactionViewPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
}

val transactionViewPageContainer: RClass<TransactionViewPageContainerProps> =
        rConnect<State, TransactionViewPageContainerProps, TransactionViewPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    history = ownProps.history
                    uuid = ownProps.uuid
                    transaction = state.transactions.transaction
                    roles = state.users.currentRoles
                }
        )(TransactionViewPage::class.js.unsafeCast<RClass<TransactionViewPageProps>>())
