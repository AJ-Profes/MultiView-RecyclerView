package com.example.multipleviewrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.multipleviewrecyclerview.databinding.FirstlayoutBinding
import com.example.multipleviewrecyclerview.databinding.SecondlayoutBinding

class SecondViewHolder (private val binding : SecondlayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dataModel: DataModel){

        binding.title.text = dataModel.title
        binding.description.text = dataModel.description

    }
}