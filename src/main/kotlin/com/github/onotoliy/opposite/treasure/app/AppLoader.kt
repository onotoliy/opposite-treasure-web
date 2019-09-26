package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.kotlinx.components.mLinearProgress
import kotlinx.css.*
import react.RBuilder
import styled.css
import styled.styledDiv

fun RBuilder.appLoader(loadingCount: Int) {
    styledDiv {
        css {
            visibility = if (loadingCount > 0) Visibility.visible else Visibility.hidden
            position = Position.fixed
            zIndex = 1202
            width = 100.pct
            top = 0.px
            right = 0.px
            left = 0.px
        }
        mLinearProgress()
    }
}