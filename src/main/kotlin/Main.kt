import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.materialui.mThemeProvider
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.opposite.treasure.app.appConnect
import com.github.onotoliy.opposite.treasure.store.appStore
import kotlin.browser.document
import kotlin.browser.window
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import react.RProps
import react.dom.render
import react.redux.provider
import react.router.dom.browserRouter
import react.router.dom.route

private class Application : CoroutineScope {
    override val coroutineContext: CoroutineContext = Job()

    fun start() {
        Auth.onLoginFunction = {
            Configuration.scope = this@Application

            this@Application.launch {
                Configuration.initConfig {
                    val rootDiv = document.getElementById("root")
                    render(rootDiv) {
                        provider(appStore) {
                            mThemeProvider {
                                browserRouter {
                                    route<RProps>("/") { routeProps ->
                                        Configuration.history = routeProps.history

                                        appConnect {
                                            attrs.routeProps = routeProps
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Auth.login()
    }
}

fun main() {
    window.onload = {
        Application().start()
    }
}
