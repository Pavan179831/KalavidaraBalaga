package com.kalavidarabalaga.app.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.ActivityLoginBinding
import com.kalavidarabalaga.app.ui.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefs: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = UserPreferences(this)

        // If already logged in, skip straight to main
        if (prefs.isLoggedIn) {
            goToMain(); return
        }

        setupButtons()
    }

    private fun setupButtons() {
        // Login
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text?.toString()?.trim() ?: ""
            val password = binding.etPassword.text?.toString() ?: ""

            val error = prefs.login(username, password)
            if (error != null) {
                showError(error)
            } else {
                showError(null)
                goToMain()
            }
        }

        // Register → open RegisterActivity
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, 0)
        }

        // Forgot password → ForgotPasswordActivity
        binding.tvGuestLogin.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun showError(msg: String?) {
        if (msg == null) {
            binding.tvError.visibility = View.GONE
        } else {
            binding.tvError.visibility = View.VISIBLE
            binding.tvError.text = "⚠️ $msg"
        }
    }

    private fun goToMain() {
        startActivity(
            Intent(this, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        )
        finish()
    }
}
