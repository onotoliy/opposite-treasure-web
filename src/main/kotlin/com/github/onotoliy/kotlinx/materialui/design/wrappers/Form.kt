package com.github.onotoliy.kotlinx.materialui.design.wrappers

import com.github.onotoliy.kotlinx.materialui.design.flexColumn
import com.github.onotoliy.kotlinx.materialui.design.flexRow
import kotlinx.css.*
import react.RBuilder
import styled.DIVBuilder
import styled.css

fun RBuilder.adFormBlockWrapper(margin: String = ADBlockWrapperMargin20, builder: DIVBuilder) {
    flexColumn {
        css {
            this.margin = margin
        }
        builder()
    }
}

fun RBuilder.adFormInputsRow(builder: DIVBuilder) {
    flexRow {
        css {
            children {
                flex(1.0, 1.0, 0.px)
                not(":last-child") {
                    marginRight = 20.px
                }
            }
        }
        builder()
    }
}
