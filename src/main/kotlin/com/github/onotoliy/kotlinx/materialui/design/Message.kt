package com.github.onotoliy.kotlinx.materialui.design

import com.github.onotoliy.kotlinx.materialui.design.svg.adIconMistake
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVG
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVGWrapper
import kotlinx.css.padding
import react.RBuilder
import styled.DIVBuilder
import styled.css

fun RBuilder.adMessageError(text: String = "", builder: DIVBuilder = {}) {
    flexRow {
        css {
            padding = "4px 0"
        }
        adSVGWrapper(padding = "0 8px 0 0") {
            adSVG(adIconMistake, ADColor.Tomato)
        }

        adBodyR(color = ADColor.Tomato) {
            +text
        }
        builder()
    }
}
