package com.github.onotoliy.opposite.treasure.components.styled

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import kotlinx.html.DIV
import kotlinx.html.FORM
import react.RBuilder
import styled.*

private object StyledCSS : StyleSheet("StyledCSS") {
    val flexRow by css {
        display = Display.flex
        alignItems = Align.center
    }

    val flexRowSB by css {
        display = Display.flex
        justifyContent = JustifyContent.spaceBetween
        alignItems = Align.center
    }

    val flexColumn by css {
        display = Display.flex
        flexDirection = FlexDirection.column
    }

    val marginHorizontal by css {
        margin(0.px, 15.px)
    }
}

fun RBuilder.flexContainer(
    direction: FlexDirection = FlexDirection.row,
    justifyContent: JustifyContent = JustifyContent.start,
    alignItems: Align = Align.center,
    paddingVertical: LinearDimension = 0.px,
    paddingHorizontal: LinearDimension = 0.px,
    builder: StyledDOMBuilder<DIV>.() -> Unit
) {
    styledDiv {
        css.display = Display.flex
        css.justifyContent = justifyContent
        css.alignItems = alignItems
        css.flexDirection = direction
        css.padding(paddingVertical, paddingHorizontal)

        builder()
    }
}

fun RBuilder.flexRow(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css { +StyledCSS.flexRow }
        builder()
    }
}

fun RBuilder.flexColumn(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css { +StyledCSS.flexColumn }
        builder()
    }
}

fun RBuilder.hmarginWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css { +StyledCSS.marginHorizontal }
        builder()
    }
}

fun RBuilder.flexRowSB(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css { +StyledCSS.flexRowSB }
        builder()
    }
}

fun RBuilder.formColumn(builder: StyledDOMBuilder<FORM>.() -> Unit) {
    styledForm {
        css {
            +StyledCSS.flexColumn
            padding(32.px, 0.px)
        }
        builder()
    }
}

fun RBuilder.baseShadowContainer(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        builder()
    }
}

fun RBuilder.shadowContainer(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    baseShadowContainer {
        css {
            padding(15.px)
            marginBottom = 10.px
        }
        builder()
    }
}

fun RBuilder.formControlContainer(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    flexRow {
        css {
            justifyContent = JustifyContent.flexEnd
        }
        builder()
    }
}

fun RBuilder.controlButtonWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            margin(15.px)
        }
        builder()
    }
}

fun RBuilder.labelWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            paddingRight = 10.px
        }
        builder()
    }
}