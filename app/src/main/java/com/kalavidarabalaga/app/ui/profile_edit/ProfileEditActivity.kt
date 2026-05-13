package com.kalavidarabalaga.app.ui.profile_edit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.ActivityProfileEditBinding

class ProfileEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileEditBinding
    private lateinit var prefs: UserPreferences
    private var selectedPhotoUri: Uri? = null

    private val pickImage = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            selectedPhotoUri = it
            Glide.with(this).load(it).circleCrop().into(binding.ivProfilePhoto)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = UserPreferences(this)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Profile"

        loadCurrentProfile()

        // Photo tap → pick from gallery
        binding.ivProfilePhoto.setOnClickListener { pickImage.launch("image/*") }
        binding.tvChangePhoto.setOnClickListener   { pickImage.launch("image/*") }

        // Save button
        binding.btnSaveProfile.setOnClickListener { saveProfile() }
    }

    private fun loadCurrentProfile() {
        binding.etName.setText(prefs.userName)
        binding.etPhone.setText(prefs.userPhone)
        binding.etAddress.setText(prefs.userAddress)

        val photoUri = prefs.userPhotoUri
        if (photoUri.isNotBlank()) {
            Glide.with(this).load(photoUri).circleCrop().into(binding.ivProfilePhoto)
        }
    }

    private fun saveProfile() {
        val name    = binding.etName.text?.toString()?.trim() ?: ""
        val phone   = binding.etPhone.text?.toString()?.trim() ?: ""
        val address = binding.etAddress.text?.toString()?.trim() ?: ""

        if (name.isEmpty()) {
            binding.etName.error = "Name is required"
            return
        }

        prefs.userName    = name
        prefs.userPhone   = phone
        prefs.userAddress = address
        selectedPhotoUri?.let { prefs.userPhotoUri = it.toString() }

        Toast.makeText(this, "✅ Profile saved!", Toast.LENGTH_SHORT).show()
        finish()
        overridePendingTransition(0, R.anim.slide_out_right)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
