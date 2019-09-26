package com.github.onotoliy.kotlinx.components.table

import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/TableHead")
private external val tableHeadModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val TableHeadComponent: RComponent<MTableHeadProps, RState> = tableHeadModule.default

interface MTableHeadProps : StyledProps {
    var component: String
}

fun RBuilder.mTableHead(
    component: String = "thead",

    className: String? = null,
    handler: StyledHandler<MTableHeadProps>? = null
) = createStyled(TableHeadComponent) {
    attrs.component = component
    setStyledPropsAndRunHandler(className, handler)
}
