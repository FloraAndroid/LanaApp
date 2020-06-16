package com.archeticture.flora.lanaapp.motion

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.motion.model.MotionItem
import com.archeticture.flora.lanaapp.motion.viewmodel.MotionViewModel


class MotionListActvity : AppCompatActivity() {


    private var imageViewHeader: ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_list_activity)

        var viewmodel:MotionViewModel= ViewModelProviders.of(this).get(MotionViewModel::class.java)

        imageViewHeader=findViewById<ImageView>(R.id.imageView)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)

        val motionLayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=motionLayoutManager

        val motionAdapter=MotionAdapter(list = getData())
        recyclerView.adapter=motionAdapter
    }
    fun getData():ArrayList<MotionItem>{
       val headerImg= BitmapFactory.decodeResource(resources,R.drawable.general_nails);
       imageViewHeader?.setImageBitmap(headerImg)
        val list=ArrayList<MotionItem>()
        for (i in 0..88){
            list.add(
                MotionItem("$i",
                    "name $i",
                    "date $i")
            )
        }
        return list
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}
