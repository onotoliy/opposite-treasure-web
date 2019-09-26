package com.github.onotoliy.kotlinx.services

import com.github.onotoliy.kotlinx.Config
import kotlinx.coroutines.await

object Configuration {
    var config = Config()

    suspend fun initConfig() {
        config = Network.request(Config.serializer(), Network.Method.GET, "onotoliy.json").await()
    }
}