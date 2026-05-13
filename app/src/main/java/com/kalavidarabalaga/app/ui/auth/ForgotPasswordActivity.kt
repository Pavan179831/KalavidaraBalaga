package com.kalavidarabalaga.app.ui.auth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var prefs: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = UserPreferences(this)

        binding.btnReset.setOnClickListener {
            val username    = binding.etUsername.text?.toString()?.trim() ?: ""
            val newPassword = binding.etNewPassword.text?.toString() ?: ""
            val confirm     = binding.etConfirmPassword.text?.toString() ?: ""

            if (newPassword != confirm) {
                showError("Passwords do not match")
                return@setOnClickListener
            }

            val error = prefs.resetPassword(username, newPassword)
            if (error != null) {
                showError(error)
            } else {
                showError(null)
                AlertDialog.Builder(this, R.style.KBAlertDialog)
                    .setTitle("✅ Password Reset!")
                    .setMessage("Your password for \"$username\" has been updated. Please login with your new password.")
                    .setPositiveButton("OK to Login") { _, _ -> finish() }
                    .setCancelable(false)
                    .show()
            }
        }

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
