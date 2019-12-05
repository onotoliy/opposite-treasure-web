package com.github.onotoliy.opposite.treasure.app.header

import com.github.onotoliy.kotlinx.materialui.design.ADBoxShadowEasy
import com.github.onotoliy.kotlinx.materialui.design.flexRow
import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

fun RBuilder.appHeaderWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    flexRow {
        css {
            justifyContent = JustifyContent.spaceBetween
            height = 60.px
            boxShadow += ADBoxShadowEasy
        }
        builder()
    }
}

fun RBuilder.logoWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            marginLeft = 20.px
        }
        builder()
    }
}

fun RBuilder.endAreaWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            marginRight = 20.px
        }
        builder()
    }
}
