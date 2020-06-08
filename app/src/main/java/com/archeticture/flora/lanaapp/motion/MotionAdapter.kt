package com.archeticture.flora.lanaapp.motion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.motion.model.MotionItem

class MotionAdapter(var list:ArrayList<MotionItem>):RecyclerView.Adapter<MotionAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

            val textName=itemView.findViewById<TextView>(R.id.txtMotionTitle)
            val textDate:TextView=itemView.findViewById<TextView>(R.id.txtMotionDate)


        fun bind(motionItem: MotionItem)= with(itemView){

            textName.text=motionItem.name
            textDate.text=motionItem.date

        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.motion_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
       return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }
}