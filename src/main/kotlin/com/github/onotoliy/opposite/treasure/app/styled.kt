package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.flexColumn
import com.github.onotoliy.kotlinx.materialui.design.hex
import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

fun RBuilder.appBodyWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            display = Display.flex
            justifyContent = JustifyContent.center
            width = 100.pct
            height = 100.pct
            backgroundColor = ADColor.Fog.hex()
        }
        builder()
    }
}

fun RBuilder.appWorkspaceWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    flexColumn {
        css {
            backgroundColor = Color.white
            minHeight = 100.vh
            width = 100.pct
            media("only screen and (min-width: 1440px)") {
                width = 1440.px
            }
        }
        builder()
    }
}

fun RBuilder.sidebarAndContentWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            display = Display.flex
            alignItems = Align.flexStart
        }
        builder()
    }
}

fun RBuilder.appContentWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    flexColumn {
        css {
            flexGrow = 1.0
        }
        builder()
    }
}
