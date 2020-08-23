package com.archeticture.flora.lanaapp.retrofit.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.archeticture.flora.lanaapp.databinding.ItemLayoutBinding
import com.archeticture.flora.lanaapp.retrofit.models.TopItem

class AdapterTopItems(var items:List<TopItem>) :
    RecyclerView.Adapter<AdapterTopItems.ViewHolder>() {


   inner class ViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){

       fun bind(item:TopItem)= with(itemView){
           binding.topItem=item
           binding.executePendingBindings()
       }

   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }
}