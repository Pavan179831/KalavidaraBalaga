package com.kalavidarabalaga.app.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.ActivityMainBinding
import com.kalavidarabalaga.app.databinding.NavHeaderBinding
import com.kalavidarabalaga.app.ui.profile_edit.ProfileEditActivity
import com.kalavidarabalaga.app.ui.about.AboutActivity
import com.kalavidarabalaga.app.ui.settings.SettingsActivity
import com.kalavidarabalaga.app.ui.splash.SplashActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = UserPreferences(this)

        setupNavigation()
        setupDrawer()
    }

    override fun onResume() {
        super.onResume()
        updateDrawerHeader()
        updateNotifBadge()
    }

    // ── Bottom Nav + NavController ───────────────────────────
    private fun setupNavigation() {
        val navHost = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHost.navController
        binding.bottomNav.setupWithNavController(navController)
    }

    // ── Drawer ────────────────────────────────────────────────
    private fun setupDrawer() {
        // Navigation item clicks
        binding.navigationView.setNavigationItemSelectedListener { item ->
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            when (item.itemId) {
                R.id.nav_profile  -> {
                    startActivity(Intent(this, ProfileEditActivity::class.java))
                    @Suppress("DEPRECATION")
                    overridePendingTransition(R.anim.slide_in_left, 0)
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                R.id.nav_about    -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                    true
                }
                R.id.nav_logout   -> {
                    showLogoutDialog()
                    true
                }
                else -> false
            }
        }

        // Header tap → profile
        binding.navigationView.getHeaderView(0)?.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            startActivity(Intent(this, ProfileEditActivity::class.java))
            @Suppress("DEPRECATION")
            overridePendingTransition(R.anim.slide_in_left, 0)
        }
    }

    /** Called by HomeFragment to open the drawer */
    fun openDrawer() = binding.drawerLayout.openDrawer(GravityCompat.START)

    /** Called by HomeFragment to clear notification badge */
    fun clearNotifBadge() {
        prefs.notifCount = 0
        updateNotifBadge()
    }

    private fun updateDrawerHeader() {
        val header = binding.navigationView.getHeaderView(0) ?: return
        header.findViewById<android.widget.TextView>(R.id.tvNavName)?.text = prefs.userName
        header.findViewById<android.widget.TextView>(R.id.tvNavPhone)?.text =
            prefs.userPhone.ifBlank { "Tap to edit profile →" }

        val photoUri = prefs.userPhotoUri
        if (photoUri.isNotBlank()) {
            header.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.ivNavProfile)
                ?.let { iv ->
                    com.bumptech.glide.Glide.with(this).load(photoUri).into(iv)
                }
        }
    }

    private fun updateNotifBadge() {
        val count = prefs.notifCount
        binding.root.findViewWithTag<android.widget.TextView>("notif_badge")?.apply {
            visibility = if (count > 0) View.VISIBLE else View.GONE
            text = if (count > 9) "9+" else "$count"
        }
    }

    private fun showLogoutDialog() {
        androidx.appcompat.app.AlertDialog.Builder(this, R.style.KBAlertDialog)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Logout") { _, _ ->
                prefs.logout()
                val intent = Intent(this, com.kalavidarabalaga.app.ui.auth.LoginActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or
                              Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            @Suppress("DEPRECATION")
            super.onBackPressed()
        }
    }
}
