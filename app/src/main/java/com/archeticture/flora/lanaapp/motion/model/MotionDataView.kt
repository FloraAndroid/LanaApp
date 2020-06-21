package com.archeticture.flora.lanaapp.motion.model

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter

class MotionDataView(var headerItem: HeaderItem,var list:ArrayList<MotionItem>) {
    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageBitmap")
        fun loadImage(iv: ImageView, bitmap: Bitmap?) {
            iv.setImageBitmap(bitmap)
        }
    }
}