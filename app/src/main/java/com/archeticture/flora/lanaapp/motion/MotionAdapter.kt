package com.archeticture.flora.lanaapp.motion
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.archeticture.flora.lanaapp.databinding.MotionItemLayoutBinding
import com.archeticture.flora.lanaapp.motion.model.MotionItem

class MotionAdapter(var list:ArrayList<MotionItem>?):
    RecyclerView.Adapter<MotionAdapter.ViewHolder>() {
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

    }
//    private fun insert(): (View) -> Unit = {
//        layoutPosition.also { currentPosition ->
//            list?.add(currentPosition, uniqueString(string))
//            notifyDataSetChanged()
//        }
//    }
//
//    private fun remove(): (View) -> Unit = {
//        layoutPosition.also { currentPosition ->
//            list?.removeAt(currentPosition)
//            notifyDataSetChanged()
//        }
//    }
}