package com.github.onotoliy.kotlinx.materialui.design

import com.github.onotoliy.kotlinx.materialui.design.wrappers.ADBlockWrapperMargin12
import com.github.onotoliy.kotlinx.materialui.design.wrappers.ADBlockWrapperMargin16
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.html.DIV
import react.RBuilder
import styled.DIVBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

fun RBuilder.flexRow(margin: String? = null, builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            display = Display.flex
            alignItems = Align.center
            margin?.let { this.margin = it }
        }
        builder()
    }
}

fun RBuilder.flexColumn(margin: String? = null, builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
            margin?.let { this.margin = it }
        }
        builder()
    }
}

fun RBuilder.baseShadowWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            boxShadow += ADBoxShadowEasy
            display = Display.flex
            flexDirection = FlexDirection.column
            borderRadius = 4.px
        }
        builder()
    }
}

fun RBuilder.shadowWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    baseShadowWrapper {
        css {
            padding(12.px, 16.px)
            marginBottom = 16.px
        }
        builder()
    }
}

// *** Common Page Styles

// обертка для основной "рабочей" части страницы
fun RBuilder.adContentWrapper(
    width: String? = null,
    builder: StyledDOMBuilder<DIV>.() -> Unit
) {
    flexColumn {
        css {
            padding(20.px)
            width?.let { this.width = LinearDimension(it) }
            flexShrink = 0.0
            flexGrow = 0.0
        }
        builder()
    }
}

fun RBuilder.adHeaderWrapper(
    margin: String = ADBlockWrapperMargin16,
    builder: StyledDOMBuilder<DIV>.() -> Unit
) {
    flexRow {
        css {
            justifyContent = JustifyContent.spaceBetween
            this.margin = margin
        }
        builder()
    }
}

fun RBuilder.adHeaderBackTitleWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    flexRow {
        css {
            child("button") {
                marginRight = 8.px
            }
        }
        builder()
    }
}

fun RBuilder.adHeaderActionsWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    flexRow {
        css {
            children {
                marginLeft = 8.px
            }
        }
        builder()
    }
}

// можно (и нужно при необходимости) использовать вместе adHeaderActionsWrapper()
fun RBuilder.adTableHeaderWrapper(
    margin: String = ADBlockWrapperMargin12,
    padding: String = "0 0 10px 0",
    borderBottom: Boolean = true,
    builder: StyledDOMBuilder<DIV>.() -> Unit
) {
    flexRow {
        css {
            justifyContent = JustifyContent.spaceBetween
            this.margin = margin
            this.padding = padding
            if (borderBottom) {
                borderBottom(1.px, BorderStyle.solid, ADColor.CleanRain.hex())
            }
        }
        builder()
    }
}

fun RBuilder.adActionsWrapper(
    margin: String = ADBlockWrapperMargin12,
    builder: StyledDOMBuilder<DIV>.() -> Unit
) {
    flexRow {
        css {
            this.margin = margin
            children {
                marginRight = 8.px
            }
        }
        builder()
    }
}

fun RBuilder.adActionsVerticalWrapper(builder: DIVBuilder) {
    flexColumn {
        css {
            alignItems = Align.center
            marginTop = 12.px
            children("button") {
                marginBottom = 20.px
            }
        }
        builder()
    }
}
