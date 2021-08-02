package com.sarikaya.project3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

//class RestaurantAdapter(private val titleList: List<Titles>) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    //private val titles : List<Titles> = titleList
//    var images = intArrayOf(R.drawable.burger,R.drawable.pizza1,R.drawable.pizza2,R.drawable.cat_1,R.drawable.burger,R.drawable.burger,R.drawable.burger,R.drawable.burger,
//        R.drawable.burger,R.drawable.burger,R.drawable.burger,R.drawable.burger)


//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): RestaurantAdapter.ViewHolder {
//        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardviewlayout,parent,false))
//    }
//
//    override fun onBindViewHolder(holder: RestaurantAdapter.ViewHolder, position: Int) {
//        //val title: Titles = titleList[position]
////        holder.shopTitle.text = title.title
////        holder.shopImage.setImageResource(images[position])
////        holder.itemView.setOnClickListener {
////            val intent = Intent(holder.itemView.context,MainActivity::class.java)
////            intent.putExtra("true",true)
////            holder.itemView.context.startActivity(intent)
////        }
//    }
//
//    override fun getItemCount(): Int {
//        return titleList.size
//    }
//
//    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        var shopImage : ImageView
//        var shopTitle : TextView
//
//        init {
//            shopImage = itemView.findViewById(R.id.shopImage)
//            shopTitle = itemView.findViewById(R.id.shopTitle)
//        }
//    }
//}