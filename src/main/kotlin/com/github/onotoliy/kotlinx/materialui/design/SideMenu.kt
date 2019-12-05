package com.github.onotoliy.kotlinx.materialui.design

import com.github.onotoliy.kotlinx.materialui.design.button.adButtonBase
import com.github.onotoliy.kotlinx.materialui.design.svg.ADIcon
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVG
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVGWrapper
import kotlinx.css.*
import kotlinx.css.properties.borderLeft
import kotlinx.html.BUTTON
import kotlinx.html.DIV
import react.RBuilder
import styled.*

fun RBuilder.adSideMenu(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
            alignItems = Align.flexStart
        }
        builder()
    }
}

fun RBuilder.adSideMenuItem(
    label: String,
    icon: ADIcon,
    isActive: Boolean = false,
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    val color = if (isActive) ADColor.FreshApple else ADColor.GrayCloud

    adButtonBase(fullWidth = true) {
        css {
            justifyContent = JustifyContent.flexStart
            height = 56.px
            border = "0"
            backgroundColor = Color.white
            padding(0.px, 4.px, 0.px, 0.px)

            val activeColor = rgba(25, 153, 60, 0.1)
            if (isActive) {
                backgroundColor = activeColor
                borderLeft(1.5.px, BorderStyle.solid, ADColor.FreshApple.hex())
            }

            hover { backgroundColor = activeColor }
            focus { backgroundColor = activeColor }
        }

        adSVGWrapper(padding = "0 12px 0 16px") {
            adSVG(icon, color)
        }
        adBodyR(16, color = color) {
            +label
        }

        builder()
    }
}
