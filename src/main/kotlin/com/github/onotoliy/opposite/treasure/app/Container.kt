package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.opposite.data.Option
import com.github.onotoliy.opposite.treasure.services.user.UsersService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.RouteResultProps

interface AppContainerProps : RProps {
    var routeProps: RouteResultProps<RProps>
    var scope: CoroutineScope
    var loadingCount: Int
    var alertMessage: String
    var currentUser: Option
}

class AppContainer(props: AppContainerProps) : RComponent<AppContainerProps, RState>(props) {

    override fun componentDidMount() {
        initData()
    }

    private fun initData() {
        Configuration.scope.launch {
            UsersService.loadCurrentUser()
            UsersService.loadCurrentRoles()
        }
    }

    private fun logout() {
        props.routeProps.history.push("/")
        Auth.logout()
    }

    private val initialized
        get() = props.currentUser.uuid.isNotBlank()

    override fun RBuilder.render() {
        appView(
                uProps = props,
                initialized = initialized,
                logout = ::logout
        )
    }
}
