package com.example.teambhomework3.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.teambhomework3.R
import com.example.teambhomework3.databinding.FragmentSettingsBinding
import com.example.teambhomework3.utils.SharedPreferencesModule
import com.example.teambhomework3.utils.ThemeUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        val settingsAboutApplicationButton: AppCompatButton =
            _binding!!.root.findViewById(R.id.aboutApplication)
        val settingsAddressesButton: AppCompatButton =
            _binding!!.root.findViewById(R.id.myAddresses)
        val settingsInfoButton: AppCompatButton = _binding!!.root.findViewById(R.id.myInfo)
        val settingsPreviousOrdersButton: AppCompatButton =
            _binding!!.root.findViewById(R.id.myPreviousOrders)
        val settingsProfileButton: AppCompatButton =
            _binding!!.root.findViewById(R.id.myProfile)

        val eyeIcon: ImageView = _binding!!.root.findViewById(R.id.eyeIcon)
        val switchTheme: SwitchMaterial = _binding!!.root.findViewById(R.id.switchTheme)

        isDark()

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                SharedPreferencesModule.saveString(SharedPreferencesModule.THEME, ThemeUtils.DARK)
                ThemeUtils.changeTheme(
                    _binding!!.root.context as AppCompatActivity,
                    ThemeUtils.DARK
                )
            } else {
                SharedPreferencesModule.saveString(SharedPreferencesModule.THEME, ThemeUtils.LIGHT)
                ThemeUtils.changeTheme(
                    _binding!!.root.context as AppCompatActivity,
                    ThemeUtils.LIGHT
                )
            }
        }

        val appCompatButtons: ArrayList<AppCompatButton> = arrayListOf(
            settingsAboutApplicationButton,
            settingsAddressesButton,
            settingsInfoButton,
            settingsPreviousOrdersButton,
            settingsProfileButton
        )

        initListeners(appCompatButtons, _binding!!.root.context)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        isDark()
    }

    override fun onStart() {
        super.onStart()

        isDark()
    }

    private fun initListeners(appCompatButtons: ArrayList<AppCompatButton>, context: Context) {
        for (button in appCompatButtons) {

            if (button.text == getString(R.string.about_application)) {
                button.setOnClickListener {
                    showModal(context)
                }
            } else {
                button.setOnClickListener {
                    Toast.makeText(
                        it.context,
                        "Navigate to ${button.text}",
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

    private fun isDark() {

        val eyeIcon: ImageView = _binding!!.root.findViewById(R.id.eyeIcon)
        val switchTheme: SwitchMaterial = _binding!!.root.findViewById(R.id.switchTheme)

        if (SharedPreferencesModule.getString(SharedPreferencesModule.THEME) == ThemeUtils.DARK) {
            switchTheme.isChecked = true
            eyeIcon.setImageResource(R.drawable.ic_eye_for_dark)
            switchTheme.setText(R.string.dark)
        } else {
            switchTheme.isChecked = false
            eyeIcon.setImageResource(R.drawable.ic_eye_for_light)
            switchTheme.setText(R.string.light)
        }
    }
}