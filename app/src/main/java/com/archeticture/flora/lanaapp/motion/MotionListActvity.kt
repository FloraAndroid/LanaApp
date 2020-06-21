package com.archeticture.flora.lanaapp.motion

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.databinding.MotionListActivityBinding
import com.archeticture.flora.lanaapp.motion.viewmodel.MotionViewModel


class MotionListActvity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.motion_list_activity)
        val motionListActivityBinding:MotionListActivityBinding=
            DataBindingUtil.setContentView(this, R.layout.motion_list_activity);
        val motionViewModel:MotionViewModel=ViewModelProvider(this).get(MotionViewModel::class.java)
        motionViewModel.getMotionData(this)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val motionLayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=motionLayoutManager
        val motionAdapter=MotionAdapter(null)
        recyclerView.adapter=motionAdapter
        motionViewModel.motionDataLive.observe(this, Observer {
            motionListActivityBinding.motionData=it
            motionAdapter.list=it.list
            motionAdapter.notifyDataSetChanged()

        })

    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}
