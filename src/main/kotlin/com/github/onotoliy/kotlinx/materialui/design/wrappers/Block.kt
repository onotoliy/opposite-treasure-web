package com.github.onotoliy.kotlinx.materialui.design.wrappers

import com.github.onotoliy.kotlinx.materialui.design.flexColumn
import kotlinx.css.margin
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css

const val ADBlockWrapperMargin20 = "0 0 20px 0"
const val ADBlockWrapperMargin16 = "0 0 16px 0"
const val ADBlockWrapperMargin12 = "0 0 12px 0"
const val ADBlockWrapperMargin8 = "0 0 8px 0"
const val ADBlockWrapperMargin4 = "0 0 4px 0"
const val ADBlockWrapperMargin0 = "0"

fun RBuilder.adBlockWrapper(
    margin: String = ADBlockWrapperMargin16,
    builder: StyledDOMBuilder<DIV>.() -> Unit
) {
    flexColumn {
        css {
            this.margin = margin
        }
        builder()
    }
}
