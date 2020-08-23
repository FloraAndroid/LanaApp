package com.archeticture.flora.lanaapp.retrofit.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coil.Coil
import coil.api.get
import coil.api.load
import com.archeticture.flora.lanaapp.retrofit.models.MyCountry
import com.archeticture.flora.lanaapp.retrofit.models.TopItem
import com.archeticture.flora.lanaapp.retrofit.services.ApInterface
import com.archeticture.flora.lanaapp.retrofit.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCountry : ViewModel() {

    val TAG: String = javaClass.name
    var topItemList: MutableLiveData<ArrayList<TopItem>>? = null
    fun loadCountries() {
        topItemList = MutableLiveData()
        val destinationService = ServiceBuilder.buildService(ApInterface::class.java)
        val call = destinationService.getAffectedCountryList()
        call.enqueue(object : Callback<ArrayList<MyCountry>> {
            override fun onResponse(
                call: Call<ArrayList<MyCountry>>,
                response: Response<ArrayList<MyCountry>>
            ) {
                val countryList = response.body().takeIf { response.isSuccessful }?.let {
                    topItemList?.postValue(convertCountryToModel(it))

                }
                val error = response.errorBody().toString().takeUnless { response.isSuccessful }

                Log.d(TAG, error.toString())
            }

            override fun onFailure(call: Call<ArrayList<MyCountry>>, t: Throwable) {
                Log.d(TAG, t.message)
            }

        })
    }

    fun convertCountryToModel(myCountryList: ArrayList<MyCountry>): ArrayList<TopItem> {

        var topItemList = ArrayList<TopItem>()
        myCountryList.forEach {
            topItemList.add(
                TopItem(
                    it.country ?: "",
                    it.countryInfo?._id.toString() ?: "",
                    null, it.countryInfo?.flag
                )
            )
        }
        return topItemList
    }
}