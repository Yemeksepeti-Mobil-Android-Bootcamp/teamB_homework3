package com.example.teambhomework3.ui.fragments.food

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentFoodDetail2Binding


class FoodDetailFragment : Fragment() {
    private var _binding: FragmentFoodDetail2Binding? = null
    private val binding get() = _binding!!

    private val args by navArgs<FoodDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDetail2Binding.inflate(inflater, container, false)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.foodDetailToolbar)
        (activity as AppCompatActivity?)!!.supportActionBar?.title=""

        val view = binding.root

        initViews()
        binding.foodDetailToolbarBaslik.text=args.foodDetail.foodName
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.food_share_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId== R.id.food_share_menu){
            val shareIntent= Intent().apply {
                this.action= Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT,"Yemek Adı : ${args.foodDetail.foodName}")
                this.type="text/plain"
            }
            startActivity(shareIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initViews() {
        binding.foodDetailTitle.text =args.foodDetail.foodName

        Glide
            .with(requireContext())
            .load(args.foodDetail.foodImage)
            .centerCrop()
            .into(binding.foodDetailFoto)

        binding.textViewFiyat.text = "${args.foodDetail.foodPrice}₺"

        binding.textView7.text = args.foodDetail.foodDescription
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}