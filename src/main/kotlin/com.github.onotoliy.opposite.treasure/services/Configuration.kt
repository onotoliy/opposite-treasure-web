package com.github.onotoliy.opposite.treasure.services

import kotlinx.coroutines.await
import com.github.onotoliy.opposite.treasure.models.Config

object Configuration {
    var config = Config()

    suspend fun initConfig() {
        config = Network.request(Config.serializer(), Network.Method.GET, "agro.json").await()
    }
}