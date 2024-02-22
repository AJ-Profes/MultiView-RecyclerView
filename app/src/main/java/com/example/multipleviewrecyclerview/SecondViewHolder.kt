package com.example.multipleviewrecyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.multipleviewrecyclerview.databinding.FirstlayoutBinding
import com.example.multipleviewrecyclerview.databinding.SecondlayoutBinding

class SecondViewHolder (private val binding : SecondlayoutBinding) : RecyclerView.ViewHolder(binding.root) {

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