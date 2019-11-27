package com.github.onotoliy.kotlinx.services

import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.opposite.data.core.ExceptionInformation
import com.github.onotoliy.opposite.treasure.services.system.SystemService
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.w3c.xhr.XMLHttpRequest
import kotlin.js.Promise

object Network {

    fun <T> get(url: String, deserialization: DeserializationStrategy<T>) =
            request(url, "GET") { json: String, resolve: (T) -> Unit, reject: (Throwable) -> Unit ->
                try {
                    resolve(Json.parse(deserialization, json))
                } catch (ex: Exception) {
                    SystemService.setAlert("Ошибка при обработке ответа сервера")
                    reject(ex)
                }
            }

    fun delete(url: String) =
            request(url, "DELETE") { _: String, resolve: (Unit) -> Unit, _: (Throwable) -> Unit ->
                resolve(Unit)
            }

    fun <T> put(url: String, obj: T, serialization: KSerializer<T>) =
            send(url, "PUT", obj, serialization)

    fun <T> post(url: String, obj: T, serialization: KSerializer<T>) =
            send(url, "POST", obj, serialization)

    private fun <T> send(url: String, method: String, obj: T, serialization: KSerializer<T>) =
            request(url, method, Json.stringify(serialization, obj)) { json: String, resolve: (T) -> Unit, reject: (Throwable) -> Unit ->
                try {
                    resolve(Json.parse(serialization, json))
                } catch (ex: Exception) {
                    SystemService.setLoading(false)
                    SystemService.setAlert("Ошибка при обработке ответа сервера")
                    reject(ex)
                }
            }

    private fun <T> request(
        url: String,
        method: String,
        json: String = "",
        success: (String, resolve: (T) -> Unit, reject: (Throwable) -> Unit) -> Unit
    ) = Promise<T> {
        resolve, reject ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val req = XMLHttpRequest()

                req.open(method, Configuration.config.apiBase + url)
                req.setRequestHeader("Accept", "application/json")
                req.setRequestHeader("Content-Type", "application/json")
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)

                console.log(Configuration.config.apiBase + url)

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        when (req.status) {
                            200.toShort(), 201.toShort() -> {
                                success(req.responseText, resolve, reject)
                                SystemService.setLoading(false)
                            }
                            400.toShort(), 404.toShort(), 500.toShort() -> {
                                try {
                                    SystemService.setAlert(Json.parse(ExceptionInformation.serializer(), req.responseText).message)
                                } catch (ex: Exception) {
                                    SystemService.setAlert("Ошибка при обработке ответа сервера")
                                    reject(ex)
                                }
                                SystemService.setLoading(false)
                            }
                            else -> {
                                SystemService.setLoading(false)
                                SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                                reject(Exception(req.responseText))
                            }
                        }
                    }
                }

                if (json.isEmpty()) {
                    req.send()
                } else {
                    req.send(json)
                }
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            reject(ex)
        }
    }
}
