package com.github.onotoliy.opposite.treasure.app.loader

import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

fun RBuilder.appLoaderWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            position = Position.fixed
            zIndex = 1202
            width = 100.pct
            top = 0.px
            right = 0.px
            left = 0.px
        }
        builder()
    }
}
