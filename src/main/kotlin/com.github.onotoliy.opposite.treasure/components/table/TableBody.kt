package com.github.onotoliy.opposite.treasure.components.table

import com.github.onotoliy.opposite.treasure.components.createStyled
import com.github.onotoliy.opposite.treasure.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/TableBody")
private external val tableBodyModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val tableBodyComponent: RComponent<MTableBodyProps, RState> = tableBodyModule.default

interface MTableBodyProps : StyledProps {
    var component: String
}

fun RBuilder.mTableBody(
    component: String = "tbody",

    className: String? = null,
    handler: StyledHandler<MTableBodyProps>? = null
) = createStyled(tableBodyComponent) {
    attrs.component = component
    setStyledPropsAndRunHandler(className, handler)
}
