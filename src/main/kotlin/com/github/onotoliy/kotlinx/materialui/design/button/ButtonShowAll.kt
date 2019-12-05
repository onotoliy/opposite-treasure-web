package com.github.onotoliy.kotlinx.materialui.design.button

import com.github.onotoliy.kotlinx.materialui.design.*
import com.github.onotoliy.kotlinx.materialui.design.svg.ADIcon
import com.github.onotoliy.kotlinx.materialui.design.svg.adIconArrowRight
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVG
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVGWrapper
import kotlinx.css.*
import kotlinx.html.BUTTON
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css

fun RBuilder.adButtonShowAll(
    total: Int = -1,
    label: String = "Показать все",
    color: ADColor = ADColor.FreshApple,
    icon: ADIcon = adIconArrowRight,
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButtonBase(width = "160px") {
        css {
            padding(0.px)
            backgroundColor = ADColor.White.hex()
            border = "0"
            justifyContent = JustifyContent.flexStart
        }

        adSubtitleB(14, color = color) {
            var text = label
            if (total > 0) text += " ($total)"
            +text
        }
        adSVGWrapper(padding = "0 0 0 4px") {
            adSVG(icon, color)
        }

        builder()
    }
}
