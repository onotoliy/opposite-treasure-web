package com.github.onotoliy.opposite.treasure.app.sidebar

import com.github.onotoliy.kotlinx.materialui.design.adSideMenu
import com.github.onotoliy.kotlinx.materialui.design.adSideMenuItem
import com.github.onotoliy.kotlinx.materialui.design.svg.*
import com.github.onotoliy.opposite.treasure.app.AppContainerProps
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

interface AppSidebarComponentProps : RProps {
    var uProps: AppContainerProps
}

class AppSidebarComponent(props: AppSidebarComponentProps) : RComponent<AppSidebarComponentProps, RState>(props) {

    private fun isPathActive(path: String): Boolean {
        return props.uProps.routeProps.location.pathname.startsWith(path)
    }

    private fun navigateTo(path: String) {
        props.uProps.routeProps.history.push(path)
    }

    override fun RBuilder.render() {
        appSidebarWrapper {
            adSideMenu {
                adSideMenuItem(
                        label = "",
                        icon = adHome,
                        isActive = isPathActive(RoutePath.PROFILE_PAGE)
                ) {
                    attrs.onClickFunction = { navigateTo(RoutePath.PROFILE_PAGE) }
                }

                adSideMenuItem(
                        label = "",
                        icon = adUser,
                        isActive = isPathActive(RoutePath.DEPOSIT_PAGE)
                ) {
                    attrs.onClickFunction = { navigateTo(RoutePath.DEPOSIT_PAGE) }
                }

                adSideMenuItem(
                        label = "",
                        icon = adEvent,
                        isActive = isPathActive(RoutePath.EVENT_PAGE)
                ) {
                    attrs.onClickFunction = { navigateTo(RoutePath.EVENT_PAGE) }
                }

                adSideMenuItem(
                        label = "",
                        icon = adMoney,
                        isActive = isPathActive(RoutePath.TRANSACTION_PAGE)
                ) {
                    attrs.onClickFunction = { navigateTo(RoutePath.TRANSACTION_PAGE) }
                }
            }
        }
    }
}

fun RBuilder.appSidebarComponent(uProps: AppContainerProps) = child(AppSidebarComponent::class) {
    attrs.uProps = uProps
}
