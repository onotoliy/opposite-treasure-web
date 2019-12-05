package com.github.onotoliy.opposite.treasure.pages.deposit

import com.github.onotoliy.opposite.treasure.store.reducers.State
import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory

interface DepositViewPageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var person: String
}

val depositViewPageContainer: RClass<DepositViewPageContainerProps> =
        rConnect<State, DepositViewPageContainerProps, DepositViewPageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    person = ownProps.person
                    deposit = state.deposits.deposit
                    contributions = state.transactions.transactions
                    debts = state.events.debts
                }
        )(DepositViewPage::class.js.unsafeCast<RClass<DepositViewPageProps>>())
