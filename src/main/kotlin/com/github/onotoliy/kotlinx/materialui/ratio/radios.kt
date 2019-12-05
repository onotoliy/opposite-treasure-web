package com.github.onotoliy.kotlinx.materialui.ratio

import kotlinx.css.*
import kotlinx.html.DIV
import kotlinx.html.js.onClickFunction
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledButton
import styled.styledDiv

fun RBuilder.radioInput(
    value: Any,
    checked: Boolean,
    onCheck: (Any) -> Unit,
    label: String,
    labelColor: String = "#000000",
    checkedUrl: String = "/img/radio-checked.png",
    builder: StyledDOMBuilder<DIV>.() -> Unit = {}
) {
    styledDiv {
        css {
            display = Display.flex
            alignItems = Align.center
            color = Color(labelColor)
            marginBottom = 10.px
            child("button") {
                marginRight = 12.px
            }
        }
        radioButton(
                checked = checked,
                onCheck = { onCheck(value) },
                checkedUrl = checkedUrl
        )
        +label
        builder()
    }
}

fun RBuilder.radioButton(
    checked: Boolean,
    onCheck: () -> Unit,
    checkedUrl: String
) {
    styledButton {
        css {
            width = 18.px
            height = 18.px
            borderRadius = 12.5.px
            border = "1px solid #d1d1d1"
            backgroundColor = Color("#f5f5f5")
            padding(0.px)
            cursor = Cursor.pointer
            if (checked) {
                backgroundImage = Image("url($checkedUrl)")
                backgroundPosition = "center"
            }
        }
        attrs.onClickFunction = { onCheck() }
    }
}
