package com.github.onotoliy.opposite.treasure.app

import com.github.onotoliy.kotlinx.components.*
import com.github.onotoliy.kotlinx.components.svg.svgLogoOpposite
import kotlinext.js.JsObject
import kotlinx.css.*
import react.RBuilder
import styled.css
import styled.styledDiv

fun RBuilder.appHeader(accountName: String, logout: () -> Unit) = mAppBar(MColor.inherit) {
    mToolbar {
        styledDiv {
            css.flexGrow = 1.0
            svgLogoOpposite()
        }
        styledDiv {
            css.marginRight = 50.px
            css.color = Color.grey
            +accountName
        }
        mButton("Выйти", true, onClick = { logout() })
    }
}

fun RBuilder.appHeaderSpacer() {
    styledDiv {
        css {
            toolbarJsCssToPartialCss(currentTheme.mixins.toolbar.unsafeCast<JsObject>())
        }
    }
}