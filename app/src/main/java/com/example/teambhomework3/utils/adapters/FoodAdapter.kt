package com.example.teambhomework3.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.teambhomework3.R
import com.example.teambhomework3.data.entity.Food
import com.example.teambhomework3.ui.fragments.food.FoodsFragmentDirections

class FoodAdapter(private val foodNamesList: List<Food>, private val mContext:Context): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val foodName: TextView = itemView.findViewById(R.id.itemFoodName)
        val foodImageView : ImageView = itemView.findViewById(R.id.itemFoodImageView)
        val foodPrice : TextView = itemView.findViewById(R.id.itemFoodPrice)
        //val foodDescription : TextView = itemView.findViewById(R.id.foodDescription_textView)
        val foodCardView: CardView = itemView.findViewById(R.id.itemFoodCardView)
        val circularProgressDrawable = CircularProgressDrawable(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food: Food = foodNamesList[position]

        holder.foodName.text = food.foodName
        holder.foodPrice.text = "${food.foodPrice}₺"
        //holder.foodDescription.text = food.foodDescription


        Glide
            .with(mContext)
            .load(food.foodImage)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(holder.circularProgressDrawable)
            .into(holder.foodImageView)

        holder.foodCardView.setOnClickListener {
            val direction = FoodsFragmentDirections.actionFoodsFragmentToFoodDetailFragment(
                Food(food.foodName,
                    food.foodImage,
                    food.foodPrice,
                    food.foodDescription)
            )
            it.findNavController().navigate(direction)
        }

    }


    override fun getItemCount(): Int {
        return foodNamesList.size
    }
}