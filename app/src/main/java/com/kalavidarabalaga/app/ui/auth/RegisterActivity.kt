package com.kalavidarabalaga.app.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.ActivityRegisterBinding
import com.kalavidarabalaga.app.ui.MainActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var prefs: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = UserPreferences(this)

        // Create account
        binding.btnRegister.setOnClickListener {
            val name     = binding.etName.text?.toString()?.trim() ?: ""
            val username = binding.etUsername.text?.toString()?.trim() ?: ""
            val password = binding.etPassword.text?.toString() ?: ""
            val phone    = binding.etPhone.text?.toString()?.trim() ?: ""

            val error = prefs.register(name, username, password, phone)
            if (error != null) {
                showError(error)
            } else {
                // Auto-login after registration
                prefs.login(username, password)
                showError(null)
                startActivity(
                    Intent(this, MainActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                )
                finish()
            }
        }

        // Back to login
        binding.btnBackToLogin.setOnClickListener { finish() }
    }

    private fun showError(msg: String?) {
        if (msg == null) {
            binding.tvError.visibility = View.GONE
        } else {
            binding.tvError.visibility = View.VISIBLE
            binding.tvError.text = "⚠️ $msg"
        }
    }
}
