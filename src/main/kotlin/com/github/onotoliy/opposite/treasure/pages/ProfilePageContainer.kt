package com.github.onotoliy.opposite.treasure.pages

import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultHistory
import com.github.onotoliy.opposite.treasure.store.reducers.State

interface ProfilePageContainerProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
}

val profilePageContainer: RClass<ProfilePageContainerProps> =
        rConnect<State, ProfilePageContainerProps, ProfilePageProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    user = state.users.currentUser
                    deposit = state.deposits.deposit
                    debts = state.events.debts
                    cashbox = state.cashbox.cashbox
                    transactions = state.transactions.transactions
                }
        )(ProfilePage::class.js.unsafeCast<RClass<ProfilePageProps>>())