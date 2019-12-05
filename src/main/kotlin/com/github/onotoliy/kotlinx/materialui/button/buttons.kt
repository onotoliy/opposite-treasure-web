package com.github.onotoliy.kotlinx.materialui.button

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledButton

fun RBuilder.baseAddButton(onClick: () -> Unit, builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}) {
    styledButton {
        css {
            backgroundColor = Color.white
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
            border = "none"
            backgroundImage = Image("url(/img/addSign.png)")
            height = 34.px
            width = 34.px
            cursor = Cursor.pointer
            boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
        }
        attrs {
            this.onClickFunction = { _ -> onClick() }
            this.type = ButtonType.button
        }
        builder()
    }
}

fun RBuilder.baseDeleteButton(onClick: () -> Unit, disabled: Boolean = false, builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}) {
    styledButton {
        val op = if (disabled) 0.3 else 1.0
        css {
            backgroundColor = Color.white
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
            border = "none"
            backgroundImage = Image("url(/img/removeSign.png)")
            height = 34.px
            width = 34.px
            opacity = op
            cursor = Cursor.pointer
        }
        attrs {
            this.onClickFunction = { onClick() }
            this.disabled = disabled
            this.type = ButtonType.button
        }
        builder()
    }
}

fun RBuilder.addButton(onClick: () -> Unit = {}, builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}) {
    baseAddButton(onClick) {
        css {
            margin(7.px)
        }
        builder()
    }
}

fun RBuilder.deleteButton(onClick: () -> Unit, disabled: Boolean = false, builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}) {
    baseDeleteButton(onClick, disabled) {
        css {
            margin(7.px)
            boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
        }
        builder()
    }
}

fun RBuilder.smallDeleteButton(onClick: () -> Unit, disabled: Boolean = false, builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}) {
    baseDeleteButton(onClick, disabled) {
        css {
            margin(7.px)
        }
        builder()
    }
}

fun RBuilder.mAddIconButton(
    disabled: Boolean = false,
    border: Boolean = true,
    onClickFunction: () -> Unit
) {
    mButton("", disabled = disabled, onClick = { onClickFunction() }) {
        attrs.asDynamic().style = kotlinext.js.js {
            minWidth = "34px"
            maxWidth = "34px"
        }
        css {
            backgroundColor = Color.white
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
            backgroundImage = Image("url(/img/addSign.png)")
            height = 34.px
            if (disabled) opacity = 0.3
            if (border) boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
        }
    }
}

fun RBuilder.mEditIconButton(border: Boolean = true, onClickFunction: () -> Unit) {
    mButton("", onClick = { onClickFunction() }) {
        attrs.asDynamic().style = kotlinext.js.js { minWidth = "34px" }
        css {
            backgroundColor = Color.white
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
            if (border) boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
            backgroundImage = Image("url(/img/pencil.png)")
            height = 34.px
        }
    }
}

fun RBuilder.mDeleteIconButton(
    disabled: Boolean = false,
    border: Boolean = true,
    onClickFunction: () -> Unit
) {
    mButton("", disabled = disabled, onClick = { onClickFunction() }) {
        attrs.asDynamic().style = kotlinext.js.js { minWidth = "34px" }
        css {
            backgroundColor = Color.white
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
            backgroundImage = Image("url(/img/removeSign.png)")
            height = 34.px
            if (disabled) opacity = 0.3
            if (border) boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
        }
    }
}

fun RBuilder.mReportIconButton(
    title: String = "",
    disabled: Boolean = false,
    border: Boolean = false,
    onClickFunction: () -> Unit
) {
    mButton("", disabled = disabled, onClick = { onClickFunction() }) {
        attrs.asDynamic().style = kotlinext.js.js { minWidth = "34px" }
        css {
            backgroundColor = Color.white
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
            backgroundImage = Image("url(/img/doc-pencil.png)")
            height = 34.px
            if (disabled) opacity = 0.3
            if (border) boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
        }
    }
}

fun RBuilder.mReportEditIconButton(
    title: String = "",
    disabled: Boolean = false,
    border: Boolean = false,
    onClickFunction: () -> Unit
) {
    mButton("", disabled = disabled, onClick = { onClickFunction() }) {
        attrs.asDynamic().style = kotlinext.js.js { minWidth = "34px" }
        css {
            backgroundColor = Color.white
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "center"
            backgroundImage = Image("url(/img/pencil-square.png)")
            height = 34.px
            if (disabled) opacity = 0.3
            if (border) boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 3.px, 10.px, 0.px)
        }
    }
}
