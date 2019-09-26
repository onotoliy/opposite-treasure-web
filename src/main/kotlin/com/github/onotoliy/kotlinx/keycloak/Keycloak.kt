@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
    "UNUSED"
)

package com.github.onotoliy.kotlinx.keycloak

@JsName("Keycloak")
external fun keycloak(config: String? = definedExternally /* null */): KeycloakInstance = definedExternally

@JsName("Keycloak")
external fun keycloak(config: Any? = definedExternally /* null */): KeycloakInstance = definedExternally

@JsName("Keycloak")
external fun keycloak(): KeycloakInstance = definedExternally

external interface KeycloakInitOptions {
    var useNonce: Boolean? get() = definedExternally; set(value) = definedExternally
    var adapter: dynamic /* String /* "cordova" */ | String /* "cordova-native" */ | String /* "default" */ | any*/ get() = definedExternally; set(value) = definedExternally
    var onLoad: dynamic /* String /* "login-required" */ | String /* "check-sso" */ */ get() = definedExternally; set(value) = definedExternally
    var token: String? get() = definedExternally; set(value) = definedExternally
    var refreshToken: String? get() = definedExternally; set(value) = definedExternally
    var idToken: String? get() = definedExternally; set(value) = definedExternally
    var timeSkew: Number? get() = definedExternally; set(value) = definedExternally
    var checkLoginIframe: Boolean? get() = definedExternally; set(value) = definedExternally
    var checkLoginIframeInterval: Number? get() = definedExternally; set(value) = definedExternally
    var responseMode: dynamic /* String /* "query" */ | String /* "fragment" */ */ get() = definedExternally; set(value) = definedExternally
    var redirectUri: String? get() = definedExternally; set(value) = definedExternally
    var flow: dynamic /* String /* "standard" */ | String /* "implicit" */ | String /* "hybrid" */ */ get() = definedExternally; set(value) = definedExternally
}

@JsName("T$0")
external interface T0 {
    operator fun get(optionName: String): String?
    operator fun set(optionName: String, value: String)
}

external interface KeycloakLoginOptions {
    var scope: String? get() = definedExternally; set(value) = definedExternally
    var redirectUri: String? get() = definedExternally; set(value) = definedExternally
    var prompt: dynamic /* String /* "none" */ | String /* "login" */ */ get() = definedExternally; set(value) = definedExternally
    var action: String? /* "register" */ get() = definedExternally; set(value) = definedExternally
    var maxAge: Number? get() = definedExternally; set(value) = definedExternally
    var loginHint: String? get() = definedExternally; set(value) = definedExternally
    var idpHint: String? get() = definedExternally; set(value) = definedExternally
    var locale: String? get() = definedExternally; set(value) = definedExternally
    var kcLocale: String? get() = definedExternally; set(value) = definedExternally
    var cordovaOptions: T0? get() = definedExternally; set(value) = definedExternally
}

external interface KeycloakPromise<TSuccess, TError> {
    fun success(callback: (result: TSuccess) -> Unit): KeycloakPromise<TSuccess, TError>
    fun error(callback: (result: TError) -> Unit): KeycloakPromise<TSuccess, TError>
}

external interface KeycloakError {
    var error: String
    @JsName("error_description")
    var errorDescription: String
}

@JsName("T$1")
external interface T1 {
    var redirectUri: String
}

external interface KeycloakAdapter {
    fun login(options: KeycloakLoginOptions? = definedExternally /* null */): KeycloakPromise<Unit, Unit>
    fun logout(options: Any? = definedExternally /* null */): KeycloakPromise<Unit, Unit>
    fun register(options: KeycloakLoginOptions? = definedExternally /* null */): KeycloakPromise<Unit, Unit>
    fun accountManagement(): KeycloakPromise<Unit, Unit>
    fun redirectUri(options: T1, encodeHash: Boolean): String
}

external interface KeycloakProfile {
    var id: String? get() = definedExternally; set(value) = definedExternally
    var username: String? get() = definedExternally; set(value) = definedExternally
    var email: String? get() = definedExternally; set(value) = definedExternally
    var firstName: String? get() = definedExternally; set(value) = definedExternally
    var lastName: String? get() = definedExternally; set(value) = definedExternally
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var emailVerified: Boolean? get() = definedExternally; set(value) = definedExternally
    var totp: Boolean? get() = definedExternally; set(value) = definedExternally
    var createdTimestamp: Number? get() = definedExternally; set(value) = definedExternally
}

@JsName("T$2")
external interface T2 {
    var roles: Array<String>
}

external interface KeycloakTokenParsed {
    var exp: Number? get() = definedExternally; set(value) = definedExternally
    var iat: Number? get() = definedExternally; set(value) = definedExternally
    var nonce: String? get() = definedExternally; set(value) = definedExternally
    var sub: String? get() = definedExternally; set(value) = definedExternally
    @JsName("session_state")
    var sessionState: String?
        get() = definedExternally
        set(value) = definedExternally
    @JsName("realm_access")
    var realmAccess: T2?
        get() = definedExternally
        set(value) = definedExternally
    @JsName("resource_access")
    var resourceAccess: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
}

external interface KeycloakInstance {
    var authenticated: Boolean? get() = definedExternally; set(value) = definedExternally
    var subject: String? get() = definedExternally; set(value) = definedExternally
    var responseMode: dynamic /* String /* "query" */ | String /* "fragment" */ */ get() = definedExternally; set(value) = definedExternally
    var responseType: dynamic /* String /* "code" */ | String /* "id_token token" */ | String /* "code id_token token" */ */ get() = definedExternally; set(value) = definedExternally
    var flow: dynamic /* String /* "standard" */ | String /* "implicit" */ | String /* "hybrid" */ */ get() = definedExternally; set(value) = definedExternally
    var realmAccess: T2? get() = definedExternally; set(value) = definedExternally
    var resourceAccess: Array<String>? get() = definedExternally; set(value) = definedExternally
    var token: String? get() = definedExternally; set(value) = definedExternally
    var tokenParsed: KeycloakTokenParsed? get() = definedExternally; set(value) = definedExternally
    var refreshToken: String? get() = definedExternally; set(value) = definedExternally
    var refreshTokenParsed: KeycloakTokenParsed? get() = definedExternally; set(value) = definedExternally
    var idToken: String? get() = definedExternally; set(value) = definedExternally
    var idTokenParsed: KeycloakTokenParsed? get() = definedExternally; set(value) = definedExternally
    var timeSkew: Number? get() = definedExternally; set(value) = definedExternally
    var loginRequired: Boolean? get() = definedExternally; set(value) = definedExternally
    var authServerUrl: String? get() = definedExternally; set(value) = definedExternally
    var realm: String? get() = definedExternally; set(value) = definedExternally
    var clientId: String? get() = definedExternally; set(value) = definedExternally
    var clientSecret: String? get() = definedExternally; set(value) = definedExternally
    var redirectUri: String? get() = definedExternally; set(value) = definedExternally
    var sessionId: String? get() = definedExternally; set(value) = definedExternally
    var profile: KeycloakProfile? get() = definedExternally; set(value) = definedExternally
    var userInfo: Any? get() = definedExternally; set(value) = definedExternally
    val onReady: ((authenticated: Boolean? /*= null*/) -> Unit)? get() = definedExternally
    val onAuthSuccess: (() -> Unit)? get() = definedExternally
    val onAuthError: ((errorData: KeycloakError) -> Unit)? get() = definedExternally
    val onAuthRefreshSuccess: (() -> Unit)? get() = definedExternally
    val onAuthRefreshError: (() -> Unit)? get() = definedExternally
    val onAuthLogout: (() -> Unit)? get() = definedExternally
    val onTokenExpired: (() -> Unit)? get() = definedExternally
    fun init(initOptions: KeycloakInitOptions): KeycloakPromise<Boolean, KeycloakError>
    fun login(options: KeycloakLoginOptions? = definedExternally /* null */): KeycloakPromise<Unit, Unit>
    fun logout(options: Any? = definedExternally /* null */): KeycloakPromise<Unit, Unit>
    fun register(options: Any? = definedExternally /* null */): KeycloakPromise<Unit, Unit>
    fun accountManagement(): KeycloakPromise<Unit, Unit>
    fun createLoginUrl(options: KeycloakLoginOptions? = definedExternally /* null */): String
    fun createLogoutUrl(options: Any? = definedExternally /* null */): String
    fun createRegisterUrl(options: KeycloakLoginOptions? = definedExternally /* null */): String
    fun createAccountUrl(): String
    fun isTokenExpired(minValidity: Number? = definedExternally /* null */): Boolean
    fun updateToken(minValidity: Number): KeycloakPromise<Boolean, Boolean>
    fun clearToken()
    fun hasRealmRole(role: String): Boolean
    fun hasResourceRole(role: String, resource: String? = definedExternally /* null */): Boolean
    fun loadUserProfile(): KeycloakPromise<KeycloakProfile, Unit>
    fun loadUserInfo(): KeycloakPromise<Any, Unit>
}
