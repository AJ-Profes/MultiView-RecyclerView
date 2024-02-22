package com.example.multipleviewrecyclerview

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.multipleviewrecyclerview.databinding.FirstlayoutBinding


class FirstViewHolder(private val binding : FirstlayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dataModel: DataModel){

        val context: Context = binding.root.context

        Glide.with(context)
            .load(dataModel.imgUrl)
            .apply(
                RequestOptions()
            )
            .into(binding.image)

        binding.title.text = dataModel.title
        binding.description.text = dataModel.description

    }
}