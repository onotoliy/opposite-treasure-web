@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "unused")
@file:JsQualifier("com.github.onotoliy.opposite.treasure.maps.visualization")

package com.github.onotoliy.opposite.treasure.maps.visualization

open external class MapsEngineLayer(options: MapsEngineLayerOptions) : com.github.onotoliy.opposite.treasure.maps.MVCObject {
    open fun getLayerId(): String = definedExternally
    open fun getLayerKey(): String = definedExternally
    open fun getMap(): com.github.onotoliy.opposite.treasure.maps.Map = definedExternally
    open fun getMapId(): String = definedExternally
    open fun getOpacity(): Number = definedExternally
    open fun getProperties(): MapsEngineLayerProperties = definedExternally
    open fun getStatus(): MapsEngineStatus = definedExternally
    open fun getZIndex(): Number = definedExternally
    open fun setLayerId(layerId: String): Unit = definedExternally
    open fun setLayerKey(layerKey: String): Unit = definedExternally
    open fun setMap(map: com.github.onotoliy.opposite.treasure.maps.Map?): Unit = definedExternally
    open fun setMapId(mapId: String): Unit = definedExternally
    open fun setOpacity(opacity: Number): Unit = definedExternally
    open fun setOptions(options: MapsEngineLayerOptions): Unit = definedExternally
    open fun setZIndex(zIndex: Number): Unit = definedExternally
}

external interface MapsEngineLayerOptions {
    var accessToken: String? get() = definedExternally; set(value) = definedExternally
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var fitBounds: Boolean? get() = definedExternally; set(value) = definedExternally
    var layerId: String? get() = definedExternally; set(value) = definedExternally
    var layerKey: String? get() = definedExternally; set(value) = definedExternally
    var map: com.github.onotoliy.opposite.treasure.maps.Map? get() = definedExternally; set(value) = definedExternally
    var mapId: String? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var suppressInfoWindows: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

external interface MapsEngineLayerProperties {
    var name: String
}

external interface MapsEngineMouseEvent {
    var featureId: String? get() = definedExternally; set(value) = definedExternally
    var infoWindowHtml: String? get() = definedExternally; set(value) = definedExternally
    var latLng: com.github.onotoliy.opposite.treasure.maps.LatLng? get() = definedExternally; set(value) = definedExternally
    var pixelOffset: com.github.onotoliy.opposite.treasure.maps.Size? get() = definedExternally; set(value) = definedExternally
}

external enum class MapsEngineStatus {
    INVALID_LAYER,
    OK,
    UNKNOWN_ERROR
}

open external class HeatmapLayer(opts: HeatmapLayerOptions? = definedExternally /* null */) : com.github.onotoliy.opposite.treasure.maps.MVCObject {
    open fun getMap(): com.github.onotoliy.opposite.treasure.maps.Map = definedExternally

    open fun setData(data: Array<com.github.onotoliy.opposite.treasure.maps.LatLng>): Unit = definedExternally
    open fun setData(data: com.github.onotoliy.opposite.treasure.maps.MVCArray<dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLng | WeightedLocation */>): Unit = definedExternally
    open fun setData(data: Array<WeightedLocation>): Unit = definedExternally
    open fun setMap(map: com.github.onotoliy.opposite.treasure.maps.Map?): Unit = definedExternally
}

external interface HeatmapLayerOptions {
    var data: Any
    var dissipating: Boolean? get() = definedExternally; set(value) = definedExternally
    var gradient: Array<String>? get() = definedExternally; set(value) = definedExternally
    var map: com.github.onotoliy.opposite.treasure.maps.Map? get() = definedExternally; set(value) = definedExternally
    var maxIntensity: Number? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
}

external interface WeightedLocation {
    var location: com.github.onotoliy.opposite.treasure.maps.LatLng
    var weight: Number
}

open external class MouseEvent {
    open fun stop(): Unit = definedExternally
}

open external class MapsEventListener
