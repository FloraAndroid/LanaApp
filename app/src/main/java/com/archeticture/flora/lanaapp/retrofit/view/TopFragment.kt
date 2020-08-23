package com.archeticture.flora.lanaapp.retrofit.view

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.retrofit.viewmodels.ViewModelCountry



class TopFragment : Fragment() {
    var viewModelCountry:ViewModelCountry?=null

    var adapterTopItems:AdapterTopItems?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            viewModelCountry = ViewModelProvider(it).get(ViewModelCountry::class.java)


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.recycler_layout, container, false)

        val layoutManager = GridLayoutManager(context,3)
        var recyclerView=view.findViewById<RecyclerView>(R.id.recyclerView_horizontal)
        recyclerView.layoutManager = layoutManager
        viewModelCountry?.loadCountries()
        viewModelCountry?.topItemList?.observe(TopFragment@this, Observer {
            Toast.makeText(context,it.get(0).name.toString(),Toast.LENGTH_LONG).show()
            adapterTopItems=AdapterTopItems(it)
            adapterTopItems?.notifyDataSetChanged()
            recyclerView.adapter=adapterTopItems

        })




        return view;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TopFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
