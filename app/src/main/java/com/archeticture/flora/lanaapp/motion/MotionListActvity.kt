package com.archeticture.flora.lanaapp.motion

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.motion.model.MotionItem

class MotionListActvity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_list_activity)
        var imageViewHeader=findViewById<ImageView>(R.id.imageView)
        var recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        var motionAdapter=MotionAdapter(list = getData())
        var motionLayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=motionLayoutManager
        recyclerView.adapter=motionAdapter
    }
    fun getData():ArrayList<MotionItem>{
        var list=ArrayList<MotionItem>()
        for (i in 0..88){
            list.add(
                MotionItem(
                    "name $i",
                    "date $i"
                )
            )
        }
        return list
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}
