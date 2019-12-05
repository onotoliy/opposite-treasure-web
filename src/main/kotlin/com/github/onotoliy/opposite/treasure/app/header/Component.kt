package com.github.onotoliy.opposite.treasure.app.header

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.adSubtitleB
import com.github.onotoliy.kotlinx.materialui.design.button.adButtonText
import com.github.onotoliy.kotlinx.materialui.svg.svgLogoOpposite
import com.github.onotoliy.opposite.treasure.app.AppContainerProps
import kotlinx.css.marginBottom
import kotlinx.css.px
import kotlinx.html.js.onClickFunction
import react.RBuilder

fun RBuilder.appHeaderComponent(
    uProps: AppContainerProps,
    logout: () -> Unit
) {

    appHeaderWrapper {
        css.marginBottom = 15.px
        logoWrapper {
            svgLogoOpposite()
        }
        endAreaWrapper {
            adSubtitleB(color = ADColor.GrayCloud, margin = "0px 20px") { +uProps.currentUser.name }

            adButtonText("Выйти", color = ADColor.DarkSky) {
                attrs.onClickFunction = { logout() }
            }
        }
    }
}
