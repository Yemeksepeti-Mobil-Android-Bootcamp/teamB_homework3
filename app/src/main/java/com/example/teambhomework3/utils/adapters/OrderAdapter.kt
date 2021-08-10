package com.example.teambhomework3.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teambhomework3.R
import com.example.teambhomework3.entity.Order

class OrderAdapter(private val orderList: ArrayList<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderRestaurantName: TextView =
            itemView.findViewById(R.id.profilePreviousOrderRestaurantName)
        val orderFoodName: TextView = itemView.findViewById(R.id.profilePreviousOrderName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order: Order = orderList[position]

        holder.orderRestaurantName.text = order.orderRestaurantName
        holder.orderFoodName.text = order.orderFoodName
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}