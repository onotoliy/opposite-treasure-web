@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "unused", "SortModifiers", "ClassName", "PropertyName")
@file:JsQualifier("com.github.onotoliy.opposite.treasure.maps")

package com.github.onotoliy.opposite.treasure.maps

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import kotlin.js.Date

open external class Map(mapDiv: Element?, opts: MapOptions? = definedExternally /* null */) : MVCObject {
    open fun fitBounds(bounds: LatLngBounds, padding: Number? = definedExternally /* null */): Unit = definedExternally
    open fun fitBounds(bounds: LatLngBounds, padding: Padding? = definedExternally /* null */): Unit = definedExternally
    open fun fitBounds(bounds: LatLngBoundsLiteral, padding: Number? = definedExternally /* null */): Unit = definedExternally
    open fun fitBounds(bounds: LatLngBoundsLiteral, padding: Padding? = definedExternally /* null */): Unit = definedExternally
    open fun getBounds(): LatLngBounds? = definedExternally
    open fun getCenter(): LatLng = definedExternally
    open fun getDiv(): Element = definedExternally
    open fun getHeading(): Number = definedExternally
    open fun getMapTypeId(): dynamic /* String | MapTypeId */ = definedExternally
    open fun getProjection(): Projection = definedExternally
    open fun getStreetView(): StreetViewPanorama = definedExternally
    open fun getTilt(): Number = definedExternally
    open fun getZoom(): Number = definedExternally
    open fun panBy(x: Number, y: Number): Unit = definedExternally
    open fun panTo(latLng: LatLng): Unit = definedExternally
    open fun panTo(latLng: LatLngLiteral): Unit = definedExternally
    open fun panToBounds(latLngBounds: LatLngBounds, padding: Number? = definedExternally /* null */): Unit = definedExternally
    open fun panToBounds(latLngBounds: LatLngBounds, padding: Padding? = definedExternally /* null */): Unit = definedExternally
    open fun panToBounds(latLngBounds: LatLngBoundsLiteral, padding: Number? = definedExternally /* null */): Unit = definedExternally
    open fun panToBounds(latLngBounds: LatLngBoundsLiteral, padding: Padding? = definedExternally /* null */): Unit = definedExternally
    open fun setCenter(latlng: LatLng): Unit = definedExternally
    open fun setCenter(latlng: LatLngLiteral): Unit = definedExternally
    open fun setHeading(heading: Number): Unit = definedExternally
    open fun setMapTypeId(mapTypeId: String): Unit = definedExternally
    open fun setMapTypeId(mapTypeId: MapTypeId): Unit = definedExternally
    open fun setOptions(options: MapOptions): Unit = definedExternally
    open fun setStreetView(panorama: StreetViewPanorama): Unit = definedExternally
    open fun setTilt(tilt: Number): Unit = definedExternally
    open fun setZoom(zoom: Number): Unit = definedExternally
    open var controls: Array<MVCArray<Node>> = definedExternally
    open var data: Data = definedExternally
    open var mapTypes: MapTypeRegistry = definedExternally
    open var overlayMapTypes: MVCArray<MapType> = definedExternally
    open fun setClickableIcons(clickable: Boolean): Unit = definedExternally
    open fun fitBounds(bounds: LatLngBounds): Unit = definedExternally
    open fun fitBounds(bounds: LatLngBoundsLiteral): Unit = definedExternally
    open fun panToBounds(latLngBounds: LatLngBounds): Unit = definedExternally
    open fun panToBounds(latLngBounds: LatLngBoundsLiteral): Unit = definedExternally
}

external interface Padding {
    var bottom: Number
    var left: Number
    var right: Number
    var top: Number
}

external interface MapOptions {
    var backgroundColor: String? get() = definedExternally; set(value) = definedExternally
    var center: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var clickableIcons: Boolean? get() = definedExternally; set(value) = definedExternally
    var disableDefaultUI: Boolean? get() = definedExternally; set(value) = definedExternally
    var disableDoubleClickZoom: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggableCursor: String? get() = definedExternally; set(value) = definedExternally
    var draggingCursor: String? get() = definedExternally; set(value) = definedExternally
    var fullscreenControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var fullscreenControlOptions: FullscreenControlOptions? get() = definedExternally; set(value) = definedExternally
    var gestureHandling: dynamic /* String /* "cooperative" */ | String /* "greedy" */ | String /* "none" */ | String /* "auto" */ */ get() = definedExternally; set(value) = definedExternally
    var heading: Number? get() = definedExternally; set(value) = definedExternally
    var keyboardShortcuts: Boolean? get() = definedExternally; set(value) = definedExternally
    var mapTypeControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var mapTypeControlOptions: MapTypeControlOptions? get() = definedExternally; set(value) = definedExternally
    var mapTypeId: MapTypeId? get() = definedExternally; set(value) = definedExternally
    var maxZoom: Number? get() = definedExternally; set(value) = definedExternally
    var minZoom: Number? get() = definedExternally; set(value) = definedExternally
    var noClear: Boolean? get() = definedExternally; set(value) = definedExternally
    var overviewMapControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var overviewMapControlOptions: OverviewMapControlOptions? get() = definedExternally; set(value) = definedExternally
    var panControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var panControlOptions: PanControlOptions? get() = definedExternally; set(value) = definedExternally
    var rotateControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var rotateControlOptions: RotateControlOptions? get() = definedExternally; set(value) = definedExternally
    var scaleControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var scaleControlOptions: ScaleControlOptions? get() = definedExternally; set(value) = definedExternally
    var scrollwheel: Boolean? get() = definedExternally; set(value) = definedExternally
    var signInControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var streetView: StreetViewPanorama? get() = definedExternally; set(value) = definedExternally
    var streetViewControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var streetViewControlOptions: StreetViewControlOptions? get() = definedExternally; set(value) = definedExternally
    var styles: Array<MapTypeStyle>? get() = definedExternally; set(value) = definedExternally
    var tilt: Number? get() = definedExternally; set(value) = definedExternally
    var zoom: Number? get() = definedExternally; set(value) = definedExternally
    var zoomControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var zoomControlOptions: ZoomControlOptions? get() = definedExternally; set(value) = definedExternally
}

external enum class MapTypeId {
    HYBRID,
    ROADMAP,
    SATELLITE,
    TERRAIN
}

external interface MapTypeControlOptions {
    var mapTypeIds: Array<dynamic /* String | MapTypeId */>? get() = definedExternally; set(value) = definedExternally
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
    var style: MapTypeControlStyle? get() = definedExternally; set(value) = definedExternally
}

external enum class MapTypeControlStyle {
    DEFAULT,
    DROPDOWN_MENU,
    HORIZONTAL_BAR
}

external interface OverviewMapControlOptions {
    var opened: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface PanControlOptions {
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
}

external interface RotateControlOptions {
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
}

external interface ScaleControlOptions {
    var style: ScaleControlStyle? get() = definedExternally; set(value) = definedExternally
}

external enum class ScaleControlStyle {
    DEFAULT
}

external interface StreetViewControlOptions {
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
}

external interface ZoomControlOptions {
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
    var style: ZoomControlStyle? get() = definedExternally; set(value) = definedExternally
}

external enum class ZoomControlStyle {
    DEFAULT,
    LARGE,
    SMALL
}

external enum class ControlPosition {
    BOTTOM_CENTER,
    BOTTOM_LEFT,
    BOTTOM_RIGHT,
    LEFT_BOTTOM,
    LEFT_CENTER,
    LEFT_TOP,
    RIGHT_BOTTOM,
    RIGHT_CENTER,
    RIGHT_TOP,
    TOP_CENTER,
    TOP_LEFT,
    TOP_RIGHT
}

open external class Data(options: DataOptions? = definedExternally /* null */) : MVCObject {
    open fun add(feature: Feature): Feature = definedExternally
    open fun add(feature: FeatureOptions): Feature = definedExternally
    open fun addGeoJson(geoJson: Any, options: GeoJsonOptions? = definedExternally /* null */): Array<Feature> = definedExternally
    open fun contains(feature: Feature): Boolean = definedExternally
    open fun forEach(callback: (feature: Feature) -> Unit): Unit = definedExternally
    open fun getControlPosition(): ControlPosition = definedExternally
    open fun getControls(): Array<dynamic /* String /* "Point" */ | String /* "LineString" */ | String /* "Polygon" */ */> = definedExternally
    open fun getDrawingMode(): dynamic /* String /* "Point" */ | String /* "LineString" */ | String /* "Polygon" */ */ = definedExternally
    open fun getFeatureById(id: String): Feature = definedExternally
    open fun getFeatureById(id: Number): Feature = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getStyle(): dynamic /* (feature: Feature) -> StyleOptions | StyleOptions */ = definedExternally
    open fun loadGeoJson(url: String, options: GeoJsonOptions? = definedExternally /* null */, callback: ((features: Array<Feature>) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    open fun overrideStyle(feature: Feature, style: StyleOptions): Unit = definedExternally
    open fun remove(feature: Feature): Unit = definedExternally
    open fun revertStyle(feature: Feature? = definedExternally /* null */): Unit = definedExternally
    open fun setControlPosition(controlPosition: ControlPosition): Unit = definedExternally
    open fun setControls(controls: Array<dynamic /* String /* "Point" */ | String /* "LineString" */ | String /* "Polygon" */ */>?): Unit = definedExternally
    open fun setDrawingMode(drawingMode: String /* "Point" */): Unit = definedExternally
    open fun setDrawingMode(drawingMode: String /* "LineString" */): Unit = definedExternally
    open fun setDrawingMode(drawingMode: String /* "Polygon" */): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setStyle(style: (feature: Feature) -> StyleOptions): Unit = definedExternally
    open fun setStyle(style: StyleOptions): Unit = definedExternally
    open fun toGeoJson(callback: (feature: Any) -> Unit): Unit = definedExternally
    interface DataOptions {
        var controlPosition: ControlPosition? get() = definedExternally; set(value) = definedExternally
        var controls: Array<dynamic /* String /* "Point" */ | String /* "LineString" */ | String /* "Polygon" */ */>? get() = definedExternally; set(value) = definedExternally
        var drawingMode: dynamic /* String /* "Point" */ | String /* "LineString" */ | String /* "Polygon" */ */ get() = definedExternally; set(value) = definedExternally
        var featureFactory: ((geometry: Geometry) -> Feature)? get() = definedExternally; set(value) = definedExternally
        var map: Map? get() = definedExternally; set(value) = definedExternally
        var style: dynamic /* (feature: Feature) -> StyleOptions | StyleOptions */ get() = definedExternally; set(value) = definedExternally
    }

    interface GeoJsonOptions {
        var idPropertyName: String? get() = definedExternally; set(value) = definedExternally
    }

    interface StyleOptions {
        var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
        var cursor: String? get() = definedExternally; set(value) = definedExternally
        var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
        var editable: Boolean? get() = definedExternally; set(value) = definedExternally
        var fillColor: String? get() = definedExternally; set(value) = definedExternally
        var fillOpacity: Number? get() = definedExternally; set(value) = definedExternally
        var icon: dynamic /* String | Icon | Symbol */ get() = definedExternally; set(value) = definedExternally
        var shape: MarkerShape? get() = definedExternally; set(value) = definedExternally
        var strokeColor: String? get() = definedExternally; set(value) = definedExternally
        var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
        var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
        var title: String? get() = definedExternally; set(value) = definedExternally
        var visible: Boolean? get() = definedExternally; set(value) = definedExternally
        var zIndex: Number? get() = definedExternally; set(value) = definedExternally
    }

    open class Feature(options: FeatureOptions? = definedExternally /* null */) {
        open fun forEachProperty(callback: (value: Any, name: String) -> Unit): Unit = definedExternally
        open fun getGeometry(): Geometry = definedExternally
        open fun getId(): dynamic /* String | Number */ = definedExternally
        open fun getProperty(name: String): Any = definedExternally
        open fun removeProperty(name: String): Unit = definedExternally
        open fun setGeometry(newGeometry: LatLng): Unit = definedExternally
        open fun setGeometry(newGeometry: LatLngLiteral): Unit = definedExternally
        open fun setGeometry(newGeometry: Geometry): Unit = definedExternally
        open fun setProperty(name: String, newValue: Any): Unit = definedExternally
        open fun toGeoJson(callback: (feature: Any) -> Unit): Unit = definedExternally
    }

    interface FeatureOptions {
        var geometry: dynamic /* LatLng | LatLngLiteral | Geometry */ get() = definedExternally; set(value) = definedExternally
        var id: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
        var properties: Any? get() = definedExternally; set(value) = definedExternally
    }

    open class Geometry {
        open fun getType(): String = definedExternally
        open fun forEachLatLng(callback: (latLng: LatLng) -> Unit): Unit = definedExternally
    }

    open class Point : Geometry {
        constructor(latLng: LatLng)
        constructor(latLng: LatLngLiteral)

        open fun get(): LatLng = definedExternally
    }

    open class MultiPoint(elements: Array<dynamic /* LatLng | LatLngLiteral */>) : Geometry {
        open fun getArray(): Array<LatLng> = definedExternally
        open fun getAt(n: Number): LatLng = definedExternally
        open fun getLength(): Number = definedExternally
    }

    open class LineString(elements: Array<dynamic /* LatLng | LatLngLiteral */>) : Geometry {
        open fun getArray(): Array<LatLng> = definedExternally
        open fun getAt(n: Number): LatLng = definedExternally
        open fun getLength(): Number = definedExternally
    }

    open class MultiLineString(elements: Array<dynamic /* Array<dynamic /* LatLng | LatLngLiteral */> | LineString */>) : Geometry {
        open fun getArray(): Array<LineString> = definedExternally
        open fun getAt(n: Number): LineString = definedExternally
        open fun getLength(): Number = definedExternally
    }

    open class LinearRing(elements: Array<dynamic /* LatLng | LatLngLiteral */>) : Geometry {
        open fun getArray(): Array<LatLng> = definedExternally
        open fun getAt(n: Number): LatLng = definedExternally
        open fun getLength(): Number = definedExternally
    }

    open class Polygon(elements: Array<dynamic /* Array<dynamic /* LatLng | LatLngLiteral */> | LinearRing */>) : Geometry {
        open fun getArray(): Array<LinearRing> = definedExternally
        open fun getAt(n: Number): LinearRing = definedExternally
        open fun getLength(): Number = definedExternally
    }

    open class MultiPolygon(elements: Array<dynamic /* Polygon | Array<dynamic /* Array<dynamic /* LatLng | LatLngLiteral */> | LinearRing */> */>) : Geometry {
        open fun getArray(): Array<Polygon> = definedExternally
        open fun getAt(n: Number): Polygon = definedExternally
        open fun getLength(): Number = definedExternally
    }

    open class GeometryCollection(elements: Array<dynamic /* LatLngLiteral | Array<LatLng> | Array<Geometry> */>) : Geometry {
        open fun getArray(): Array<Geometry> = definedExternally
        open fun getAt(n: Number): Geometry = definedExternally
        open fun getLength(): Number = definedExternally
    }

    interface MouseEvent : com.github.onotoliy.opposite.treasure.maps.MouseEvent {
        var feature: Feature
    }

    interface AddFeatureEvent {
        var feature: Feature
    }

    interface RemoveFeatureEvent {
        var feature: Feature
    }

    interface SetGeometryEvent {
        var feature: Feature
        var newGeometry: Geometry
        var oldGeometry: Geometry
    }

    interface SetPropertyEvent {
        var feature: Feature
        var name: String
        var newValue: Any
        var oldValue: Any
    }

    interface RemovePropertyEvent {
        var feature: Feature
        var name: String
        var oldValue: Any
    }
}

open external class Marker(opts: MarkerOptions? = definedExternally /* null */) : MVCObject {
    open fun getAnimation(): Animation = definedExternally
    open fun getAttribution(): Attribution = definedExternally
    open fun getClickable(): Boolean = definedExternally
    open fun getCursor(): String = definedExternally
    open fun getDraggable(): Boolean = definedExternally
    open fun getIcon(): dynamic /* String | Icon | Symbol */ = definedExternally
    open fun getLabel(): MarkerLabel = definedExternally
    open fun getMap(): dynamic /* Map | StreetViewPanorama */ = definedExternally
    open fun getOpacity(): Number = definedExternally
    open fun getPlace(): Place = definedExternally
    open fun getPosition(): LatLng = definedExternally
    open fun getShape(): MarkerShape = definedExternally
    open fun getTitle(): String = definedExternally
    open fun getVisible(): Boolean = definedExternally
    open fun getZIndex(): Number = definedExternally
    open fun setAnimation(animation: Animation?): Unit = definedExternally
    open fun setAttribution(attribution: Attribution): Unit = definedExternally
    open fun setClickable(flag: Boolean): Unit = definedExternally
    open fun setCursor(cursor: String): Unit = definedExternally
    open fun setDraggable(flag: Boolean): Unit = definedExternally
    open fun setIcon(icon: String): Unit = definedExternally
    open fun setIcon(icon: Icon): Unit = definedExternally
    open fun setIcon(icon: Symbol): Unit = definedExternally
    open fun setLabel(label: String): Unit = definedExternally
    open fun setLabel(label: MarkerLabel): Unit = definedExternally
    open fun setMap(map: Map): Unit = definedExternally
    open fun setMap(map: StreetViewPanorama): Unit = definedExternally
    open fun setOpacity(opacity: Number): Unit = definedExternally
    open fun setOptions(options: MarkerOptions): Unit = definedExternally
    open fun setPlace(place: Place): Unit = definedExternally
    open fun setPosition(latlng: LatLng): Unit = definedExternally
    open fun setPosition(latlng: LatLngLiteral): Unit = definedExternally
    open fun setShape(shape: MarkerShape): Unit = definedExternally
    open fun setTitle(title: String): Unit = definedExternally
    open fun setVisible(visible: Boolean): Unit = definedExternally
    open fun setZIndex(zIndex: Number): Unit = definedExternally

    companion object {
        var MAX_ZINDEX: Number = definedExternally
    }
}

external interface MarkerOptions {
    var anchorPoint: Point? get() = definedExternally; set(value) = definedExternally
    var animation: Animation? get() = definedExternally; set(value) = definedExternally
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var cursor: String? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var icon: dynamic /* String | Icon | Symbol */ get() = definedExternally; set(value) = definedExternally
    var label: dynamic /* String | MarkerLabel */ get() = definedExternally; set(value) = definedExternally
    var map: dynamic /* Map | StreetViewPanorama */ get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var optimized: Boolean? get() = definedExternally; set(value) = definedExternally
    var place: Place? get() = definedExternally; set(value) = definedExternally
    var position: dynamic /* LatLng | LatLngLiteral */
    var shape: MarkerShape? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

external interface Icon {
    var anchor: Point? get() = definedExternally; set(value) = definedExternally
    var labelOrigin: Point? get() = definedExternally; set(value) = definedExternally
    var origin: Point? get() = definedExternally; set(value) = definedExternally
    var scaledSize: Size? get() = definedExternally; set(value) = definedExternally
    var size: Size? get() = definedExternally; set(value) = definedExternally
    var url: String? get() = definedExternally; set(value) = definedExternally
}

external interface MarkerLabel {
    var color: String? get() = definedExternally; set(value) = definedExternally
    var fontFamily: String? get() = definedExternally; set(value) = definedExternally
    var fontSize: String? get() = definedExternally; set(value) = definedExternally
    var fontWeight: String? get() = definedExternally; set(value) = definedExternally
    var text: String? get() = definedExternally; set(value) = definedExternally
}

external interface MarkerShape {
    var coords: Array<Number>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}

external interface Symbol {
    var anchor: Point? get() = definedExternally; set(value) = definedExternally
    var fillColor: String? get() = definedExternally; set(value) = definedExternally
    var fillOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var path: dynamic /* String | SymbolPath */ get() = definedExternally; set(value) = definedExternally
    var rotation: Number? get() = definedExternally; set(value) = definedExternally
    var scale: Number? get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
}

external enum class SymbolPath {
    BACKWARD_CLOSED_ARROW,
    BACKWARD_OPEN_ARROW,
    CIRCLE,
    FORWARD_CLOSED_ARROW,
    FORWARD_OPEN_ARROW
}

external enum class Animation {
    BOUNCE,
    DROP
}

open external class InfoWindow(opts: InfoWindowOptions? = definedExternally /* null */) : MVCObject {
    open fun close(): Unit = definedExternally
    open fun getContent(): dynamic /* String | Element */ = definedExternally
    open fun getPosition(): LatLng = definedExternally
    open fun getZIndex(): Number = definedExternally
    open fun open(map: Map? = definedExternally /* null */, anchor: MVCObject? = definedExternally /* null */): Unit = definedExternally
    open fun open(map: StreetViewPanorama? = definedExternally /* null */, anchor: MVCObject? = definedExternally /* null */): Unit = definedExternally
    open fun setContent(content: String): Unit = definedExternally
    open fun setContent(content: Node): Unit = definedExternally
    open fun setOptions(options: InfoWindowOptions): Unit = definedExternally
    open fun setPosition(position: LatLng): Unit = definedExternally
    open fun setPosition(position: LatLngLiteral): Unit = definedExternally
    open fun setZIndex(zIndex: Number): Unit = definedExternally
    open fun open(): Unit = definedExternally
}

external interface InfoWindowOptions {
    var content: dynamic /* String | Node */ get() = definedExternally; set(value) = definedExternally
    var disableAutoPan: Boolean? get() = definedExternally; set(value) = definedExternally
    var maxWidth: Number? get() = definedExternally; set(value) = definedExternally
    var pixelOffset: Size? get() = definedExternally; set(value) = definedExternally
    var position: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

open external class Polyline(opts: PolylineOptions? = definedExternally /* null */) : MVCObject {
    open fun getDraggable(): Boolean = definedExternally
    open fun getEditable(): Boolean = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getPath(): MVCArray<LatLng> = definedExternally
    open fun getVisible(): Boolean = definedExternally
    open fun setDraggable(draggable: Boolean): Unit = definedExternally
    open fun setEditable(editable: Boolean): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: PolylineOptions): Unit = definedExternally
    open fun setPath(path: Array<LatLng>): Unit = definedExternally
    open fun setPath(path: MVCArray<LatLng>): Unit = definedExternally
    open fun setPath(path: Array<LatLngLiteral>): Unit = definedExternally
    open fun setVisible(visible: Boolean): Unit = definedExternally
}

external interface PolylineOptions {
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var editable: Boolean? get() = definedExternally; set(value) = definedExternally
    var geodesic: Boolean? get() = definedExternally; set(value) = definedExternally
    var icons: Array<IconSequence>? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var path: dynamic /* Array<LatLng> | MVCArray<LatLng> | Array<LatLngLiteral> */ get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

external interface IconSequence {
    var fixedRotation: Boolean? get() = definedExternally; set(value) = definedExternally
    var icon: Symbol? get() = definedExternally; set(value) = definedExternally
    var offset: String? get() = definedExternally; set(value) = definedExternally
    var repeat: String? get() = definedExternally; set(value) = definedExternally
}

open external class Polygon(opts: PolygonOptions? = definedExternally /* null */) : MVCObject {
    open fun getDraggable(): Boolean = definedExternally
    open fun getEditable(): Boolean = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getPath(): MVCArray<LatLng> = definedExternally
    open fun getPaths(): MVCArray<MVCArray<LatLng>> = definedExternally
    open fun getVisible(): Boolean = definedExternally
    open fun setDraggable(draggable: Boolean): Unit = definedExternally
    open fun setEditable(editable: Boolean): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: PolygonOptions): Unit = definedExternally
    open fun setPath(path: Array<LatLng>): Unit = definedExternally
    open fun setPath(path: MVCArray<LatLng>): Unit = definedExternally
    open fun setPath(path: Array<LatLngLiteral>): Unit = definedExternally
    open fun setPaths(paths: Array<LatLng>): Unit = definedExternally
    open fun setPaths(paths: MVCArray<LatLng>): Unit = definedExternally
    open fun setPaths(paths: Array<LatLngLiteral>): Unit = definedExternally
    open fun setPaths(paths: MVCArray<MVCArray<LatLng>>): Unit = definedExternally
    open fun setPaths(paths: Array<Array<LatLng>>): Unit = definedExternally
    open fun setPaths(paths: Array<Array<LatLngLiteral>>): Unit = definedExternally
    open fun setVisible(visible: Boolean): Unit = definedExternally
}

external interface PolygonOptions {
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var editable: Boolean? get() = definedExternally; set(value) = definedExternally
    var fillColor: String? get() = definedExternally; set(value) = definedExternally
    var fillOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var geodesic: Boolean? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var paths: dynamic /* Array<LatLng> | MVCArray<LatLng> | Array<LatLngLiteral> | MVCArray<MVCArray<LatLng>> | Array<Array<LatLng>> | Array<Array<LatLngLiteral>> */ get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokePosition: StrokePosition? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

external interface PolyMouseEvent : MouseEvent {
    var edge: Number? get() = definedExternally; set(value) = definedExternally
    var path: Number? get() = definedExternally; set(value) = definedExternally
    var vertex: Number? get() = definedExternally; set(value) = definedExternally
}

open external class Rectangle(opts: RectangleOptions? = definedExternally /* null */) : MVCObject {
    open fun getBounds(): LatLngBounds = definedExternally
    open fun getDraggable(): Boolean = definedExternally
    open fun getEditable(): Boolean = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getVisible(): Boolean = definedExternally
    open fun setBounds(bounds: LatLngBounds): Unit = definedExternally
    open fun setBounds(bounds: LatLngBoundsLiteral): Unit = definedExternally
    open fun setDraggable(draggable: Boolean): Unit = definedExternally
    open fun setEditable(editable: Boolean): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: RectangleOptions): Unit = definedExternally
    open fun setVisible(visible: Boolean): Unit = definedExternally
}

external interface RectangleOptions {
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var editable: Boolean? get() = definedExternally; set(value) = definedExternally
    var fillColor: String? get() = definedExternally; set(value) = definedExternally
    var fillOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokePosition: StrokePosition? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

open external class Circle(opts: CircleOptions? = definedExternally /* null */) : MVCObject {
    open fun getBounds(): LatLngBounds = definedExternally
    open fun getCenter(): LatLng = definedExternally
    open fun getDraggable(): Boolean = definedExternally
    open fun getEditable(): Boolean = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getRadius(): Number = definedExternally
    open fun getVisible(): Boolean = definedExternally
    open fun setCenter(center: LatLng): Unit = definedExternally
    open fun setCenter(center: LatLngLiteral): Unit = definedExternally
    open fun setDraggable(draggable: Boolean): Unit = definedExternally
    open fun setEditable(editable: Boolean): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: CircleOptions): Unit = definedExternally
    open fun setRadius(radius: Number): Unit = definedExternally
    open fun setVisible(visible: Boolean): Unit = definedExternally
}

external interface CircleOptions {
    var center: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var editable: Boolean? get() = definedExternally; set(value) = definedExternally
    var fillColor: String? get() = definedExternally; set(value) = definedExternally
    var fillOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokePosition: StrokePosition? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

external interface CircleLiteral : CircleOptions {
    override var center: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    override var radius: Number? get() = definedExternally; set(value) = definedExternally
}

external enum class StrokePosition {
    CENTER,
    INSIDE,
    OUTSIDE
}

open external class GroundOverlay : MVCObject {
    constructor(url: String, bounds: LatLngBounds, opts: GroundOverlayOptions? = definedExternally /* null */)
    constructor(url: String, bounds: LatLngBoundsLiteral, opts: GroundOverlayOptions? = definedExternally /* null */)

    open fun getBounds(): LatLngBounds = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getOpacity(): Number = definedExternally
    open fun getUrl(): String = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOpacity(opacity: Number): Unit = definedExternally
}

external interface GroundOverlayOptions {
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
}

open external class OverlayView : MVCObject {
    open fun draw(): Unit = definedExternally
    open fun getMap(): dynamic /* Map | StreetViewPanorama */ = definedExternally
    open fun getPanes(): MapPanes = definedExternally
    open fun getProjection(): MapCanvasProjection = definedExternally
    open fun onAdd(): Unit = definedExternally
    open fun onRemove(): Unit = definedExternally
    open fun setMap(map: Map): Unit = definedExternally
    open fun setMap(map: StreetViewPanorama): Unit = definedExternally
}

external interface MapPanes {
    var floatPane: Element
    var floatShadow: Element
    var mapPane: Element
    var markerLayer: Element
    var overlayImage: Element
    var overlayLayer: Element
    var overlayMouseTarget: Element
    var overlayShadow: Element
}

open external class MapCanvasProjection : MVCObject {
    open fun fromContainerPixelToLatLng(pixel: Point, nowrap: Boolean? = definedExternally /* null */): LatLng = definedExternally
    open fun fromDivPixelToLatLng(pixel: Point, nowrap: Boolean? = definedExternally /* null */): LatLng = definedExternally
    open fun fromLatLngToContainerPixel(latLng: LatLng): Point = definedExternally
    open fun fromLatLngToDivPixel(latLng: LatLng): Point = definedExternally
    open fun getWorldWidth(): Number = definedExternally
}

open external class Geocoder {
    open fun geocode(request: GeocoderRequest, callback: (results: Array<GeocoderResult>, status: GeocoderStatus) -> Unit): Unit = definedExternally
}

external interface GeocoderRequest {
    var address: String? get() = definedExternally; set(value) = definedExternally
    var bounds: dynamic /* LatLngBounds | LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var componentRestrictions: GeocoderComponentRestrictions? get() = definedExternally; set(value) = definedExternally
    var location: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var placeId: String? get() = definedExternally; set(value) = definedExternally
    var region: String? get() = definedExternally; set(value) = definedExternally
}

external interface GeocoderComponentRestrictions {
    var administrativeArea: String? get() = definedExternally; set(value) = definedExternally
    var country: dynamic /* String | Array<String> */ get() = definedExternally; set(value) = definedExternally
    var locality: String? get() = definedExternally; set(value) = definedExternally
    var postalCode: String? get() = definedExternally; set(value) = definedExternally
    var route: String? get() = definedExternally; set(value) = definedExternally
}

external enum class GeocoderStatus {
    ERROR,
    INVALID_REQUEST,
    OK,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}

external interface GeocoderResult {
    var address_components: Array<GeocoderAddressComponent>
    var formatted_address: String
    var geometry: GeocoderGeometry
    var partial_match: Boolean
    var place_id: String
    var postcode_localities: Array<String>
    var types: Array<String>
}

external interface GeocoderAddressComponent {
    var long_name: String
    var short_name: String
    var types: Array<String>
}

external interface GeocoderGeometry {
    var bounds: LatLngBounds
    var location: LatLng
    var location_type: GeocoderLocationType
    var viewport: LatLngBounds
}

external enum class GeocoderLocationType {
    APPROXIMATE,
    GEOMETRIC_CENTER,
    RANGE_INTERPOLATED,
    ROOFTOP
}

open external class DirectionsRenderer(opts: DirectionsRendererOptions? = definedExternally /* null */) : MVCObject {
    open fun getDirections(): DirectionsResult = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getPanel(): Element = definedExternally
    open fun getRouteIndex(): Number = definedExternally
    open fun setDirections(directions: DirectionsResult): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: DirectionsRendererOptions): Unit = definedExternally
    open fun setPanel(panel: Element): Unit = definedExternally
    open fun setRouteIndex(routeIndex: Number): Unit = definedExternally
}

external interface DirectionsRendererOptions {
    var directions: DirectionsResult? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var hideRouteList: Boolean? get() = definedExternally; set(value) = definedExternally
    var infoWindow: InfoWindow? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var markerOptions: MarkerOptions? get() = definedExternally; set(value) = definedExternally
    var panel: Element? get() = definedExternally; set(value) = definedExternally
    var polylineOptions: PolylineOptions? get() = definedExternally; set(value) = definedExternally
    var preserveViewport: Boolean? get() = definedExternally; set(value) = definedExternally
    var routeIndex: Number? get() = definedExternally; set(value) = definedExternally
    var suppressBicyclingLayer: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressInfoWindows: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressMarkers: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressPolylines: Boolean? get() = definedExternally; set(value) = definedExternally
}

open external class DirectionsService {
    open fun route(request: DirectionsRequest, callback: (result: DirectionsResult, status: DirectionsStatus) -> Unit): Unit = definedExternally
}

external interface DirectionsRequest {
    var avoidFerries: Boolean? get() = definedExternally; set(value) = definedExternally
    var avoidHighways: Boolean? get() = definedExternally; set(value) = definedExternally
    var avoidTolls: Boolean? get() = definedExternally; set(value) = definedExternally
    var destination: dynamic /* String | LatLng | LatLngLiteral | Place */ get() = definedExternally; set(value) = definedExternally
    var durationInTraffic: Boolean? get() = definedExternally; set(value) = definedExternally
    var drivingOptions: DrivingOptions? get() = definedExternally; set(value) = definedExternally
    var optimizeWaypoints: Boolean? get() = definedExternally; set(value) = definedExternally
    var origin: dynamic /* String | LatLng | LatLngLiteral | Place */ get() = definedExternally; set(value) = definedExternally
    var provideRouteAlternatives: Boolean? get() = definedExternally; set(value) = definedExternally
    var region: String? get() = definedExternally; set(value) = definedExternally
    var transitOptions: TransitOptions? get() = definedExternally; set(value) = definedExternally
    var travelMode: TravelMode? get() = definedExternally; set(value) = definedExternally
    var unitSystem: UnitSystem? get() = definedExternally; set(value) = definedExternally
    var waypoints: Array<DirectionsWaypoint>? get() = definedExternally; set(value) = definedExternally
}

external enum class TravelMode {
    BICYCLING,
    DRIVING,
    TRANSIT,
    WALKING
}

external enum class UnitSystem {
    IMPERIAL,
    METRIC
}

external interface TransitOptions {
    var arrivalTime: Date? get() = definedExternally; set(value) = definedExternally
    var departureTime: Date? get() = definedExternally; set(value) = definedExternally
    var modes: Array<TransitMode>? get() = definedExternally; set(value) = definedExternally
    var routingPreference: TransitRoutePreference? get() = definedExternally; set(value) = definedExternally
}

external enum class TransitMode {
    BUS,
    RAIL,
    SUBWAY,
    TRAIN,
    TRAM
}

external enum class TransitRoutePreference {
    FEWER_TRANSFERS,
    LESS_WALKING
}

external interface TransitFare
external interface DrivingOptions {
    var departureTime: Date
    var trafficModel: TrafficModel? get() = definedExternally; set(value) = definedExternally
}

external enum class TrafficModel {
    BEST_GUESS,
    OPTIMISTIC,
    PESSIMISTIC
}

external interface DirectionsWaypoint {
    var location: dynamic /* String | LatLng | LatLngLiteral */
    var stopover: Boolean
}

external enum class DirectionsStatus {
    INVALID_REQUEST,
    MAX_WAYPOINTS_EXCEEDED,
    NOT_FOUND,
    OK,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}

external interface DirectionsResult {
    var geocoded_waypoints: Array<DirectionsGeocodedWaypoint>
    var routes: Array<DirectionsRoute>
}

external interface DirectionsGeocodedWaypoint {
    var partial_match: Boolean
    var place_id: String
    var types: Array<String>
}

external interface DirectionsRoute {
    var bounds: LatLngBounds
    var copyrights: String
    var fare: TransitFare
    var legs: Array<DirectionsLeg>
    var overview_path: Array<LatLng>
    var overview_polyline: String
    var warnings: Array<String>
    var waypoint_order: Array<Number>
}

external interface DirectionsLeg {
    var arrival_time: Time
    var departure_time: Time
    var distance: Distance
    var duration: Duration
    var duration_in_traffic: Duration
    var end_address: String
    var end_location: LatLng
    var start_address: String
    var start_location: LatLng
    var steps: Array<DirectionsStep>
    var via_waypoints: Array<LatLng>
}

external interface DirectionsStep {
    var distance: Distance
    var duration: Duration
    var end_location: LatLng
    var instructions: String
    var path: Array<LatLng>
    var start_location: LatLng
    var steps: DirectionsStep
    var transit: TransitDetails
    var travel_mode: TravelMode
}

external interface Distance {
    var text: String
    var value: Number
}

external interface Duration {
    var text: String
    var value: Number
}

external interface Time {
    var text: String
    var time_zone: String
    var value: Date
}

external interface TransitDetails {
    var arrival_stop: TransitStop
    var arrival_time: Time
    var departure_stop: TransitStop
    var departure_time: Time
    var headsign: String
    var headway: Number
    var line: TransitLine
    var num_stops: Number
}

external interface TransitStop {
    var location: LatLng
    var name: String
}

external interface TransitLine {
    var agencies: Array<TransitAgency>
    var color: String
    var icon: String
    var name: String
    var short_name: String
    var text_color: String
    var url: String
    var vehicle: TransitVehicle
}

external interface TransitAgency {
    var name: String
    var phone: String
    var url: String
}

external interface TransitVehicle {
    var icon: String
    var local_icon: String
    var name: String
    var type: VehicleType
}

external enum class VehicleType {
    BUS,
    CABLE_CAR,
    COMMUTER_TRAIN,
    FERRY,
    FUNICULAR,
    GONDOLA_LIFT,
    HEAVY_RAIL,
    HIGH_SPEED_TRAIN,
    INTERCITY_BUS,
    METRO_RAIL,
    MONORAIL,
    OTHER,
    RAIL,
    SHARE_TAXI,
    SUBWAY,
    TRAM,
    TROLLEYBUS
}

open external class ElevationService {
    open fun getElevationAlongPath(request: PathElevationRequest, callback: (results: Array<ElevationResult>, status: ElevationStatus) -> Unit): Unit = definedExternally
    open fun getElevationForLocations(request: LocationElevationRequest, callback: (results: Array<ElevationResult>, status: ElevationStatus) -> Unit): Unit = definedExternally
}

external interface LocationElevationRequest {
    var locations: Array<LatLng>
}

external interface PathElevationRequest {
    var path: Array<LatLng>? get() = definedExternally; set(value) = definedExternally
    var samples: Number? get() = definedExternally; set(value) = definedExternally
}

external interface ElevationResult {
    var elevation: Number
    var location: LatLng
    var resolution: Number
}

external enum class ElevationStatus {
    INVALID_REQUEST,
    OK,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR
}

open external class MaxZoomService {
    open fun getMaxZoomAtLatLng(latlng: LatLng, callback: (result: MaxZoomResult) -> Unit): Unit = definedExternally
    open fun getMaxZoomAtLatLng(latlng: LatLngLiteral, callback: (result: MaxZoomResult) -> Unit): Unit = definedExternally
}

external interface MaxZoomResult {
    var status: MaxZoomStatus
    var zoom: Number
}

external enum class MaxZoomStatus {
    ERROR,
    OK
}

open external class DistanceMatrixService {
    open fun getDistanceMatrix(request: DistanceMatrixRequest, callback: (response: DistanceMatrixResponse, status: DistanceMatrixStatus) -> Unit): Unit = definedExternally
}

external interface DistanceMatrixRequest {
    var avoidFerries: Boolean? get() = definedExternally; set(value) = definedExternally
    var avoidHighways: Boolean? get() = definedExternally; set(value) = definedExternally
    var avoidTolls: Boolean? get() = definedExternally; set(value) = definedExternally
    var destinations: dynamic /* Array<LatLng> | Array<LatLngLiteral> | Array<String> | Array<Place> */ get() = definedExternally; set(value) = definedExternally
    var drivingOptions: DrivingOptions? get() = definedExternally; set(value) = definedExternally
    var durationInTraffic: Boolean? get() = definedExternally; set(value) = definedExternally
    var origins: dynamic /* Array<LatLng> | Array<LatLngLiteral> | Array<String> | Array<Place> */ get() = definedExternally; set(value) = definedExternally
    var region: String? get() = definedExternally; set(value) = definedExternally
    var transitOptions: TransitOptions? get() = definedExternally; set(value) = definedExternally
    var travelMode: TravelMode? get() = definedExternally; set(value) = definedExternally
    var unitSystem: UnitSystem? get() = definedExternally; set(value) = definedExternally
}

external interface DistanceMatrixResponse {
    var destinationAddresses: Array<String>
    var originAddresses: Array<String>
    var rows: Array<DistanceMatrixResponseRow>
}

external interface DistanceMatrixResponseRow {
    var elements: Array<DistanceMatrixResponseElement>
}

external interface DistanceMatrixResponseElement {
    var distance: Distance
    var duration: Duration
    var duration_in_traffic: Duration
    var fare: TransitFare
    var status: DistanceMatrixElementStatus
}

external enum class DistanceMatrixStatus {
    INVALID_REQUEST,
    MAX_DIMENSIONS_EXCEEDED,
    MAX_ELEMENTS_EXCEEDED,
    OK,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR
}

external enum class DistanceMatrixElementStatus {
    NOT_FOUND,
    OK,
    ZERO_RESULTS
}

external interface Attribution {
    var iosDeepLinkId: String? get() = definedExternally; set(value) = definedExternally
    var source: String? get() = definedExternally; set(value) = definedExternally
    var webUrl: String? get() = definedExternally; set(value) = definedExternally
}

external interface Place {
    var location: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var placeId: String? get() = definedExternally; set(value) = definedExternally
    var query: String? get() = definedExternally; set(value) = definedExternally
}

open external class SaveWidget(container: Node, opts: SaveWidgetOptions? = definedExternally /* null */) {
    open fun getAttribution(): Attribution = definedExternally
    open fun getPlace(): Place = definedExternally
    open fun setAttribution(attribution: Attribution): Unit = definedExternally
    open fun setOptions(opts: SaveWidgetOptions): Unit = definedExternally
    open fun setPlace(place: Place): Unit = definedExternally
}

external interface SaveWidgetOptions {
    var attribution: Attribution? get() = definedExternally; set(value) = definedExternally
    var place: Place? get() = definedExternally; set(value) = definedExternally
}

external interface MapType {
    fun getTile(tileCoord: Point, zoom: Number, ownerDocument: Document): Element
    fun releaseTile(tile: Element)
    var alt: String? get() = definedExternally; set(value) = definedExternally
    var maxZoom: Number? get() = definedExternally; set(value) = definedExternally
    var minZoom: Number? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var projection: Projection? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var tileSize: Size? get() = definedExternally; set(value) = definedExternally
}

open external class MapTypeRegistry : MVCObject {
    open fun set(id: String, mapType: MapType): Unit = definedExternally
}

external interface Projection {
    fun fromLatLngToPoint(latLng: LatLng, point: Point? = definedExternally /* null */): Point
    fun fromPointToLatLng(pixel: Point, noWrap: Boolean? = definedExternally /* null */): LatLng
}

open external class ImageMapType(opts: ImageMapTypeOptions) : MVCObject, MapType {
    open fun getOpacity(): Number = definedExternally
    override fun getTile(tileCoord: Point, zoom: Number, ownerDocument: Document): Element = definedExternally
    override fun releaseTile(tile: Element): Unit = definedExternally
    open fun setOpacity(opacity: Number): Unit = definedExternally
}

external interface ImageMapTypeOptions {
    var alt: String? get() = definedExternally; set(value) = definedExternally
    fun getTileUrl(tileCoord: Point, zoom: Number): String
    var maxZoom: Number? get() = definedExternally; set(value) = definedExternally
    var minZoom: Number? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var opacity: Number? get() = definedExternally; set(value) = definedExternally
    var tileSize: Size? get() = definedExternally; set(value) = definedExternally
}

open external class StyledMapType(styles: Array<MapTypeStyle>, options: StyledMapTypeOptions? = definedExternally /* null */) : MVCObject, MapType {
    override fun getTile(tileCoord: Point, zoom: Number, ownerDocument: Document): Element = definedExternally
    override fun releaseTile(tile: Element): Unit = definedExternally
}

external interface StyledMapTypeOptions {
    var alt: String? get() = definedExternally; set(value) = definedExternally
    var maxZoom: Number? get() = definedExternally; set(value) = definedExternally
    var minZoom: Number? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
}

external interface MapTypeStyle {
    var elementType: dynamic /* String /* "all" */ | String /* "geometry" */ | String /* "geometry.fill" */ | String /* "geometry.stroke" */ | String /* "labels" */ | String /* "labels.icon" */ | String /* "labels.text" */ | String /* "labels.text.fill" */ | String /* "labels.text.stroke" */ */ get() = definedExternally; set(value) = definedExternally
    var featureType: dynamic /* String /* "all" */ | String /* "administrative" */ | String /* "administrative.country" */ | String /* "administrative.land_parcel" */ | String /* "administrative.locality" */ | String /* "administrative.neighborhood" */ | String /* "administrative.province" */ | String /* "landscape" */ | String /* "landscape.man_made" */ | String /* "landscape.natural" */ | String /* "landscape.natural.landcover" */ | String /* "landscape.natural.terrain" */ | String /* "poi" */ | String /* "poi.attraction" */ | String /* "poi.business" */ | String /* "poi.government" */ | String /* "poi.medical" */ | String /* "poi.park" */ | String /* "poi.place_of_worship" */ | String /* "poi.school" */ | String /* "poi.sports_complex" */ | String /* "road" */ | String /* "road.arterial" */ | String /* "road.highway" */ | String /* "road.highway.controlled_access" */ | String /* "road.local" */ | String /* "transit" */ | String /* "transit.line" */ | String /* "transit.station" */ | String /* "transit.station.airport" */ | String /* "transit.station.bus" */ | String /* "transit.station.rail" */ | String /* "water" */ */
        get() = definedExternally
        set(value) = definedExternally
    var stylers: Array<MapTypeStyler>? get() = definedExternally; set(value) = definedExternally
}

external interface MapTypeStyler {
    var color: String? get() = definedExternally; set(value) = definedExternally
    var gamma: Number? get() = definedExternally; set(value) = definedExternally
    var hue: String? get() = definedExternally; set(value) = definedExternally
    var invert_lightness: Boolean? get() = definedExternally; set(value) = definedExternally
    var lightness: Number? get() = definedExternally; set(value) = definedExternally
    var saturation: Number? get() = definedExternally; set(value) = definedExternally
    var visibility: String? get() = definedExternally; set(value) = definedExternally
    var weight: Number? get() = definedExternally; set(value) = definedExternally
}

open external class BicyclingLayer : MVCObject {
    open fun getMap(): Map = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
}

open external class FusionTablesLayer(options: FusionTablesLayerOptions) : MVCObject {
    open fun getMap(): Map = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: FusionTablesLayerOptions): Unit = definedExternally
}

external interface FusionTablesLayerOptions {
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var heatmap: FusionTablesHeatmap? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var query: FusionTablesQuery? get() = definedExternally; set(value) = definedExternally
    var styles: Array<FusionTablesStyle>? get() = definedExternally; set(value) = definedExternally
    var suppressInfoWindows: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface FusionTablesQuery {
    var from: String? get() = definedExternally; set(value) = definedExternally
    var limit: Number? get() = definedExternally; set(value) = definedExternally
    var offset: Number? get() = definedExternally; set(value) = definedExternally
    var orderBy: String? get() = definedExternally; set(value) = definedExternally
    var select: String? get() = definedExternally; set(value) = definedExternally
    var where: String? get() = definedExternally; set(value) = definedExternally
}

external interface FusionTablesStyle {
    var markerOptions: FusionTablesMarkerOptions? get() = definedExternally; set(value) = definedExternally
    var polygonOptions: FusionTablesPolygonOptions? get() = definedExternally; set(value) = definedExternally
    var polylineOptions: FusionTablesPolylineOptions? get() = definedExternally; set(value) = definedExternally
    var where: String? get() = definedExternally; set(value) = definedExternally
}

external interface FusionTablesHeatmap {
    var enabled: Boolean
}

external interface FusionTablesMarkerOptions {
    var iconName: String
}

external interface FusionTablesPolygonOptions {
    var fillColor: String? get() = definedExternally; set(value) = definedExternally
    var fillOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
}

external interface FusionTablesPolylineOptions {
    var strokeColor: String? get() = definedExternally; set(value) = definedExternally
    var strokeOpacity: Number? get() = definedExternally; set(value) = definedExternally
    var strokeWeight: Number? get() = definedExternally; set(value) = definedExternally
}

external interface FusionTablesMouseEvent {
    var infoWindowHtml: String? get() = definedExternally; set(value) = definedExternally
    var latLng: LatLng? get() = definedExternally; set(value) = definedExternally
    var pixelOffset: Size? get() = definedExternally; set(value) = definedExternally
    var row: Any? get() = definedExternally; set(value) = definedExternally
}

external interface FusionTablesCell {
    var columnName: String? get() = definedExternally; set(value) = definedExternally
    var value: String? get() = definedExternally; set(value) = definedExternally
}

open external class KmlLayer(opts: KmlLayerOptions? = definedExternally /* null */) : MVCObject {
    open fun getDefaultViewport(): LatLngBounds = definedExternally
    open fun getMap(): Map = definedExternally
    open fun getMetadata(): KmlLayerMetadata = definedExternally
    open fun getStatus(): KmlLayerStatus = definedExternally
    open fun getUrl(): String = definedExternally
    open fun getZIndex(): Number = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setUrl(url: String): Unit = definedExternally
    open fun setZIndex(zIndex: Number): Unit = definedExternally
    open fun setOptions(options: KmlLayerOptions): Unit = definedExternally
}

external interface KmlLayerOptions {
    var clickable: Boolean? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
    var preserveViewport: Boolean? get() = definedExternally; set(value) = definedExternally
    var screenOverlays: Boolean? get() = definedExternally; set(value) = definedExternally
    var suppressInfoWindows: Boolean? get() = definedExternally; set(value) = definedExternally
    var url: String? get() = definedExternally; set(value) = definedExternally
    var zIndex: Number? get() = definedExternally; set(value) = definedExternally
}

external interface KmlLayerMetadata {
    var author: KmlAuthor
    var description: String
    var hasScreenOverlays: Boolean
    var name: String
    var snippet: String
}

external enum class KmlLayerStatus {
    DOCUMENT_NOT_FOUND,
    DOCUMENT_TOO_LARGE,
    FETCH_ERROR,
    INVALID_DOCUMENT,
    INVALID_REQUEST,
    LIMITS_EXCEEDED,
    OK,
    TIMED_OUT,
    UNKNOWN
}

external interface KmlMouseEvent {
    var featureData: KmlFeatureData
    var latLng: LatLng
    var pixelOffset: Size
}

external interface KmlFeatureData {
    var author: KmlAuthor
    var description: String
    var id: String
    var infoWindowHtml: String
    var name: String
    var snippet: String
}

external interface KmlAuthor {
    var email: String
    var name: String
    var uri: String
}

open external class TrafficLayer(opts: TrafficLayerOptions? = definedExternally /* null */) : MVCObject {
    open fun getMap(): Map = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
    open fun setOptions(options: TrafficLayerOptions): Unit = definedExternally
}

external interface TrafficLayerOptions {
    var autoRefresh: Boolean? get() = definedExternally; set(value) = definedExternally
    var map: Map? get() = definedExternally; set(value) = definedExternally
}

open external class TransitLayer : MVCObject {
    open fun getMap(): Unit = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
}

open external class StreetViewPanorama(container: Element, opts: StreetViewPanoramaOptions? = definedExternally /* null */) : MVCObject {
    open var controls: Array<MVCArray<Node>> = definedExternally
    open fun getLinks(): Array<StreetViewLink> = definedExternally
    open fun getLocation(): StreetViewLocation = definedExternally
    open fun getMotionTracking(): Boolean = definedExternally
    open fun getPano(): String = definedExternally
    open fun getPhotographerPov(): StreetViewPov = definedExternally
    open fun getPosition(): LatLng = definedExternally
    open fun getPov(): StreetViewPov = definedExternally
    open fun getStatus(): StreetViewStatus = definedExternally
    open fun getVisible(): Boolean = definedExternally
    open fun getZoom(): Number = definedExternally
    open fun registerPanoProvider(provider: (input: String) -> StreetViewPanoramaData): Unit = definedExternally
    open fun setLinks(links: Array<StreetViewLink>): Unit = definedExternally
    open fun setMotionTracking(motionTracking: Boolean): Unit = definedExternally
    open fun setOptions(options: StreetViewPanoramaOptions): Unit = definedExternally
    open fun setPano(pano: String): Unit = definedExternally
    open fun setPosition(latLng: LatLng): Unit = definedExternally
    open fun setPosition(latLng: LatLngLiteral): Unit = definedExternally
    open fun setPov(pov: StreetViewPov): Unit = definedExternally
    open fun setVisible(flag: Boolean): Unit = definedExternally
    open fun setZoom(zoom: Number): Unit = definedExternally
}

external interface FullscreenControlOptions {
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewPanoramaOptions {
    var addressControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var addressControlOptions: StreetViewAddressControlOptions? get() = definedExternally; set(value) = definedExternally
    var clickToGo: Boolean? get() = definedExternally; set(value) = definedExternally
    var disableDefaultUI: Boolean? get() = definedExternally; set(value) = definedExternally
    var disableDoubleClickZoom: Boolean? get() = definedExternally; set(value) = definedExternally
    var enableCloseButton: Boolean? get() = definedExternally; set(value) = definedExternally
    var fullscreenControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var fullscreenControlOptions: FullscreenControlOptions? get() = definedExternally; set(value) = definedExternally
    var imageDateControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var linksControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var motionTracking: Boolean? get() = definedExternally; set(value) = definedExternally
    var motionTrackingControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var motionTrackingControlOptions: MotionTrackingControlOptions? get() = definedExternally; set(value) = definedExternally
    var mode: dynamic /* String /* "html4" */ | String /* "html5" */ | String /* "webgl" */ */ get() = definedExternally; set(value) = definedExternally
    var panControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var panControlOptions: PanControlOptions? get() = definedExternally; set(value) = definedExternally
    var pano: String? get() = definedExternally; set(value) = definedExternally
    var panoProvider: ((input: String) -> StreetViewPanoramaData)? get() = definedExternally; set(value) = definedExternally
    var position: dynamic /* LatLng | LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var pov: StreetViewPov? get() = definedExternally; set(value) = definedExternally
    var scrollwheel: Boolean? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var zoom: Number? get() = definedExternally; set(value) = definedExternally
    var zoomControl: Boolean? get() = definedExternally; set(value) = definedExternally
    var zoomControlOptions: ZoomControlOptions? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewAddressControlOptions {
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewLink {
    var description: String? get() = definedExternally; set(value) = definedExternally
    var heading: Number? get() = definedExternally; set(value) = definedExternally
    var pano: String? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewPov {
    var heading: Number? get() = definedExternally; set(value) = definedExternally
    var pitch: Number? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewPanoramaData {
    var copyright: String? get() = definedExternally; set(value) = definedExternally
    var imageDate: String? get() = definedExternally; set(value) = definedExternally
    var links: Array<StreetViewLink>? get() = definedExternally; set(value) = definedExternally
    var location: StreetViewLocation? get() = definedExternally; set(value) = definedExternally
    var tiles: StreetViewTileData? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewLocation {
    var description: String? get() = definedExternally; set(value) = definedExternally
    var latLng: LatLng? get() = definedExternally; set(value) = definedExternally
    var pano: String? get() = definedExternally; set(value) = definedExternally
    var shortDescription: String? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewTileData {
    fun getTileUrl(pano: String, tileZoom: Number, tileX: Number, tileY: Number): String
    var centerHeading: Number? get() = definedExternally; set(value) = definedExternally
    var tileSize: Size? get() = definedExternally; set(value) = definedExternally
    var worldSize: Size? get() = definedExternally; set(value) = definedExternally
}

external enum class StreetViewPreference {
    BEST,
    NEAREST
}

external enum class StreetViewSource {
    DEFAULT,
    OUTDOOR
}

external interface StreetViewLocationRequest {
    var location: dynamic /* LatLng | LatLngLiteral */
    var preference: StreetViewPreference? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var source: StreetViewSource? get() = definedExternally; set(value) = definedExternally
}

external interface StreetViewPanoRequest {
    var pano: String
}

open external class StreetViewService {
    open fun getPanorama(request: StreetViewLocationRequest, cb: (data: StreetViewPanoramaData, status: StreetViewStatus) -> Unit): Unit = definedExternally
    open fun getPanorama(request: StreetViewPanoRequest, cb: (data: StreetViewPanoramaData, status: StreetViewStatus) -> Unit): Unit = definedExternally
    open fun getPanoramaById(pano: String, callback: (streetViewPanoramaData: StreetViewPanoramaData, streetViewStatus: StreetViewStatus) -> Unit): Unit = definedExternally
    open fun getPanoramaByLocation(latlng: LatLng, radius: Number, callback: (streetViewPanoramaData: StreetViewPanoramaData, streetViewStatus: StreetViewStatus) -> Unit): Unit = definedExternally
    open fun getPanoramaByLocation(latlng: LatLngLiteral, radius: Number, callback: (streetViewPanoramaData: StreetViewPanoramaData, streetViewStatus: StreetViewStatus) -> Unit): Unit = definedExternally
}

external enum class StreetViewStatus {
    OK,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}

open external class StreetViewCoverageLayer : MVCObject {
    open fun getMap(): Map = definedExternally
    open fun setMap(map: Map?): Unit = definedExternally
}

external interface MotionTrackingControlOptions {
    var position: ControlPosition? get() = definedExternally; set(value) = definedExternally
}

external interface MapsEventListener {
    fun remove()
}

open external class event {
    companion object {
        fun addDomListener(instance: Any, eventName: String, handler: Function<*>, capture: Boolean? = definedExternally /* null */): MapsEventListener = definedExternally
        fun addDomListenerOnce(instance: Any, eventName: String, handler: Function<*>, capture: Boolean? = definedExternally /* null */): MapsEventListener = definedExternally
        fun addListener(instance: Any, eventName: String, handler: Function<*>): MapsEventListener = definedExternally
        fun addListenerOnce(instance: Any, eventName: String, handler: Function<*>): MapsEventListener = definedExternally
        fun clearInstanceListeners(instance: Any): Unit = definedExternally
        fun clearListeners(instance: Any, eventName: String): Unit = definedExternally
        fun removeListener(listener: MapsEventListener): Unit = definedExternally
        fun trigger(instance: Any, eventName: String, vararg args: Any): Unit = definedExternally
    }
}

external interface MouseEvent {
    fun stop()
    var latLng: LatLng
}

external interface IconMouseEvent : MouseEvent {
    var placeId: String
}

open external class LatLng(lat: Number, lng: Number, noWrap: Boolean? = definedExternally /* null */) {
    open fun equals(other: LatLng): Boolean = definedExternally
    open fun lat(): Number = definedExternally
    open fun lng(): Number = definedExternally
    override fun toString(): String = definedExternally
    open fun toUrlValue(precision: Number? = definedExternally /* null */): String = definedExternally
    open fun toJSON(): LatLngLiteral = definedExternally
}

external interface LatLngLiteral {
    var lat: Number
    var lng: Number
}

external interface LatLngBoundsLiteral {
    var east: Number
    var north: Number
    var south: Number
    var west: Number
}

open external class LatLngBounds {
    constructor()
    constructor(sw: LatLng? = definedExternally /* null */, ne: LatLng? = definedExternally /* null */)
    constructor(sw: LatLng? = definedExternally /* null */, ne: LatLngLiteral? = definedExternally /* null */)
    constructor(sw: LatLngLiteral? = definedExternally /* null */, ne: LatLng? = definedExternally /* null */)
    constructor(sw: LatLngLiteral? = definedExternally /* null */, ne: LatLngLiteral? = definedExternally /* null */)

    open fun contains(latLng: LatLng): Boolean = definedExternally
    open fun contains(latLng: LatLngLiteral): Boolean = definedExternally
    open fun equals(other: LatLngBounds): Boolean = definedExternally
    open fun equals(other: LatLngBoundsLiteral): Boolean = definedExternally
    open fun extend(point: LatLng): LatLngBounds = definedExternally
    open fun extend(point: LatLngLiteral): LatLngBounds = definedExternally
    open fun getCenter(): LatLng = definedExternally
    open fun getNorthEast(): LatLng = definedExternally
    open fun getSouthWest(): LatLng = definedExternally
    open fun intersects(other: LatLngBounds): Boolean = definedExternally
    open fun intersects(other: LatLngBoundsLiteral): Boolean = definedExternally
    open fun isEmpty(): Boolean = definedExternally
    open fun toJSON(): LatLngBoundsLiteral = definedExternally
    open fun toSpan(): LatLng = definedExternally
    override fun toString(): String = definedExternally
    open fun toUrlValue(precision: Number? = definedExternally /* null */): String = definedExternally
    open fun union(other: LatLngBounds): LatLngBounds = definedExternally
    open fun union(other: LatLngBoundsLiteral): LatLngBounds = definedExternally
}

open external class Point(x: Number, y: Number) {
    open var x: Number = definedExternally
    open var y: Number = definedExternally
    open fun equals(other: Point): Boolean = definedExternally
    override fun toString(): String = definedExternally
}

open external class Size(width: Number, height: Number, widthUnit: String? = definedExternally /* null */, heightUnit: String? = definedExternally /* null */) {
    open var height: Number = definedExternally
    open var width: Number = definedExternally
    open fun equals(other: Size): Boolean = definedExternally
    override fun toString(): String = definedExternally
}

open external class MVCObject {
    open fun addListener(eventName: String, handler: (args: Any) -> Unit): MapsEventListener = definedExternally
    open fun bindTo(key: String, target: MVCObject, targetKey: String? = definedExternally /* null */, noNotify: Boolean? = definedExternally /* null */): Unit = definedExternally
    open fun changed(key: String): Unit = definedExternally
    open fun get(key: String): Any = definedExternally
    open fun notify(key: String): Unit = definedExternally
    open fun set(key: String, value: Any): Unit = definedExternally
    open fun setValues(values: Any): Unit = definedExternally
    open fun unbind(key: String): Unit = definedExternally
    open fun unbindAll(): Unit = definedExternally
}

open external class MVCArray<T>(array: Array<T>? = definedExternally /* null */) : MVCObject {
    open fun clear(): Unit = definedExternally
    open fun forEach(callback: (elem: T, i: Number) -> Unit): Unit = definedExternally
    open fun getArray(): Array<T> = definedExternally
    open fun getAt(i: Number): T = definedExternally
    open fun getLength(): Number = definedExternally
    open fun insertAt(i: Number, elem: T): Unit = definedExternally
    open fun pop(): T = definedExternally
    open fun push(elem: T): Number = definedExternally
    open fun removeAt(i: Number): T = definedExternally
    open fun setAt(i: Number, elem: T): Unit = definedExternally
}
