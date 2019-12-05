package com.github.onotoliy.opposite.treasure.app.alert

import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.css.properties.boxShadow
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

fun RBuilder.appAlertWrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) {
    styledDiv {
        css {
            justifyContent = JustifyContent.center
            alignItems = Align.center
            position = Position.fixed
            zIndex = 1300 // more than header
            width = 50.pct
            top = 15.px
            left = 25.pct
            right = 25.pct
            height = 30.px
            border(1.px, BorderStyle.solid, Color.red)
            borderRadius = 6.px
            boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 5.px, 10.px, 0.px)
            overflow = Overflow.hidden
            paddingLeft = 15.px
            backgroundColor = Color.white
        }
        builder()
    }
}
