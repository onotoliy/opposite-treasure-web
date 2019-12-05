package com.github.onotoliy.kotlinx.materialui.design.table

import kotlinx.css.*
import react.RBuilder
import styled.SPANBuilder
import styled.css
import styled.styledSpan

fun RBuilder.adTableCellActions(
    builder: SPANBuilder
) {
    styledSpan {
        css {
            display = Display.flex
            justifyContent = JustifyContent.flexEnd
            alignItems = Align.center
        }
        builder()
    }
}
