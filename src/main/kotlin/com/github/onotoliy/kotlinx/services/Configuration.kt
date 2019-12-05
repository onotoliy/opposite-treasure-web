package com.github.onotoliy.kotlinx.services

import com.github.onotoliy.kotlinx.Config
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.await
import react.router.dom.RouteResultHistory

object Configuration {
    lateinit var scope: CoroutineScope
    lateinit var history: RouteResultHistory

    var config = Config()

    suspend fun initConfig() {
        config = Network.get("onotoliy.json", Config.serializer()).await()
    }

    suspend fun initConfig(callback: () -> Unit) {
        config = Network.get("onotoliy.json", Config.serializer()).await()
        callback()
    }
}
