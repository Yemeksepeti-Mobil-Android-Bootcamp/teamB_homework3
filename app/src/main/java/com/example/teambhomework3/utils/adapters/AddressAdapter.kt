package com.example.teambhomework3.utils.adapters

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teambhomework3.R
import com.example.teambhomework3.entity.Adress
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddressAdapter(private val adressList: ArrayList<Adress>, private val mContext: Context)
    : RecyclerView.Adapter<AddressAdapter.MyViewHolder>() {

    private lateinit var db: FirebaseFirestore

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val adressName: TextView = itemView.findViewById(R.id.profileAdressName)
        val adressCity: TextView = itemView.findViewById(R.id.profileCity)
        val adress: TextView = itemView.findViewById(R.id.profileAdress)
        val adressNumber: TextView = itemView.findViewById(R.id.profileNumber)
        val adressContainer: CardView = itemView.findViewById(R.id.profileAdressContainer)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
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

        holder.deleteButton.setOnClickListener {
            db = Firebase.firestore

            db.collection("users").document("7TqNLIAQzjJVWLRAsAmC")
                .collection("adress").document(adress.id)
                .delete()
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!")
                    adressList.removeAt(position)
                notifyDataSetChanged()
                }
                .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }

            Toast.makeText(mContext,"Adres başarıyla silindi", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return adressList.size
    }
}