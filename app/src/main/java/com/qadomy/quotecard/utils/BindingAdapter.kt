package com.qadomy.quotecard.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.qadomy.quotecard.model.Quote

@BindingAdapter("setRoundImage")
fun setRoundImage(imageView: ImageView, item: Quote) {
    item.let {
        val imageUri = it.image
        Glide.with(imageView.context)
            .load(imageUri)
            .into(imageView)
    }
}