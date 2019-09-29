package com.github.onotoliy.kotlinx.services

import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.opposite.data.core.ExceptionInformation
import com.github.onotoliy.opposite.treasure.services.system.SystemService
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.w3c.xhr.XMLHttpRequest
import kotlin.js.Promise

object NewNetwork {

    fun <T> get(url: String, deserialization: DeserializationStrategy<T>) = Promise<T> { resolve, reject ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val req = XMLHttpRequest()

                req.open("GET", Configuration.config.apiBase + url)
                req.setRequestHeader("Accept", "application/json")
                req.setRequestHeader("Content-Type", "application/json")
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        when (req.status) {
                            200.toShort() -> resolve(req.responseText, deserialization, resolve, reject)
                            400.toShort(), 404.toShort(), 500.toShort() -> reject(req.responseText, reject)
                            else -> {
                                SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                                reject(Exception(req.responseText))
                            }
                        }
                        SystemService.setLoading(false)
                    }
                }

                req.send()
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            reject(ex)
        }
    }

    fun delete(url: String) = Promise<Unit> { resolve, reject ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val req = XMLHttpRequest()

                req.open("DELETE", Configuration.config.apiBase + url)
                req.setRequestHeader("Accept", "application/json")
                req.setRequestHeader("Content-Type", "application/json")
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)

                req.onreadystatechange = {

                    if (req.readyState == 4.toShort()) {
                        when (req.status) {
                            200.toShort(), 201.toShort() -> resolve(Unit)
                            400.toShort(), 404.toShort(), 500.toShort() -> reject(req.responseText, reject)
                            else -> {
                                SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                                reject(Exception(req.responseText))
                            }
                        }

                        SystemService.setLoading(false)
                    }
                }

                req.send()
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            reject(ex)
        }
    }

    fun <T> put(url: String, obj: T, serialization: KSerializer<T>) = run { send(url, "PUT", obj, serialization) }

    fun <T> post(url: String, obj: T, serialization: KSerializer<T>) = run { send(url, "POST", obj, serialization) }

    private fun <T> send(url: String, method: String, obj: T, serialization: KSerializer<T>) = Promise<T> { resolve, reject ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val req = XMLHttpRequest()

                req.open(method, Configuration.config.apiBase + url)
                req.setRequestHeader("Accept", "application/json")
                req.setRequestHeader("Content-Type", "application/json")
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        when (req.status) {
                            200.toShort(), 201.toShort() -> {
                                try {
                                    resolve(Json.parse(serialization, req.responseText))
                                } catch (ex: Exception) {
                                    SystemService.setLoading(false)
                                    SystemService.setAlert("Ошибка при обработке ответа сервера")
                                    reject(ex)
                                }
                            }
                            400.toShort(), 404.toShort(), 500.toShort() ->
                                reject(req.responseText, reject)
                            else -> {
                                SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                                reject(Exception(req.responseText))
                            }
                        }
                    }
                }

                req.send(Json.stringify(serialization, obj))
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            reject(ex)
        }
    }

    private fun <O> resolve(json: String, deserialization: DeserializationStrategy<O>, resolve: (O) -> Unit, reject: (Throwable) -> Unit) {
        try {
            resolve(Json.parse(deserialization, json))
        } catch (ex: Exception) {
            SystemService.setAlert("Ошибка при обработке ответа сервера")
            reject(ex)
        }
    }

    private fun reject(json: String, reject: (Throwable) -> Unit) {
        try {
            val ex: ExceptionInformation = Json.parse(ExceptionInformation.serializer(), json)
            SystemService.setAlert("${ex.status.name}: ${ex.message}")
        } catch (ex: Exception) {
            SystemService.setAlert("Ошибка при обработке ответа сервера")
            reject(ex)
        }
    }
}
