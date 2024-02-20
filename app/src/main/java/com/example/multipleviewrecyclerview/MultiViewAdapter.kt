package com.example.multipleviewrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleviewrecyclerview.databinding.FirstlayoutBinding
import com.example.multipleviewrecyclerview.databinding.SecondlayoutBinding
import java.lang.IllegalArgumentException

class MultiViewAdapter(private val list: ArrayList<DataModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClick : ((DataModel) -> Unit)?= null
    companion object{

        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){

            FIRST_VIEW -> FirstViewHolder(FirstlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            SECOND_VIEW -> SecondViewHolder(SecondlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            else -> throw IllegalArgumentException("Invalid Item Type")

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position])
        }

        return when(list[position].theViewType){

            FIRST_VIEW -> (holder as FirstViewHolder).bind(list[position])
            SECOND_VIEW -> (holder as SecondViewHolder).bind(list[position])

            else -> throw IllegalArgumentException("Invalid Item Type")

        }


    }

    override fun getItemViewType(position: Int): Int {

        return list[position].theViewType

    }
}