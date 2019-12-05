package com.github.onotoliy.kotlinx.materialui.svg

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.svg
import react.dom.tag

private inline fun RBuilder.custom(tagName: String, block: RDOMBuilder<HTMLTag>.() -> Unit): ReactElement = tag(block) {
    HTMLTag(tagName, it, mapOf(), null, inlineTag = true, emptyTag = false)
}

fun RBuilder.svgLogoOpposite() {
    svg {
        attrs["width"] = "198"
        attrs["height"] = "34"
        attrs["viewBox"] = "0 0 198 34"
        custom("image") {
            attrs["id"] = "image0"
            attrs["width"] = "200"
            attrs["height"] = "30"
            attrs["xlinkHref"] = "data:img/png;base64,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"
        }
    }
}
