package com.example.basecleandaggerrx.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.pigllet.themovieapp.utils.IMAGE_URL_API

@BindingAdapter("loadAvatar")
fun loadAvatar(view: ImageView, url: String) {
    Glide.with(view.context).load(IMAGE_URL_API + url).into(view)
}
