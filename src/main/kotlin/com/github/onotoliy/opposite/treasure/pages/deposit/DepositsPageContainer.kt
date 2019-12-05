package com.github.onotoliy.opposite.treasure.pages.deposit

import com.github.onotoliy.opposite.treasure.store.reducers.State
import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory

interface DepositsPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
}

val depositsPageContainer: RClass<DepositsPageContainerProps> =
        rConnect<State, DepositsPageContainerProps, DepositsPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    deposits = state.deposits.deposits
                }
        )(DepositsPage::class.js.unsafeCast<RClass<DepositsPageProps>>())
