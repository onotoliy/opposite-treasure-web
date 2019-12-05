package com.github.onotoliy.kotlinx.materialui

import react.RBuilder
import react.RHandler
import react.RProps
import react.router.dom.routeLink

fun RBuilder.routerLink(
    to: String,
    handler: RHandler<RProps>
) = routeLink(to, className = "router-link") {
    handler()
}
