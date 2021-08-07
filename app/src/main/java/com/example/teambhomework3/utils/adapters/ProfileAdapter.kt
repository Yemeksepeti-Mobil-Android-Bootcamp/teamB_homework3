package com.example.teambhomework3.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teambhomework3.R
import com.example.teambhomework3.entity.Adress

class ProfileAdapter(private val adressList: ArrayList<Adress>, private val mContext: Context)
    : RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val adressName: TextView = itemView.findViewById(R.id.profileAdressName)
        val adressCity: TextView = itemView.findViewById(R.id.profileCity)
        val adress: TextView = itemView.findViewById(R.id.profileAdress)
        val adressNumber: TextView = itemView.findViewById(R.id.profileNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adress, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val adress: Adress = adressList[position]

        holder.adressName.text = adress.adressName
        holder.adressCity.text = adress.addressCity
        holder.adress.text = adress.address
        holder.adressNumber.text = adress.adressNumber
    }

    override fun getItemCount(): Int {
        return adressList.size
    }

}