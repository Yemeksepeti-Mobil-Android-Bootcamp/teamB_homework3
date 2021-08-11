package com.example.teambhomework3.fragments.food

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentFoodDetailBinding

class FoodDetailFragment : Fragment() {


    private val args by navArgs<FoodDetailFragmentArgs>()

    private var _binding: FragmentFoodDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDetailBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity?)!!.supportActionBar?.title = ""
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.share_food_joke_menu){
            val shareIntent= Intent().apply {
                this.action= Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT,"Peynir, sosis, domates, salam, biber, zeytin, mısır gibi ana malzemeleri dışında birçok değişik malzemenin konulduğu pizzalar da bulunmaktadır.")
                this.type="text/plain"
            }
            startActivity(shareIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.food_share_menu,menu)
    }

}