package com.archeticture.flora.lanaapp.motion.model

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter




class MotionItem(val id:String,var name:String?,var date:String?,var img:Bitmap?=null) {

    companion object {
    @BindingAdapter("bind:imageBitmap")
    fun loadImage(iv: ImageView, bitmap: Bitmap?) {
        iv.setImageBitmap(bitmap)
    }
}
}