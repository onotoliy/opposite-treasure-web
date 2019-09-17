package com.github.onotoliy.opposite.treasure.services

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.url.URL.Companion.createObjectURL
import org.w3c.files.Blob
import org.w3c.xhr.BLOB
import org.w3c.xhr.FormData
import org.w3c.xhr.XMLHttpRequest
import org.w3c.xhr.XMLHttpRequestResponseType
import ru.playa.kotlinx.keycloak.js.Auth
import com.github.onotoliy.opposite.treasure.services.system.SystemService
import kotlin.browser.document
import kotlin.js.Promise

object Network {

    enum class Method {
        GET,
        POST,
        PUT,
        DELETE
    }

    fun <T> request(deserializationStrategy: DeserializationStrategy<T>, method: Method, url: String, json: String = "") = Promise<T> { d, c ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val urlFull = Configuration.config.apiBase + url
                val req = XMLHttpRequest()
                req.open(method.name, urlFull)
                req.setRequestHeader("Accept", "application/json")
                req.setRequestHeader("Content-Type", "application/json")
//                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        when (req.status) {
                            200.toShort() -> {
                                try {
                                    val resp: T = Json.parse(deserializationStrategy, req.responseText)
                                    SystemService.setLoading(false)
                                    d(resp)
                                } catch (ex: Exception) {
                                    SystemService.setLoading(false)
                                    SystemService.setAlert("Ошибка при обработке ответа сервера")
                                    c(ex)
                                }
                            }
                            401.toShort() -> {
                                document.location?.reload()
                                c(RuntimeException())
                            }
                            else -> {
                                SystemService.setLoading(false)
                                SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                                c(Exception(req.responseText))
                            }
                        }
                    }
                }
                if (json.isEmpty())
                    req.send()
                else
                    req.send(json)
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            c(ex)
        }
    }

    fun <T> send(serializationStrategy: KSerializer<T>, method: Method, obj: T, url: String) = Promise<T> { d, c ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val urlFull = Configuration.config.apiBase + url
                val req = XMLHttpRequest()
                req.open(method.name, urlFull)
                req.setRequestHeader("Accept", "application/json")
                req.setRequestHeader("Content-Type", "application/json")
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        when (req.status) {
                            200.toShort(), 201.toShort() -> {
                                try {
                                    val resp: T = Json.parse(serializationStrategy, req.responseText)
                                    SystemService.setLoading(false)
                                    d(resp)
                                } catch (ex: Exception) {
                                    SystemService.setLoading(false)
                                    SystemService.setAlert("Ошибка при обработке ответа сервера")
                                    c(ex)
                                }
                            }
                            401.toShort() -> {
                                document.location?.reload()
                                SystemService.setLoading(false)
                                c(RuntimeException())
                            }
                            else -> {
                                SystemService.setLoading(false)
                                SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                                c(Exception(req.responseText))
                            }
                        }
                    }
                }
                req.send(Json.stringify(serializationStrategy, obj))
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            c(ex)
        }
    }

    fun requestNoResult(method: Method, url: String, json: String = "") = Promise<Unit> { d, c ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val urlFull = Configuration.config.apiBase + url
                val req = XMLHttpRequest()
                req.open(method.name, urlFull)
                req.setRequestHeader("Accept", "application/json")
                req.setRequestHeader("Content-Type", "application/json")
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)
                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        SystemService.setLoading(false)
                        d(Unit)
                    }
                }
                if (json.isEmpty())
                    req.send()
                else
                    req.send(json)
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            c(ex)
        }
    }

    fun <T> sendFormData(
        deserializationStrategy: DeserializationStrategy<T>,
        method: Method,
        url: String,
        formData: FormData
    ) = Promise<T> { d, c ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val urlFull = Configuration.config.apiBase + url
                val req = XMLHttpRequest()
                req.open(method.name, urlFull)

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        val resp: T = Json.parse(deserializationStrategy, req.responseText)
                        SystemService.setLoading(false)
                        d(resp)
                    }
                }
                req.send(formData)
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            c(ex)
        }
    }

    fun requestDownload(method: Method, url: String, json: String = "", fileName: String = "") = Promise<Unit> { d, c ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val urlFull = Configuration.config.apiBase + url
                val req = XMLHttpRequest()
                req.open(method.name, urlFull)
                req.setRequestHeader("Content-Type", "application/json")
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)
                req.responseType = XMLHttpRequestResponseType.BLOB

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        if (req.status == 200.toShort()) {
                            val objectURL = createObjectURL(req.response as Blob)
                            val link = document.createElement("a") as HTMLAnchorElement
                            link.href = objectURL
                            link.download = fileName
                            document.body?.appendChild(link)
                            link.click()
                            link.remove()
                            SystemService.setLoading(false)
                            d(Unit)
                        } else {
                            SystemService.setLoading(false)
                            SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                            c(Exception(req.responseText))
                        }
                    }
                }
                if (json.isEmpty())
                    req.send()
                else
                    req.send(json)
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            c(ex)
        }
    }

    fun requestRaw(method: Method, url: String) = Promise<String> { d, c ->
        try {
            SystemService.setLoading(true)
            Auth.updateToken {
                val urlFull = Configuration.config.apiBase + url
                val req = XMLHttpRequest()
                req.open(method.name, urlFull)
                req.setRequestHeader("Authorization", "Bearer " + Auth.keycloak.token)

                req.onreadystatechange = {
                    if (req.readyState == 4.toShort()) {
                        when (req.status) {
                            200.toShort() -> {
                                SystemService.setLoading(false)
                                d(req.responseText)
                            }
                            401.toShort() -> {
                                document.location?.reload()
                                c(RuntimeException())
                            }
                            else -> {
                                SystemService.setLoading(false)
                                SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                                c(Exception(req.responseText))
                            }
                        }
                    }
                }
                req.send()
            }
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            c(ex)
        }
    }

    fun <T> requestExternal(method: Method, url: String, json: String = "", authorization: String = "") = Promise<T> { d, c ->
        try {
            SystemService.setLoading(true)
            val req = XMLHttpRequest()
            req.open(method.name, url)
            req.setRequestHeader("Accept", "application/json")
            req.setRequestHeader("Content-Type", "application/json")
            if (authorization.isNotBlank()) {
                req.setRequestHeader("Authorization", authorization)
            }

            req.onreadystatechange = {
                if (req.readyState == 4.toShort()) {
                    when (req.status) {
                        200.toShort() -> {
                            val resp: T = JSON.parse(req.responseText)
                            SystemService.setLoading(false)
                            d(resp)
                        }
                        else -> {
                            SystemService.setLoading(false)
                            SystemService.setAlert("Ошибка ${req.status}: ${req.statusText}")
                            c(Exception(req.responseText))
                        }
                    }
                }
            }
            if (json.isEmpty())
                req.send()
            else
                req.send(json)
        } catch (ex: Exception) {
            SystemService.setLoading(false)
            SystemService.setAlert("Ошибка: ${ex.message}")
            c(ex)
        }
    }
}
