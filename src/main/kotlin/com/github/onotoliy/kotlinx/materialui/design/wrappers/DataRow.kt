package com.github.onotoliy.kotlinx.materialui.design.wrappers

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.adBodyR
import com.github.onotoliy.kotlinx.materialui.design.adSmallBody
import com.github.onotoliy.kotlinx.materialui.design.flexRow
import kotlinx.css.*
import react.RBuilder
import styled.DIVBuilder
import styled.css
import styled.styledDiv

// строчка без отступа
fun RBuilder.adLabelText(
    label: String,
    text: String?,
    labelColor: ADColor = ADColor.DarkSky,
    textColor: ADColor = ADColor.GrayCloud,
    builder: DIVBuilder = {}
) {
    flexRow {
        css {
            padding(2.px, 0.px)
            child("span") {
                marginRight = 2.px
            }
        }
        adSmallBody(labelColor) { +label }
        adSmallBody(textColor) { +(text ?: "—") }
        builder()
    }
}

// строчка с одинаковым отступом для всех
fun RBuilder.adLabelTextRow(
    label: String,
    text: String?,
    rowWidth: String = "100%",
    labelBasis: String = "100px",
    builder: DIVBuilder = {}
) {
    styledDiv {
        css {
            width = LinearDimension(rowWidth)
            display = Display.flex
            marginBottom = 12.px
            child("div") {
                flexGrow = 1.0
            }
        }
        adBodyR(color = ADColor.DarkSky) {
            css {
                flex(0.0, 0.0, FlexBasis(labelBasis))
                marginRight = 4.px
            }
            +label
        }
        adBodyR {
            css {
                flexGrow = 1.0
            }
            +(text ?: "—")
        }

        builder()
    }
}
