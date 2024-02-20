package com.example.multipleviewrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.multipleviewrecyclerview.databinding.FirstlayoutBinding

class FirstViewHolder(private val binding : FirstlayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dataModel: DataModel){

        binding.title.text = dataModel.title
        binding.description.text = dataModel.description

    }
}