package com.archeticture.flora.lanaapp.retrofit.models

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

data class TopItem(
    var name: String,
    var description: String,
    var photo: Bitmap?,
    var uriPhoto: String?
) {

    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageBitmap")
        fun setImage(iv: ImageView, bitmap: Bitmap?) {
            bitmap?.let {
                iv.setImageBitmap(bitmap)
            }
        }

        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun load(iv: ImageView, url: String?) {
            url?.let {
                iv.load(url)
            }
        }
    }
}
