package com.github.onotoliy.opposite.treasure.components.app

import com.github.onotoliy.opposite.treasure.components.svg.svgSettingsGear
import com.github.onotoliy.opposite.treasure.components.MDrawerVariant
import com.github.onotoliy.opposite.treasure.components.list.mList
import com.github.onotoliy.opposite.treasure.components.list.mListItem
import com.github.onotoliy.opposite.treasure.components.mDrawer
import com.github.onotoliy.opposite.treasure.components.mTooltip
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
        mTooltip("Депозит") {
            mListItem {
                navLink(RoutePath.DEPOSIT_PAGE) {
                    svgSettingsGear(location.pathname.startsWith(RoutePath.DEPOSIT_PAGE))
                }
            }
        }
        mTooltip("Мероприятия") {
            mListItem {
                navLink(RoutePath.EVENT_PAGE) {
                    svgSettingsGear(location.pathname.startsWith(RoutePath.EVENT_PAGE))
                }
            }
        }
        mTooltip("Транзакции") {
            mListItem {
                navLink(RoutePath.TRANSACTION_PAGE) {
                    svgSettingsGear(location.pathname.startsWith(RoutePath.TRANSACTION_PAGE))
                }
            }
        }
    }
}