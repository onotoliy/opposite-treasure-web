package com.github.onotoliy.kotlinx.keycloak

/**
 * Статические функции и свойства для работы с аутентификацией через Keycloak
 */
object Auth {

    /**
     * Инстанс объекта [keycloak].
     * Используется извне для получения значения токена.
     */
    val keycloak = keycloak("/keycloak.json")

    /**
     * Значение по умолчанию для таймаута обновления токена.
     */
    private const val timeout = 300

    /**
     * Лямбда-выражение, которое будет выполнено при успешной аутентификации.
     * Требуется инициализация перед использованием метода [login]
     */
    lateinit var onLoginFunction: () -> Unit

    /**
     * Запуск аутентификации
     */
    fun login() {
        keycloak.init(JSON.parse("{\"onLoad\": \"login-required\", \"checkLoginIframe\": \"false\"}")).success {
            if (keycloak.authenticated == true)
                onLoginFunction()
        }
    }

    /**
     * Прекращение сессии
     */
    fun logout() {
        keycloak.logout()
    }

    /**
     * Обновление токена
     */
    fun updateToken(callback: (Boolean) -> Unit) {
        keycloak.updateToken(timeout).success(callback).error { login() }
    }

    fun isModifier(roles: List<String>): Boolean {
        return roles.any { r1 -> arrayOf("treasurer", "president", "vice-president").any { r2 -> r1 === r2} }
    }

}
