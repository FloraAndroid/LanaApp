package com.archeticture.flora.lanaapp.motion

import android.content.Context
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.os.Handler
import android.util.AttributeSet
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
import com.archeticture.flora.lanaapp.motion.viewmodel.MotionViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MotionListActvity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val motionListActivityBinding:MotionListActivityBinding=
            DataBindingUtil.setContentView(this, R.layout.motion_list_activity);
        val motionViewModel:MotionViewModel=ViewModelProvider(this).get(MotionViewModel::class.java)
        motionViewModel.getMotionData(this)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val motionLayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=motionLayoutManager
        val motionAdapter=MotionAdapter(null)
        recyclerView.adapter=motionAdapter
        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)

        motionAdapter.notifyDataSetChanged()
        motionViewModel.motionDataLive.observe(this, Observer {
            motionListActivityBinding.motionData=it
            motionAdapter.list=it.list
            motionAdapter.notifyDataSetChanged()

        })
        val addBtn=findViewById<FloatingActionButton>(R.id.add_btn_motion)
        addBtn.setOnClickListener {
            //todo add dialog to insert item
            motionViewModel.insertItem(MotionItem("45","nameI","dateII"))
            motionAdapter?.notifyItemInserted(6)

        }

    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}
