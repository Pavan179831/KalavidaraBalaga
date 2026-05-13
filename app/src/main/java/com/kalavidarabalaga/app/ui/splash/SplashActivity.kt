package com.kalavidarabalaga.app.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.databinding.ActivitySplashBinding
import com.kalavidarabalaga.app.ui.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.ui.auth.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Animate the logo card — scale + fade in
        val scaleAnim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        scaleAnim.duration = 800
        binding.cardLogo.startAnimation(scaleAnim)

        val prefs = UserPreferences(this)

        // Navigate to MainActivity after 2.5 seconds
        lifecycleScope.launch {
            delay(2500)
            // Route: logged in → Main, else → Login
            val dest = if (prefs.isLoggedIn) MainActivity::class.java
                       else LoginActivity::class.java
            startActivity(Intent(this@SplashActivity, dest))
            @Suppress("DEPRECATION")
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
