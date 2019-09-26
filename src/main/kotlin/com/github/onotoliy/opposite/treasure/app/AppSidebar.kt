package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.kotlinx.components.MDrawerVariant
import com.github.onotoliy.kotlinx.components.list.mList
import com.github.onotoliy.kotlinx.components.list.mListItem
import com.github.onotoliy.kotlinx.components.mDrawer
import com.github.onotoliy.kotlinx.components.mTooltip
import com.github.onotoliy.kotlinx.components.svg.svgClients
import com.github.onotoliy.kotlinx.components.svg.svgCoinStack
import com.github.onotoliy.kotlinx.components.svg.svgHangingCalendar
import com.github.onotoliy.kotlinx.components.svg.svgWorld
import kotlinx.css.px
import kotlinx.css.width
import react.RBuilder
import react.router.dom.RouteResultLocation
import react.router.dom.navLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath

fun RBuilder.appSidebar(
    location: RouteResultLocation
) = mDrawer(true, variant = MDrawerVariant.permanent) {
    css.width = 52.px
    appHeaderSpacer()
    mList {
        mTooltip("Профиль") {
            mListItem {
                navLink(RoutePath.PROFILE_PAGE) {
                    svgWorld(location.pathname.startsWith(RoutePath.PROFILE_PAGE))
                }
            }
        }
        mTooltip("Депозит") {
            mListItem {
                navLink(RoutePath.DEPOSIT_PAGE) {
                    svgClients(location.pathname.startsWith(RoutePath.DEPOSIT_PAGE))
                }
            }
        }
        mTooltip("Мероприятия") {
            mListItem {
                navLink(RoutePath.EVENT_PAGE) {
                    svgHangingCalendar(location.pathname.startsWith(RoutePath.EVENT_PAGE))
                }
            }
        }
        mTooltip("Транзакции") {
            mListItem {
                navLink(RoutePath.TRANSACTION_PAGE) {
                    svgCoinStack(location.pathname.startsWith(RoutePath.TRANSACTION_PAGE))
                }
            }
        }
    }
}