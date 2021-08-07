package com.example.teambhomework3

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.teambhomework3.databinding.ActivityMainBinding
import com.example.teambhomework3.fragments.BottomSheetFragment
import com.example.teambhomework3.utils.SharedPreferencesModule
import com.example.teambhomework3.utils.ThemeUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferencesModule.initSharedPreferences(baseContext)

        ThemeUtils.onActivityCreateSetTheme(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController=findNavController(R.id.navHostFragment)
       /* val appBarConfiguration= AppBarConfiguration(setOf(
            R.id.restaurantsFragment,
            R.id.foodsFragment,
            R.id.profileFragment,
            R.id.settingsFragment
        ))*/

        binding.bottomNavigationView.setupWithNavController(navController)
        //setupActionBarWithNavController(navController,appBarConfiguration)

    }
    /*override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()|| super.onSupportNavigateUp()
    }*/

}