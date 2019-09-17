@file:Suppress(
        "INTERFACE_WITH_SUPERCLASS",
        "OVERRIDING_FINAL_MEMBER",
        "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
        "CONFLICTING_OVERLOADS",
        "EXTERNAL_DELEGATION",
        "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
        "unused", "SortModifiers", "ClassName"
)
@file:JsQualifier("com.github.onotoliy.opposite.treasure.maps.geometry")

package com.github.onotoliy.opposite.treasure.maps.geometry

open external class encoding {
    companion object {
        fun decodePath(encodedPath: String): Array<com.github.onotoliy.opposite.treasure.maps.LatLng> = definedExternally
        fun encodePath(path: Array<com.github.onotoliy.opposite.treasure.maps.LatLng>): String = definedExternally
        fun encodePath(path: com.github.onotoliy.opposite.treasure.maps.MVCArray<com.github.onotoliy.opposite.treasure.maps.LatLng>): String = definedExternally
    }
}

open external class spherical {
    companion object {
        fun computeArea(path: Array<com.github.onotoliy.opposite.treasure.maps.LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeArea(path: com.github.onotoliy.opposite.treasure.maps.MVCArray<com.github.onotoliy.opposite.treasure.maps.LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeDistanceBetween(from: com.github.onotoliy.opposite.treasure.maps.LatLng, to: com.github.onotoliy.opposite.treasure.maps.LatLng, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeHeading(from: com.github.onotoliy.opposite.treasure.maps.LatLng, to: com.github.onotoliy.opposite.treasure.maps.LatLng): Number = definedExternally
        fun computeLength(path: Array<com.github.onotoliy.opposite.treasure.maps.LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeLength(path: com.github.onotoliy.opposite.treasure.maps.MVCArray<com.github.onotoliy.opposite.treasure.maps.LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeOffset(from: com.github.onotoliy.opposite.treasure.maps.LatLng, distance: Number, heading: Number, radius: Number? = definedExternally /* null */): com.github.onotoliy.opposite.treasure.maps.LatLng = definedExternally
        fun computeOffsetOrigin(to: com.github.onotoliy.opposite.treasure.maps.LatLng, distance: Number, heading: Number, radius: Number? = definedExternally /* null */): com.github.onotoliy.opposite.treasure.maps.LatLng = definedExternally
        fun computeSignedArea(loop: Array<com.github.onotoliy.opposite.treasure.maps.LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun computeSignedArea(loop: com.github.onotoliy.opposite.treasure.maps.MVCArray<com.github.onotoliy.opposite.treasure.maps.LatLng>, radius: Number? = definedExternally /* null */): Number = definedExternally
        fun interpolate(from: com.github.onotoliy.opposite.treasure.maps.LatLng, to: com.github.onotoliy.opposite.treasure.maps.LatLng, fraction: Number): com.github.onotoliy.opposite.treasure.maps.LatLng = definedExternally
    }
}

open external class poly {
    companion object {
        fun containsLocation(point: com.github.onotoliy.opposite.treasure.maps.LatLng, polygon: com.github.onotoliy.opposite.treasure.maps.Polygon): Boolean = definedExternally
        fun isLocationOnEdge(point: com.github.onotoliy.opposite.treasure.maps.LatLng, poly: com.github.onotoliy.opposite.treasure.maps.Polyline, tolerance: Number? = definedExternally /* null */): Boolean = definedExternally
        fun isLocationOnEdge(point: com.github.onotoliy.opposite.treasure.maps.LatLng, poly: com.github.onotoliy.opposite.treasure.maps.Polygon, tolerance: Number? = definedExternally /* null */): Boolean = definedExternally
    }
}
