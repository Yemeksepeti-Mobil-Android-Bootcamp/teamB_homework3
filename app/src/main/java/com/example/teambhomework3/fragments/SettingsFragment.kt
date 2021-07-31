package com.example.teambhomework3.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentSettingsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private var settingItemsList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        val settingsAboutApplicationItemView: CardView =
            _binding!!.root.findViewById(R.id.aboutApplication)
        val settingsAddressesItemView: CardView =
            _binding!!.root.findViewById(R.id.myAddresses)
        val settingsInfoItemView: CardView = _binding!!.root.findViewById(R.id.myInfo)
        val settingsPreviousOrdersItemView: CardView =
            _binding!!.root.findViewById(R.id.myPreviousOrders)
        val settingsProfileItemView: CardView =
            _binding!!.root.findViewById(R.id.myProfile)

        val eyeIcon: ImageView = _binding!!.root.findViewById(R.id.eyeIcon)
        val switchTheme: SwitchMaterial = _binding!!.root.findViewById(R.id.switchTheme)

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                eyeIcon.setImageResource(R.drawable.ic_eye_for_dark)
                switchTheme.setText(R.string.dark)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                eyeIcon.setImageResource(R.drawable.ic_eye_for_light)
                switchTheme.setText(R.string.light)
            }
        }

        val cardViews: ArrayList<CardView> = arrayListOf(
            settingsAboutApplicationItemView,
            settingsAddressesItemView,
            settingsInfoItemView,
            settingsPreviousOrdersItemView,
            settingsProfileItemView
        )

        initSettingsItems()

        initListeners(cardViews, _binding!!.root.context)

        return binding.root
    }

    private fun initSettingsItems() {
        settingItemsList.add(getString(R.string.about_application))
        settingItemsList.add(getString(R.string.my_addresses))
        settingItemsList.add(getString(R.string.my_info))
        settingItemsList.add(getString(R.string.my_previous_orders))
        settingItemsList.add(getString(R.string.my_profile))
    }

    private fun initListeners(cardViews: ArrayList<CardView>, context: Context) {
        for (item in settingItemsList) {

            if (item == getString(R.string.about_application)) {
                cardViews[settingItemsList.indexOf(item)].setOnClickListener {
                    showModal(context)
                }
            } else {
                cardViews[settingItemsList.indexOf(item)].setOnClickListener {
                    Toast.makeText(
                        it.context,
                        "Navigate to $item",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun showModal(context: Context) {
        MaterialAlertDialogBuilder(
            context,
            R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog
        )
            .setTitle(resources.getString(R.string.about_application))
            .setMessage(resources.getString(R.string.info_message))
            .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->
                dialog.cancel()
            }
            .setOnCancelListener {
                Toast.makeText(context, R.string.thanks, Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}