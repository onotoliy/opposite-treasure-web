package com.github.onotoliy.kotlinx.materialui.design.button

import com.github.onotoliy.kotlinx.materialui.design.*
import com.github.onotoliy.kotlinx.materialui.design.svg.ADIcon
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVG
import kotlinx.css.*
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledButton

fun RBuilder.adButtonIcon(
    icon: ADIcon,
    color: ADColor = ADColor.DarkSky,
    disabled: Boolean = false,
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    styledButton {
        attrs {
            this.type = ButtonType.button
            this.disabled = disabled
        }
        css {
            backgroundColor = Color.inherit
            border = "0"
            padding(0.px)
            outline = Outline.none
            borderRadius = 4.px

            if (disabled) {
                opacity = 0.4
            } else {
                cursor = Cursor.pointer
                hover { boxShadow += ADBoxShadowEasy }
                focus { boxShadow += ADBoxShadowEasy }
            }
        }
        adSVG(icon, color)

        builder()
    }
}
