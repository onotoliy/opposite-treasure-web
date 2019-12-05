@file:Suppress("UnsafeCastFromDynamic")

package com.github.onotoliy.kotlinx.materialui.design.svg

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import kotlinext.js.jsObject
import kotlinx.css.padding
import react.RBuilder
import react.ReactElement
import styled.SPANBuilder
import styled.css
import styled.styledSpan

typealias ADIcon = (SvgProps) -> ReactElement
interface SvgModule {
    val default: ADIcon
}

interface SvgProps {
    var fillcolor: String
}

fun RBuilder.adSVG(
    svgFun: ADIcon,
    fillcolor: ADColor = ADColor.GrayCloud
) {
    val props = jsObject<SvgProps> {
        this.fillcolor = fillcolor.hex
    }

    child(svgFun(props))
}

// utils..
fun RBuilder.adSVGWrapper(
    padding: String = "0 4px 0 0",
    builder: SPANBuilder
) {
    styledSpan {
        css {
            this.padding = padding
        }
        builder()
    }
}
