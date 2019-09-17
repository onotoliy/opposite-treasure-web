package com.github.onotoliy.opposite.treasure.utils

import kotlin.js.Date

fun getCurrentDate(): String = Date().toISOString().substring(0, 10)