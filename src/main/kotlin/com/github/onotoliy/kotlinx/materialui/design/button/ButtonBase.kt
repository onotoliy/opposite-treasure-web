package com.github.onotoliy.kotlinx.materialui.design.button

import kotlinx.css.*
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledButton

fun RBuilder.adButtonBase(
    disabled: Boolean = false,
    fullWidth: Boolean = false,
    width: String? = null,
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    styledButton {
        attrs {
            this.type = ButtonType.button
            this.disabled = disabled
        }
        css {
            display = Display.inlineFlex
            if (fullWidth) {
                display = Display.flex
                this.width = 100.pct
            } else {
                width?.let { this.width = LinearDimension(it) }
            }
            justifyContent = JustifyContent.center
            alignItems = Align.center
            // убирает outline при клике - необходимо сверху прописывать hover, focus эффекты для accessibility
            outline = Outline.none
            if (disabled) {
                opacity = 0.4
            } else {
                cursor = Cursor.pointer
            }
        }
        builder()
    }
}
