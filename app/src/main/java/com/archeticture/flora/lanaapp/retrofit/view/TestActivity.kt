package com.archeticture.flora.lanaapp.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.retrofit.viewmodels.ViewModelCountry

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val viewmodelCountry = ViewModelProvider(this).get(ViewModelCountry::class.java)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frameLayoutTop,
                    TopFragment.newInstance(), "dogList")
                .commit()
        }


    }
}
