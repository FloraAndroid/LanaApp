package com.archeticture.flora.lanaapp.retrofit.models
import com.google.gson.annotations.SerializedName

data class MyCountry(
    val active: Int?,
    val cases: Int?,
    val country: String?,
    val countryInfo: CountryInfo?,
    val critical: Int?,
    val deaths: Int?,
    val recovered: Int?,
    val todayCases: Int?,
    val todayDeaths: Int?,
    val todayRecovered: Int?,
    val updated: Long?
) {
    data class CountryInfo(
        @SerializedName("_id")
        val _id: Int?,
        val flag: String?,
        val iso2: String?,
        val iso3: String?,
        val lat: Double?,
        val long: Double?
    )
}