package com.example.multiviewtypelistadapter.base

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.multiviewtypelistadapter.R

@BindingAdapter("srcFromUrl")
fun ImageView.setSrcFromUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.img_home_dummy)
        .into(this)
}

@BindingAdapter("roundedSrcFromUrl")
fun ImageView.setRoundedSrcFromUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .transform(RoundedCorners(20))
        .placeholder(R.drawable.img_home_dummy)
        .into(this)
}

@BindingAdapter("setPrefixByText")
fun TextView.setPrefixByText(text: String) {
    val stringAddPrefix = "By $text"
    this.text = stringAddPrefix
}
