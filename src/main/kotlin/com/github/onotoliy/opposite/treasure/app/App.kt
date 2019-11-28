package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.opposite.data.Option
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.RouteResultProps
import com.github.onotoliy.opposite.treasure.routes.routes
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.opposite.treasure.services.user.UsersService
import styled.styledDiv

interface AppProps : RProps {
    var scope: CoroutineScope
    var routeProps: RouteResultProps<RProps>
    var loadingCount: Int
    var alertMessage: String
    var currentUser: Option
}

class App(props: AppProps) : RComponent<AppProps, RState>(props) {
    override fun componentDidMount() {
        props.scope.launch {
            Configuration.initConfig()
            UsersService.loadCurrentUser()
            UsersService.loadCurrentRoles()
        }
    }

    private fun logout() {
        props.routeProps.history.push("/")
        Auth.logout()
    }

    private val accountName
        get() = props.currentUser.name

    override fun RBuilder.render() {
        styledDiv {
            css.display = Display.flex
            appLoader(props.loadingCount)
            appAlert(props.alertMessage)
            appHeader(accountName, ::logout)
            appSidebar(props.routeProps.location)

            styledDiv {
                css.flexGrow = 1.0
                appHeaderSpacer()
                styledDiv {
                    css.margin(32.px)
                    routes(props.scope)
                }
            }
        }
    }
}
