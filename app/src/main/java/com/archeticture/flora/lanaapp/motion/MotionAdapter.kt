package com.archeticture.flora.lanaapp.motion
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.archeticture.flora.lanaapp.databinding.MotionItemLayoutBinding
import com.archeticture.flora.lanaapp.motion.model.MotionItem

class MotionAdapter(var list:ArrayList<MotionItem>?,val motionItemListener: MotionItemListener?):
    RecyclerView.Adapter<MotionAdapter.ViewHolder>() {
    val TAG:String=javaClass.name
    interface MotionItemListener{
        fun onRemoveItem(position: Int,motionItem: MotionItem?)
    }
    inner class ViewHolder(val motionItemLayoutBinding:
                           MotionItemLayoutBinding):
        RecyclerView.ViewHolder(motionItemLayoutBinding.root){

        fun bind(motionItem: MotionItem?)= with(itemView){
            motionItemLayoutBinding.motionItem=motionItem
            motionItemLayoutBinding.executePendingBindings()
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = MotionItemLayoutBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list?.size?:0

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list?.get(position))
       //holder.motionItemLayoutBinding.imgMotionItem.load("")
        holder.motionItemLayoutBinding.removeBtnMotion.setOnClickListener {
            Log.d(TAG,"position $position")
            Log.d(TAG,"adapter position ${holder.adapterPosition}")
            Log.d(TAG,"list Size  ${list?.size}}")
            Log.d(TAG,"***********")
            list?.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
          //  notifyItemRangeRemoved(holder.adapterPosition,(list?.size)?:0)
            motionItemListener?.onRemoveItem(position,list?.get(position))
        }

    }

}