package com.example.teambhomework3.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.teambhomework3.R
import com.example.teambhomework3.entity.Food

class FoodAdapter(private val foodNamesList: List<Food>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodImageView : ImageView = itemView.findViewById(R.id.foodImage)
        val foodPrice : TextView = itemView.findViewById(R.id.foodPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_2,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodName.text = foodNamesList[position].toString()
    }

    override fun getItemCount(): Int {
        return foodNamesList.size
    }
}