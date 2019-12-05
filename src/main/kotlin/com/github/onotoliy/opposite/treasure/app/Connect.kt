package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.opposite.treasure.store.reducers.State
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultProps

interface AppConnectProps : RProps {
    var routeProps: RouteResultProps<RProps>
}

val appConnect: RClass<AppConnectProps> =
        rConnect<State, AppConnectProps, AppContainerProps>(
                { state, ownProps ->
                    routeProps = ownProps.routeProps
                    alertMessage = state.system.alertMessage
                    loadingCount = state.system.loading
                    currentUser = state.users.currentUser
                }
        )(AppContainer::class.js.unsafeCast<RClass<AppContainerProps>>())
