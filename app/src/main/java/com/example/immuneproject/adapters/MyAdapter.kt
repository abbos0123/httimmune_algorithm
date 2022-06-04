package com.example.immuneproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.immuneproject.R
import com.example.immuneproject.databinding.Item2Binding
import com.example.immuneproject.databinding.ItemBinding

class MyAdapter(var list: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(string: String, position: Int) {

            if (position == 0)
                binding.image.setImageResource(R.drawable.pic_1_1)

            if (position == 1)
                binding.image.setImageResource(R.drawable.pic_1_0)

            if (position == 2)
                binding.image.setImageResource(R.drawable.pic_2_0)

            if (position == 3)
                binding.image.setImageResource(R.drawable.pic_3_0)

            if (position == 4)
                binding.image.setImageResource(R.drawable.pic_4_0)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}