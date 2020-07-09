package com.archeticture.flora.lanaapp.motion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.databinding.MotionListActivityBinding
import com.archeticture.flora.lanaapp.motion.model.MotionItem
import com.archeticture.flora.lanaapp.motion.model.UserInfo
import com.archeticture.flora.lanaapp.motion.viewmodel.MotionViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MotionListActvity : AppCompatActivity(),MotionAdapter.MotionItemListener{

     var motionViewModel:MotionViewModel?=null
     var motionAdapter:MotionAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val motionListActivityBinding:MotionListActivityBinding=
            DataBindingUtil.setContentView(this, R.layout.motion_list_activity);
        motionListActivityBinding.imageView.setOnClickListener {
            startActivity(Intent(this, TabbedActivity::class.java))
        }
        val motionViewModel:MotionViewModel=ViewModelProvider(this).get(MotionViewModel::class.java)
        motionViewModel.getMotionData(this)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val motionLayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=motionLayoutManager
         motionAdapter=MotionAdapter(null,this)
        recyclerView.adapter=motionAdapter
        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)

        motionAdapter?.notifyDataSetChanged()
        motionViewModel.motionDataLive.observe(this, Observer {
            motionListActivityBinding.motionData=it
            motionAdapter?.list=it.list
            motionAdapter?.notifyDataSetChanged()
            Log.d("observe","observe items")
        })
        val addBtn=findViewById<FloatingActionButton>(R.id.add_btn_motion)
        addBtn.setOnClickListener {
            //todo add dialog to insert item
            motionViewModel?.insertItem(MotionItem("45","nameI","dateII"),0)
           var userInfo=UserInfo("userPing","0542316580","04/09/2015")
           userInfo.createUser("userPing","0542316580")
            motionAdapter?.notifyItemInserted(0)
        }
    }

    override fun onRemoveItem(position: Int, motionItem: MotionItem?) {
        motionViewModel?.removeItem(motionItem,position)
    }
    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }




}
