@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "unused", "PropertyName")
@file:JsQualifier("com.github.onotoliy.opposite.treasure.maps.places")

package com.github.onotoliy.opposite.treasure.maps.places

import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement

open external class Autocomplete(inputField: HTMLInputElement, opts: AutocompleteOptions? = definedExternally /* null */) : com.github.onotoliy.opposite.treasure.maps.MVCObject {
    open fun getBounds(): com.github.onotoliy.opposite.treasure.maps.LatLngBounds = definedExternally
    open fun getPlace(): PlaceResult = definedExternally
    open fun setBounds(bounds: com.github.onotoliy.opposite.treasure.maps.LatLngBounds): Unit = definedExternally
    open fun setBounds(bounds: com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral): Unit = definedExternally
    open fun setComponentRestrictions(restrictions: ComponentRestrictions): Unit = definedExternally
    open fun setTypes(types: Array<String>): Unit = definedExternally
}

external interface AutocompleteOptions {
    var bounds: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var componentRestrictions: ComponentRestrictions? get() = definedExternally; set(value) = definedExternally
    var placeIdOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var strictBounds: Boolean? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}

external interface AutocompletePrediction {
    var description: String
    var matched_substrings: Array<PredictionSubstring>
    var place_id: String
    var reference: String
    var structured_formatting: AutocompleteStructuredFormatting
    var terms: Array<PredictionTerm>
    var types: Array<String>
}

external interface AutocompleteStructuredFormatting {
    var main_text: String
    var main_text_matched_substrings: Array<PredictionSubstring>
    var secondary_text: String
}

external interface OpeningHours {
    var open_now: Boolean
    var periods: Array<OpeningPeriod>
    var weekday_text: Array<String>
}

external interface OpeningPeriod {
    var open: OpeningHoursTime
    var close: OpeningHoursTime? get() = definedExternally; set(value) = definedExternally
}

external interface OpeningHoursTime {
    var day: Number
    var hours: Number
    var minutes: Number
    var nextDate: Number
    var time: String
}

external interface PredictionTerm {
    var offset: Number
    var value: String
}

external interface PredictionSubstring {
    var length: Number
    var offset: Number
}

open external class AutocompleteService {
    open fun getPlacePredictions(request: AutocompletionRequest, callback: (result: Array<AutocompletePrediction>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun getQueryPredictions(request: QueryAutocompletionRequest, callback: (result: Array<QueryAutocompletePrediction>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
}

open external class AutocompleteSessionToken
external interface AutocompletionRequest {
    var bounds: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var componentRestrictions: ComponentRestrictions? get() = definedExternally; set(value) = definedExternally
    var input: String
    var location: com.github.onotoliy.opposite.treasure.maps.LatLng? get() = definedExternally; set(value) = definedExternally
    var offset: Number? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var sessionToken: AutocompleteSessionToken? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
}

external interface ComponentRestrictions {
    var country: dynamic /* String | Array<String> */
}

external interface PlaceAspectRating {
    var rating: Number
    var type: String
}

external interface PlaceDetailsRequest {
    var placeId: String
    var fields: Array<String>? get() = definedExternally; set(value) = definedExternally
    var sessionToken: AutocompleteSessionToken? get() = definedExternally; set(value) = definedExternally
}

external interface PlaceGeometry {
    var location: com.github.onotoliy.opposite.treasure.maps.LatLng
    var viewport: com.github.onotoliy.opposite.treasure.maps.LatLngBounds
}

external interface PlacePhoto {
    var height: Number
    var html_attributions: Array<String>
    var width: Number
    fun getUrl(opts: PhotoOptions): String
}

external interface PhotoOptions {
    var maxHeight: Number? get() = definedExternally; set(value) = definedExternally
    var maxWidth: Number? get() = definedExternally; set(value) = definedExternally
}

external interface PlaceResult {
    var address_components: Array<com.github.onotoliy.opposite.treasure.maps.GeocoderAddressComponent>
    var adr_address: String
    var formatted_address: String
    var formatted_phone_number: String
    var geometry: PlaceGeometry
    var html_attributions: Array<String>
    var icon: String
    var id: String
    var international_phone_number: String
    var name: String
    var opening_hours: OpeningHours
    var permanently_closed: Boolean
    var photos: Array<PlacePhoto>
    var place_id: String
    var price_level: Number
    var rating: Number
    var reviews: Array<PlaceReview>
    var types: Array<String>
    var url: String
    var utc_offset: Number
    var vicinity: String
    var website: String
}

external interface PlaceReview {
    var aspects: Array<PlaceAspectRating>
    var author_name: String
    var author_url: String
    var language: String
    var text: String
}

external interface PlaceSearchPagination {
    fun nextPage()
    var hasNextPage: Boolean
}

external interface PlaceSearchRequest {
    var bounds: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var keyword: String? get() = definedExternally; set(value) = definedExternally
    var location: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLng | com.github.onotoliy.opposite.treasure.maps.LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var maxPriceLevel: Number? get() = definedExternally; set(value) = definedExternally
    var minPriceLevel: Number? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var openNow: Boolean? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var rankBy: RankBy? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}

open external class PlacesService {
    constructor(attrContainer: com.github.onotoliy.opposite.treasure.maps.Map)
    constructor(attrContainer: HTMLDivElement)

    open fun findPlaceFromPhoneNumber(request: FindPlaceFromPhoneNumberRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun findPlaceFromQuery(request: FindPlaceFromQueryRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun getDetails(request: PlaceDetailsRequest, callback: (result: PlaceResult, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun nearbySearch(request: PlaceSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus, pagination: PlaceSearchPagination) -> Unit): Unit = definedExternally
    open fun radarSearch(request: RadarSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus) -> Unit): Unit = definedExternally
    open fun textSearch(request: TextSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus, pagination: PlaceSearchPagination) -> Unit): Unit = definedExternally
}

external enum class PlacesServiceStatus {
    ERROR,
    INVALID_REQUEST,
    OK,
    OVER_QUERY_LIMIT,
    NOT_FOUND,
    REQUEST_DENIED,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}

external interface QueryAutocompletePrediction {
    var description: String
    var matched_substrings: Array<PredictionSubstring>
    var place_id: String
    var terms: Array<PredictionTerm>
}

external interface QueryAutocompletionRequest {
    var bounds: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var input: String? get() = definedExternally; set(value) = definedExternally
    var location: com.github.onotoliy.opposite.treasure.maps.LatLng? get() = definedExternally; set(value) = definedExternally
    var offset: Number? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
}

external interface RadarSearchRequest {
    var bounds: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var keyword: String? get() = definedExternally; set(value) = definedExternally
    var location: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLng | com.github.onotoliy.opposite.treasure.maps.LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}

external enum class RankBy {
    DISTANCE,
    PROMINENCE
}

open external class SearchBox(inputField: HTMLInputElement, opts: SearchBoxOptions? = definedExternally /* null */) : com.github.onotoliy.opposite.treasure.maps.MVCObject {
    open fun getBounds(): com.github.onotoliy.opposite.treasure.maps.LatLngBounds = definedExternally
    open fun getPlaces(): Array<PlaceResult> = definedExternally
    open fun setBounds(bounds: com.github.onotoliy.opposite.treasure.maps.LatLngBounds): Unit = definedExternally
    open fun setBounds(bounds: com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral): Unit = definedExternally
}

external interface SearchBoxOptions {
    var bounds: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral */
}

external interface TextSearchRequest {
    var bounds: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral */ get() = definedExternally; set(value) = definedExternally
    var location: dynamic /* com.github.onotoliy.opposite.treasure.maps.LatLng | com.github.onotoliy.opposite.treasure.maps.LatLngLiteral */ get() = definedExternally; set(value) = definedExternally
    var query: String
    var radius: Number? get() = definedExternally; set(value) = definedExternally
    var types: Array<String>? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
}

external interface FindPlaceFromQueryRequest {
    var fields: Array<String>
    var locationBias: dynamic /* String | com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral | com.github.onotoliy.opposite.treasure.maps.LatLng | com.github.onotoliy.opposite.treasure.maps.LatLngLiteral | com.github.onotoliy.opposite.treasure.maps.Circle | com.github.onotoliy.opposite.treasure.maps.CircleLiteral */ get() = definedExternally; set(value) = definedExternally
    var query: String
}

external interface FindPlaceFromPhoneNumberRequest {
    var fields: Array<String>
    var locationBias: dynamic /* String | com.github.onotoliy.opposite.treasure.maps.LatLngBounds | com.github.onotoliy.opposite.treasure.maps.LatLngBoundsLiteral | com.github.onotoliy.opposite.treasure.maps.LatLng | com.github.onotoliy.opposite.treasure.maps.LatLngLiteral | com.github.onotoliy.opposite.treasure.maps.Circle | com.github.onotoliy.opposite.treasure.maps.CircleLiteral */ get() = definedExternally; set(value) = definedExternally
    var query: String
}
