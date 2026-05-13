package com.kalavidarabalaga.app.ui.search

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.adapter.ArtFormGridAdapter
import com.kalavidarabalaga.app.data.ArtFormData
import com.kalavidarabalaga.app.data.LocalBooking
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.FragmentSearchBinding
import com.kalavidarabalaga.app.ui.profile.TroupeProfileActivity
import java.util.Calendar
import java.util.UUID

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var prefs: UserPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = UserPreferences(requireContext())

        // Setup 2-column grid
        binding.rvArtForms.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.rvArtForms.isNestedScrollingEnabled = false

        setupDistrictSpinner()
    }

    // ── District Spinner ──────────────────────────────────────
    private fun setupDistrictSpinner() {
        val districts = ArtFormData.allDistricts()
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            districts
        ).also { it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        binding.spinnerDistrict.adapter = adapter
        binding.spinnerDistrict.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, v: View?, pos: Int, id: Long
            ) {
                if (pos == 0) showHintState() else showGridFor(districts[pos])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    // ── Grid display ──────────────────────────────────────────
    private fun showGridFor(district: String) {
        val artForms = ArtFormData.getForDistrict(district)

        binding.hintState.visibility  = View.GONE

        if (artForms.isEmpty()) {
            binding.tvArtFormsTitle.visibility = View.GONE
            binding.rvArtForms.visibility      = View.GONE
            binding.emptyState.visibility      = View.VISIBLE
            return
        }

        binding.emptyState.visibility      = View.GONE
        binding.tvArtFormsTitle.visibility = View.VISIBLE
        binding.tvArtFormsTitle.text       = "🎨  Art Forms in $district"
        binding.rvArtForms.visibility      = View.VISIBLE

        // Always pad to at least 4 slots — extras are placeholders
        val gridItems = ArtFormGridAdapter.padToGrid(artForms, minSlots = 4)

        binding.rvArtForms.adapter = ArtFormGridAdapter(
            items         = gridItems,
            onViewProfile = { af ->
                startActivity(
                    Intent(requireContext(), TroupeProfileActivity::class.java)
                        .putExtra(TroupeProfileActivity.EXTRA_ART_FORM, af)
                )
            },
            onBook = { af -> showBookingDialog(af) },
            onCall = { af -> callTroupe(af.phone) }
        )
    }

    private fun showHintState() {
        binding.hintState.visibility       = View.VISIBLE
        binding.emptyState.visibility      = View.GONE
        binding.tvArtFormsTitle.visibility = View.GONE
        binding.rvArtForms.visibility      = View.GONE
    }

    // ── Booking Dialog ────────────────────────────────────────
    private fun showBookingDialog(af: ArtFormData.ArtForm) {
        val dv         = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_quick_book, null)
        val tvTitle    = dv.findViewById<TextView>(R.id.tvDialogTitle)
        val etOrgName  = dv.findViewById<EditText>(R.id.etDialogOrgName)
        val etPhone    = dv.findViewById<EditText>(R.id.etDialogPhone)
        val etEvent    = dv.findViewById<EditText>(R.id.etDialogEventName)
        val etDate     = dv.findViewById<EditText>(R.id.etDialogDate)
        val etLocation = dv.findViewById<EditText>(R.id.etDialogLocation)

        tvTitle.text = "${af.emoji}  Book ${af.name}"
        etOrgName.setText(prefs.userName)
        etPhone.setText(prefs.userPhone)
        etDate.isFocusable = false
        etDate.setOnClickListener { pickDate(etDate) }

        AlertDialog.Builder(requireContext(), R.style.KBAlertDialog)
            .setView(dv)
            .setPositiveButton("✅ Confirm Booking") { _, _ ->
                val orgName  = etOrgName.text.toString().trim()
                val event    = etEvent.text.toString().trim()
                val date     = etDate.text.toString().trim()
                val location = etLocation.text.toString().trim()
                val orgPhone = etPhone.text.toString().trim()

                if (orgName.isEmpty() || date.isEmpty() || event.isEmpty()) {
                    Toast.makeText(requireContext(), "Fill Name, Event, and Date", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }
                prefs.saveBooking(
                    LocalBooking(
                        id             = UUID.randomUUID().toString(),
                        artFormName    = af.name,
                        artFormEmoji   = af.emoji,
                        district       = af.district,
                        eventName      = event,
                        eventDate      = date,
                        eventLocation  = location.ifBlank { af.district },
                        organizerName  = orgName,
                        organizerPhone = orgPhone,
                        troupePhone    = af.phone,
                        status         = "Confirmed"
                    )
                )
                Toast.makeText(requireContext(),
                    "🎉 ${af.name} booked for $date!\nCheck Home for details.",
                    Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun pickDate(target: EditText) {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                target.setText("%02d/%02d/%04d".format(day, month + 1, year))
            },
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)
        ).also { it.datePicker.minDate = cal.timeInMillis }.show()
    }

    private fun callTroupe(phone: String) {
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
