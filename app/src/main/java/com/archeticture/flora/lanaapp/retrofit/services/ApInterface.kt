package com.archeticture.flora.lanaapp.retrofit.services

import com.archeticture.flora.lanaapp.retrofit.models.MyCountry
import retrofit2.Call
import retrofit2.http.GET

interface ApInterface {

    @GET("countries")
     fun getAffectedCountryList():Call<ArrayList<MyCountry>>
}