package com.github.onotoliy.opposite.treasure.app.sidebar

import com.github.onotoliy.kotlinx.materialui.design.flexColumn
import kotlinx.css.flex
import kotlinx.css.marginRight
import kotlinx.css.px
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css

fun RBuilder.appSidebarWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    flexColumn {
        css {
            flex(0.0, 0.0, 30.px)
            marginRight = 15.px
        }
        builder()
    }
}
