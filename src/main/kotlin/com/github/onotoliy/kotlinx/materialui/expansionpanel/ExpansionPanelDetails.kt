package com.github.onotoliy.kotlinx.materialui.expansionpanel

import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/ExpansionPanelDetails")
private external val expansionPanelDetailsModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val expansionPanelDetailsComponent: RComponent<StyledProps, RState> = expansionPanelDetailsModule.default

fun RBuilder.mExpansionPanelDetails(
    className: String? = null,
    handler: StyledHandler<StyledProps>? = null
) =
        createStyled(expansionPanelDetailsComponent) {
            setStyledPropsAndRunHandler(className, handler)
        }
