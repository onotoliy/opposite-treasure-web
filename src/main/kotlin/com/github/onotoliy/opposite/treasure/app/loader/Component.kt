package com.github.onotoliy.opposite.treasure.app.loader

import com.github.onotoliy.kotlinx.materialui.mLinearProgress
import kotlinx.css.Visibility
import kotlinx.css.visibility
import react.RBuilder

fun RBuilder.appLoaderComponent(loadingCount: Int) {
    appLoaderWrapper {
        css.visibility = if (loadingCount > 0) Visibility.visible else Visibility.hidden
        mLinearProgress()
    }
}
