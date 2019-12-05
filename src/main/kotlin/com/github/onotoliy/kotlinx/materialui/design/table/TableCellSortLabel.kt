package com.github.onotoliy.kotlinx.materialui.design.table

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import kotlinx.css.Cursor
import kotlinx.css.borderBottom
import kotlinx.css.cursor
import kotlinx.html.role
import react.RBuilder
import styled.SPANBuilder
import styled.css
import styled.styledSpan

fun RBuilder.adTableCellSortLabel(
    active: Boolean = false,
    builder: SPANBuilder
) {
    styledSpan {
        attrs {
            role = "button"
        }
        css {
            cursor = Cursor.pointer
            if (active) {
                borderBottom = "2px solid ${ADColor.FreshApple.hex}"
            }
        }
        builder()
    }
}
