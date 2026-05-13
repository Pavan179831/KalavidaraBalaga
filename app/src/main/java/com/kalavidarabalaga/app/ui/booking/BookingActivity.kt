package com.kalavidarabalaga.app.ui.booking

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.kalavidarabalaga.app.databinding.ActivityBookingBinding
import java.util.Calendar

class BookingActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TROUPE_NAME = "extra_troupe_name"
        const val EXTRA_TROUPE_PHONE = "extra_troupe_phone"
        const val EXTRA_TROUPE_ID   = "extra_troupe_id"
    }

    private lateinit var binding: ActivityBookingBinding
    private val db = FirebaseFirestore.getInstance()

    private var troupeName: String = ""
    private var troupePhone: String = ""
    private var troupeId: String   = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Read extras
        troupeName  = intent.getStringExtra(EXTRA_TROUPE_NAME)  ?: ""
        troupePhone = intent.getStringExtra(EXTRA_TROUPE_PHONE) ?: ""
        troupeId    = intent.getStringExtra(EXTRA_TROUPE_ID)    ?: ""

        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.tvTroupeName.text = troupeName

        // Date picker
        binding.etEventDate.setOnClickListener { showDatePicker() }

        // Send inquiry to Firestore
        binding.btnSendInquiry.setOnClickListener { submitInquiry() }

        // Direct call
        binding.btnCallDirect.setOnClickListener {
            if (troupePhone.isNotBlank()) {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$troupePhone")))
            } else {
                Toast.makeText(this, "Phone number not available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePicker() {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, year, month, day ->
                binding.etEventDate.setText("%02d / %02d / %04d".format(day, month + 1, year))
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).also {
            it.datePicker.minDate = cal.timeInMillis // No past dates
        }.show()
    }

    private fun submitInquiry() {
        val name      = binding.etOrganizerName.text?.toString()?.trim()  ?: ""
        val phone     = binding.etOrganizerPhone.text?.toString()?.trim() ?: ""
        val eventName = binding.etEventName.text?.toString()?.trim()      ?: ""
        val date      = binding.etEventDate.text?.toString()?.trim()      ?: ""
        val location  = binding.etEventLocation.text?.toString()?.trim()  ?: ""
        val audience  = binding.etAudienceSize.text?.toString()?.trim()   ?: ""
        val message   = binding.etMessage.text?.toString()?.trim()        ?: ""

        // Validate required fields
        if (name.isEmpty() || phone.isEmpty() || eventName.isEmpty() || date.isEmpty() || location.isEmpty()) {
            Toast.makeText(this, "Please fill in all required (*) fields", Toast.LENGTH_SHORT).show()
            return
        }

        binding.btnSendInquiry.isEnabled = false
        binding.btnSendInquiry.text = "Sending…"

        // Build inquiry document
        val inquiry = hashMapOf(
            "troupeId"       to troupeId,
            "troupeName"     to troupeName,
            "organizerName"  to name,
            "organizerPhone" to phone,
            "eventName"      to eventName,
            "eventDate"      to date,
            "eventLocation"  to location,
            "audienceSize"   to audience,
            "message"        to message,
            "status"         to "pending",
            "createdAt"      to System.currentTimeMillis()
        )

        db.collection("bookings")
            .add(inquiry)
            .addOnSuccessListener {
                Toast.makeText(this, "✅ Inquiry sent! The troupe will contact you soon.", Toast.LENGTH_LONG).show()
                finish()
            }
            .addOnFailureListener { e ->
                binding.btnSendInquiry.isEnabled = true
                binding.btnSendInquiry.text = "📤 Send Booking Inquiry"
                Toast.makeText(this, "Failed to send inquiry: ${e.message}", Toast.LENGTH_SHORT).show()
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
