package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.opposite.treasure.app.alert.appAlertComponent
import com.github.onotoliy.opposite.treasure.app.header.appHeaderComponent
import com.github.onotoliy.opposite.treasure.app.loader.appLoaderComponent
import com.github.onotoliy.opposite.treasure.app.sidebar.appSidebarComponent
import com.github.onotoliy.opposite.treasure.routes.routes
import react.RBuilder

fun RBuilder.appView(
    uProps: AppContainerProps,
    initialized: Boolean,
    logout: () -> Unit
) {
    appBodyWrapper {
        appLoaderComponent(uProps.loadingCount)

        appWorkspaceWrapper {
            appAlertComponent(uProps.alertMessage)
            appHeaderComponent(uProps, logout)

            sidebarAndContentWrapper {
                if (initialized) {
                    appSidebarComponent(uProps)
                }

                appContentWrapper {
                    if (initialized) {
                        routes(uProps.scope)
                    }
                }
            }
        }
    }
}
