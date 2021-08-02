package com.sarikaya.project3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class FoodAdapter(private val foodNames: List<FoodNames>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
//    private val titles : List<Titles> = titleList()
//    private var count = 0
//    var images = intArrayOf(R.drawable.burger,R.drawable.burger,R.drawable.burger,R.drawable.burger)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
//        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview_2,parent,false))
//    }
//
//    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
//        val title: FoodNames = foodNames[position]
//        holder.vector.setOnClickListener {
//            count+=1
//            holder.counter.text = count.toString()
//        }
//        holder.foodTitle.text = title.name
//        holder.foodImage.setImageResource(images[position])
//    }
//
//    override fun getItemCount(): Int {
//        return foodNames.size
//    }
//
//    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        var foodImage : ImageView
//        var foodTitle : TextView
//        var vector : View
//        var counter : TextView
//        init {
//            foodImage = itemView.findViewById(R.id.foodImage)
//            foodTitle = itemView.findViewById(R.id.foodTitle)
//            vector = itemView.findViewById(R.id.vector)
//            counter = itemView.findViewById(R.id.counter)
//        }
//    }
//}