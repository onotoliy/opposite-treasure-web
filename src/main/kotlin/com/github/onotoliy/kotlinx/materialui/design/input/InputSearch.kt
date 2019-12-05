package com.github.onotoliy.kotlinx.materialui.design.input

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.button.adButtonText
import com.github.onotoliy.kotlinx.materialui.design.flexRow
import com.github.onotoliy.kotlinx.materialui.targetInputValue
import kotlinx.css.flexGrow
import kotlinx.css.marginRight
import kotlinx.css.px
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import react.RBuilder
import styled.DIVBuilder
import styled.css

fun RBuilder.adInputSearch(
    value: String,
    onChange: (String) -> Unit,
    onSearch: () -> Unit,
    placeholder: String = "Введите название ...",
    builder: DIVBuilder = {}
) {
    flexRow(margin = "0 0 12px 0") {
        adInput {
            attrs {
                this.value = value
                onChangeFunction = { event -> onChange(event.targetInputValue) }
                this.placeholder = placeholder
            }
            css {
                flexGrow = 1.0
                marginRight = 8.px
            }
        }
        adButtonText("Найти", ADColor.BlueSky) {
            attrs {
                onClickFunction = { onSearch() }
            }
        }
        builder()
    }
}
