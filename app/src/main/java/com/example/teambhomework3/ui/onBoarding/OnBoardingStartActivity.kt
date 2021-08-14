package com.example.teambhomework3.ui.onBoarding

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.teambhomework3.ui.activity.MainActivity
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.ActivityOnBoardingStartBinding
import com.example.teambhomework3.data.entity.onBoarding.OnBoardingData
import com.example.teambhomework3.ui.activity.AuthActivity
import com.example.teambhomework3.utils.Animato
import com.example.teambhomework3.utils.ZoomOutPageTransformer
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class OnBoardingStartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingStartBinding
    private lateinit var viewPager2: ViewPager2
    var sharedPreferences: SharedPreferences? = null

    private var itemList=ArrayList<OnBoardingData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if(restorePrefData()) {
            val intent = Intent(applicationContext, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_on_boarding_start)

        binding= ActivityOnBoardingStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        initViewPager()

        //skip butonuna basılınca GettinStarting activity'e giden bir listener
        binding.txtSkip.setOnClickListener {
            finish()
            val intent =
                Intent(applicationContext, AuthActivity::class.java)
            startActivity(intent)
            Animato.animateDiagonal(this)
        }
        binding.txtNext.setOnClickListener {
            if (currentGetItem() > viewPager2.childCount) {

                val intent = Intent(applicationContext, AuthActivity::class.java)
                startActivity(intent)
                finish()

                Animato.animateDiagonal(this)
            } else {
                viewPager2.setCurrentItem(currentGetItem() + 1, true)
            }
        }
    }
    fun onClick(v:View){
        when(v){
            binding.imgPrevious->{
                val currentItemPosition=binding.viewPager.currentItem
                if (currentItemPosition==0) return
                binding.viewPager.setCurrentItem(currentItemPosition-1,true)
            }
            binding.txtNext->{
                val currentItemPosition=binding.viewPager.currentItem
                if (currentItemPosition==itemList.size-1) {
                    Toast.makeText(this,"Start Next Process", Toast.LENGTH_SHORT).show()
                    return
                }
                binding.viewPager.setCurrentItem(currentItemPosition+1,true)
            }
            binding.txtSkip->{
                Toast.makeText(this,"Start Next Process", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initViews() {
        viewPager2 = findViewById(R.id.viewPager)
    }
    private fun initViewPager() {
        itemList=getItems()
        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.worm_dot)
        val adapter = ViewPagerAdapter(this,itemList)
        viewPager2.adapter = adapter


        //pagerda dahil olan fragment geçişlerine eklenen animasyon yönetimi
        val zoomOutPageTransformer = ZoomOutPageTransformer()
        viewPager2.setPageTransformer { page, position ->
            zoomOutPageTransformer.transformPage(page, position)
        }

        savePrefData()

        //indicator yönetimi
        wormDotsIndicator.setViewPager2(viewPager2)
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback)
    }
    private fun currentGetItem():Int{
        return viewPager2.currentItem
    }

    private var pageChangeCallback:ViewPager2.OnPageChangeCallback= object: ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.imgPrevious.visibility= View.INVISIBLE.takeIf { position==0 }?: View.VISIBLE

            if (position==itemList.size-1){
                binding.txtNext.text="Start"
                binding.txtSkip.visibility= View.GONE
            }
            else{
                binding.txtNext.text="Next"
                binding.txtSkip.visibility= View.VISIBLE
            }
        }
    }

    private fun getItems():ArrayList<OnBoardingData>{
        val items=ArrayList<OnBoardingData>()
        items.add(
            OnBoardingData(
                "Order Your Food",
                "Now you can order food any time right from mobile.",
                R.drawable.ic_orderfood
            )
        )
        items.add(
            OnBoardingData(
                "Cooking Safe Food",
                "We're maintain safety and we keep clean while making food",
                R.drawable.ic_safecooking
            )
        )
        items.add(
            OnBoardingData(
                "Quick delivery",
                "Orders your favourite meals will be immediately deliver",
                R.drawable.ic_deliveryfood
            )
        )
        return items
    }


    private fun restorePrefData() : Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)

    }
    private fun savePrefData() {
        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }
}