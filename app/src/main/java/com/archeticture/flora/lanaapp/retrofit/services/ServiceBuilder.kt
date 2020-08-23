package com.archeticture.flora.lanaapp.retrofit.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private const val URLBase="https://disease.sh/v2/"
    private val okHttp=OkHttpClient.Builder()
    private val builder=Retrofit.Builder().baseUrl(URLBase).
    addConverterFactory(GsonConverterFactory.create()).client(okHttp.build())

    private val retrofit:Retrofit= builder.build()




   public fun <T>buildService (serviceType:Class<T>):T{
       return  retrofit.create(serviceType)
    }
}