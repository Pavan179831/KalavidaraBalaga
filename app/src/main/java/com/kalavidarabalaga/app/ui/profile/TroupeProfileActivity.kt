package com.kalavidarabalaga.app.ui.profile

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.adapter.ProfileGalleryAdapter
import com.kalavidarabalaga.app.data.ArtFormData.ArtForm
import com.kalavidarabalaga.app.data.LocalBooking
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.ActivityTroupeProfileBinding
import java.util.Calendar
import java.util.UUID

class TroupeProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ART_FORM = "extra_art_form"
    }

    private lateinit var binding: ActivityTroupeProfileBinding
    private lateinit var prefs: UserPreferences
    private lateinit var artForm: ArtForm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTroupeProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = UserPreferences(this)

        // Get ArtForm from intent
        @Suppress("DEPRECATION")
        artForm = intent.getParcelableExtra(EXTRA_ART_FORM)
            ?: run { finish(); return }

        setupToolbar()
        populateProfile()
        setupButtons()
        setupGallery()
    }

    // ── Toolbar ───────────────────────────────────────────────
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = artForm.name
    }

    // ── Populate all sections dynamically ────────────────────
    private fun populateProfile() {
        // Hero section
        binding.tvHeroEmoji.text   = artForm.emoji
        binding.tvTroupeName.text  = artForm.name
        binding.tvDistrictTag.text = "📍 ${artForm.district}"

        // About
        binding.tvAbout.text = artForm.description

        // Contact
        binding.tvLeadContact.text  = artForm.leadContact
        binding.tvContactPhone.text = artForm.phone

        // Service area
        binding.tvServiceArea.text = artForm.serviceArea

        // Instruments list
        populateList(binding.layoutInstruments, artForm.instruments, "🎵")

        // Equipment list
        populateList(binding.layoutEquipment, artForm.equipment, "✅")
    }

    /** Adds a styled row for each item in the list */
    private fun populateList(container: LinearLayout, items: List<String>, icon: String) {
        container.removeAllViews()
        items.forEach { item ->
            val row = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(0, 4, 0, 4)
            }
            val icon1 = TextView(this).apply {
                text = icon
                textSize = 13f
                setPadding(0, 0, 12, 0)
            }
            val label = TextView(this).apply {
                text = item
                textSize = 13f
                setTextColor(getColor(R.color.text_secondary))
            }
            row.addView(icon1)
            row.addView(label)
            container.addView(row)
        }
    }

    // ── Book + Call buttons ───────────────────────────────────
    private fun setupButtons() {
        binding.btnBook.setOnClickListener { showBookingDialog() }
        binding.btnCall.setOnClickListener { dialPhone() }
        binding.fabBook.setOnClickListener { showBookingDialog() }
    }

    private fun dialPhone() {
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${artForm.phone}")))
    }

    private fun showBookingDialog() {
        val dv     = LayoutInflater.from(this).inflate(R.layout.dialog_quick_book, null)
        val tvTitle    = dv.findViewById<TextView>(R.id.tvDialogTitle)
        val etOrgName  = dv.findViewById<EditText>(R.id.etDialogOrgName)
        val etPhone    = dv.findViewById<EditText>(R.id.etDialogPhone)
        val etEvent    = dv.findViewById<EditText>(R.id.etDialogEventName)
        val etDate     = dv.findViewById<EditText>(R.id.etDialogDate)
        val etLocation = dv.findViewById<EditText>(R.id.etDialogLocation)

        tvTitle.text = "${artForm.emoji} Book ${artForm.name}"
        etOrgName.setText(prefs.userName)
        etPhone.setText(prefs.userPhone)
        etDate.isFocusable = false
        etDate.setOnClickListener { showDatePicker(etDate) }

        AlertDialog.Builder(this, R.style.KBAlertDialog)
            .setView(dv)
            .setPositiveButton("✅ Confirm Booking") { _, _ ->
                val orgName  = etOrgName.text.toString().trim()
                val event    = etEvent.text.toString().trim()
                val date     = etDate.text.toString().trim()
                val location = etLocation.text.toString().trim()
                val orgPhone = etPhone.text.toString().trim()

                if (orgName.isEmpty() || date.isEmpty() || event.isEmpty()) {
                    Toast.makeText(this, "Fill Name, Event, and Date", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                val booking = LocalBooking(
                    id             = UUID.randomUUID().toString(),
                    artFormName    = artForm.name,
                    artFormEmoji   = artForm.emoji,
                    district       = artForm.district,
                    eventName      = event,
                    eventDate      = date,
                    eventLocation  = location.ifBlank { artForm.district },
                    organizerName  = orgName,
                    organizerPhone = orgPhone,
                    troupePhone    = artForm.phone,
                    status         = "Confirmed"
                )
                prefs.saveBooking(booking)

                Toast.makeText(this,
                    "🎉 ${artForm.name} booked for $date!\nCheck Home screen for details.",
                    Toast.LENGTH_LONG).show()

                // Animate FAB feedback
                binding.fabBook.hide()
                binding.fabBook.postDelayed({ binding.fabBook.show() }, 300)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showDatePicker(target: EditText) {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, year, month, day ->
                target.setText("%02d/%02d/%04d".format(day, month + 1, year))
            },
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)
        ).also { it.datePicker.minDate = cal.timeInMillis }.show()
    }

    // ── Gallery ───────────────────────────────────────────────
    private fun setupGallery() {
        val urls = artForm.galleryUrls
        if (urls.isEmpty()) {
            binding.rvGallery.visibility = View.GONE
            return
        }
        val galleryAdapter = ProfileGalleryAdapter(urls)
        binding.rvGallery.apply {
            layoutManager = GridLayoutManager(this@TroupeProfileActivity, 3)
            adapter = galleryAdapter
            isNestedScrollingEnabled = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
