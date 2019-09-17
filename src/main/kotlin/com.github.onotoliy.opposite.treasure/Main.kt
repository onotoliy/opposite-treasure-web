package com.github.onotoliy.opposite.treasure

import com.github.onotoliy.opposite.treasure.components.app.appContainer
import com.github.onotoliy.opposite.treasure.components.currentTheme
import com.github.onotoliy.opposite.treasure.components.mMuiThemeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import react.RProps
import react.dom.render
import react.redux.provider
import react.router.dom.browserRouter
import react.router.dom.route
import ru.playa.kotlinx.keycloak.js.Auth
import com.github.onotoliy.opposite.treasure.store.appStore
import kotlin.browser.document
import kotlin.browser.window
import kotlin.coroutines.CoroutineContext

private class Application : CoroutineScope {
    override val coroutineContext: CoroutineContext = Job()

    fun start() {
        Auth.onLoginFunction = {
            val rootDiv = document.getElementById("root")
            render(rootDiv) {
                provider(appStore) {
                    mMuiThemeProvider(currentTheme) {
                        browserRouter {
                            route<RProps>("/") { routeProps ->
                                appContainer {
                                    attrs.scope = this@Application
                                    attrs.routeProps = routeProps
                                }
                            }
                        }
                    }
                }
            }
        }
        Auth.timeout = 60
        Auth.login()
    }
}

fun main() {
    window.onload = {
        Application().start()
    }
}