@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "unused")
@file:JsQualifier("com.github.onotoliy.opposite.treasure.maps.drawing")

package com.github.onotoliy.opposite.treasure.maps.drawing

open external class DrawingManager(options: DrawingManagerOptions? = definedExternally /* null */) : com.github.onotoliy.opposite.treasure.maps.MVCObject {
    open fun getDrawingMode(): OverlayType = definedExternally
    open fun getMap(): com.github.onotoliy.opposite.treasure.maps.Map = definedExternally
    open fun setDrawingMode(drawingMode: OverlayType?): Unit = definedExternally
    open fun setMap(map: com.github.onotoliy.opposite.treasure.maps.Map?): Unit = definedExternally
    open fun setOptions(options: DrawingManagerOptions): Unit = definedExternally
}

external interface DrawingManagerOptions {
    var circleOptions: com.github.onotoliy.opposite.treasure.maps.CircleOptions? get() = definedExternally; set(value) = definedExternally
    var drawingControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var drawingControlOptions: DrawingControlOptions? get() = definedExternally; set(value) = definedExternally
    var drawingMode: OverlayType? get() = definedExternally; set(value) = definedExternally
    var map: com.github.onotoliy.opposite.treasure.maps.Map? get() = definedExternally; set(value) = definedExternally
    var markerOptions: com.github.onotoliy.opposite.treasure.maps.MarkerOptions? get() = definedExternally; set(value) = definedExternally
    var polygonOptions: com.github.onotoliy.opposite.treasure.maps.PolygonOptions? get() = definedExternally; set(value) = definedExternally
    var polylineOptions: com.github.onotoliy.opposite.treasure.maps.PolylineOptions? get() = definedExternally; set(value) = definedExternally
    var rectangleOptions: com.github.onotoliy.opposite.treasure.maps.RectangleOptions? get() = definedExternally; set(value) = definedExternally
}

external interface DrawingControlOptions {
    var drawingModes: Array<OverlayType>? get() = definedExternally; set(value) = definedExternally
    var position: com.github.onotoliy.opposite.treasure.maps.ControlPosition? get() = definedExternally; set(value) = definedExternally
}

external interface OverlayCompleteEvent {
    var overlay: dynamic /* com.github.onotoliy.opposite.treasure.maps.Marker | com.github.onotoliy.opposite.treasure.maps.Polyline | com.github.onotoliy.opposite.treasure.maps.Polygon | com.github.onotoliy.opposite.treasure.maps.Rectangle | com.github.onotoliy.opposite.treasure.maps.Circle */
    var type: OverlayType
}

external enum class OverlayType {
    CIRCLE,
    MARKER,
    POLYGON,
    POLYLINE,
    RECTANGLE
}
