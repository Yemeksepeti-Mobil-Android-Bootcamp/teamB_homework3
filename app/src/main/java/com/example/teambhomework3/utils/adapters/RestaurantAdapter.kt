package com.example.teambhomework3.utils.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.teambhomework3.R
import com.example.teambhomework3.entity.Restaurant
import com.example.teambhomework3.fragments.restaurant.RestaurantsFragmentDirections

class RestaurantAdapter(private val restaurantList: ArrayList<Restaurant>, private val mContext: Context)
    : RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val restaurantName: TextView = itemView.findViewById(R.id.itemRestaurantName)
        val restaurantImageView: ImageView = itemView.findViewById(R.id.itemRestaurantImageView)
        val circularProgressDrawable = CircularProgressDrawable(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val restaurant: Restaurant =restaurantList[position]
        var navController: NavController? = null
        holder.restaurantName.text = restaurant.restaurantName
        holder.circularProgressDrawable.strokeWidth = 5f
        holder.circularProgressDrawable.centerRadius = 30f
        holder.circularProgressDrawable.start()

        Glide
            .with(mContext)
            .load(restaurant.restaurantImage)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(holder.circularProgressDrawable)
            .into(holder.restaurantImageView)

        holder.itemView.setOnClickListener {
            val action = RestaurantsFragmentDirections.actionRestaurantsFragmentToFoodsFragment(restaurant.restaurantName)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }
}