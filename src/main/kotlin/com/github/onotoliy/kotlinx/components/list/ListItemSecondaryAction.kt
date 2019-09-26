package com.github.onotoliy.kotlinx.components.list

import com.github.onotoliy.kotlinx.components.MButtonBaseProps
import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/ListItemSecondaryAction")
private external val listItemSecondaryActionModule: dynamic

@Suppress("UnsafeCastFromDynamic")
val listItemSecondaryActionComponent: RComponent<MButtonBaseProps, RState> = listItemSecondaryActionModule.default

fun RBuilder.mListItemSecondaryAction(
    className: String? = null,
    handler: StyledHandler<MButtonBaseProps>? = null
) = createStyled(listItemSecondaryActionComponent) {
    setStyledPropsAndRunHandler(className, handler)
}
