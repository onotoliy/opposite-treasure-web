package com.github.onotoliy.kotlinx.materialui.components.app

import kotlinx.coroutines.CoroutineScope
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import react.router.dom.RouteResultProps
import com.github.onotoliy.opposite.treasure.store.reducers.State

interface AppContainerProps : RProps {
    var scope: CoroutineScope
    var routeProps: RouteResultProps<RProps>
}

val appContainer: RClass<AppContainerProps> =
        rConnect<State, AppContainerProps, AppProps>(
                { state, ownProps ->
                    scope = ownProps.scope
                    routeProps = ownProps.routeProps
                    alertMessage = state.system.alertMessage
                    loadingCount = state.system.loading
                    currentUser = state.users.currentUser
                }
        )(App::class.js.unsafeCast<RClass<AppProps>>())
