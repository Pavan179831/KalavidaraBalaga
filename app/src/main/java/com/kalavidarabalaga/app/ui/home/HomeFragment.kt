package com.kalavidarabalaga.app.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.adapter.UpcomingBookingAdapter
import com.kalavidarabalaga.app.data.LocalBooking
import com.kalavidarabalaga.app.data.UserPreferences
import com.kalavidarabalaga.app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var prefs: UserPreferences
    private lateinit var bookingAdapter: UpcomingBookingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = UserPreferences(requireContext())

        // Hamburger → open drawer
        binding.ivHamburger.setOnClickListener {
            (activity as? com.kalavidarabalaga.app.ui.MainActivity)?.openDrawer()
        }

        // Bell → notifications
        binding.layoutBell.setOnClickListener {
            prefs.notifCount = 0
            binding.tvNotifBadge.visibility = View.GONE
            AlertDialog.Builder(requireContext(), R.style.KBAlertDialog)
                .setTitle("🔔 Notifications")
                .setMessage("✅ Welcome to Kalavidara Balaga!\n\nUse the Search tab to discover folk art troupes across Karnataka and book them for your events.")
                .setPositiveButton("OK", null)
                .show()
        }

        // "Find Artists" → switch to Search tab
        binding.btnFindArtists.setOnClickListener {
            activity?.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
                R.id.bottomNav
            )?.selectedItemId = R.id.nav_search
        }

        setupBookingsRecycler()
    }

    override fun onResume() {
        super.onResume()
        refreshBookings()
        updateNotifBadge()
    }

    private fun setupBookingsRecycler() {
        bookingAdapter = UpcomingBookingAdapter(emptyList()) { booking ->
            showBookingOptions(booking)
        }
        binding.rvUpcomingBookings.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookingAdapter
        }
    }

    private fun refreshBookings() {
        val all = prefs.getBookings().filter { it.status != "Cancelled" }
        if (all.isEmpty()) {
            binding.emptyState.visibility       = View.VISIBLE
            binding.rvUpcomingBookings.visibility = View.GONE
            binding.tvSectionTitle.visibility   = View.GONE
            binding.layoutStats.visibility      = View.GONE
        } else {
            binding.emptyState.visibility       = View.GONE
            binding.rvUpcomingBookings.visibility = View.VISIBLE
            binding.tvSectionTitle.visibility   = View.VISIBLE
            binding.layoutStats.visibility      = View.VISIBLE
            binding.tvTotalBookings.text         = "${all.size}"
            binding.tvUpcomingCount.text         = "${all.count { it.status == "Confirmed" }}"
            bookingAdapter.updateList(all)
        }
    }

    // ── Booking options dialog ────────────────────────────────
    private fun showBookingOptions(booking: LocalBooking) {
        val items = arrayOf("✏️ Edit Booking", "📞 Call Troupe", "🗑️ Delete Booking")
        AlertDialog.Builder(requireContext(), R.style.KBAlertDialog)
            .setTitle("${booking.artFormEmoji} ${booking.artFormName}")
            .setMessage("📅 ${booking.eventDate}\n📌 ${booking.eventName}\n📍 ${booking.eventLocation}")
            .setItems(items) { _, which ->
                when (which) {
                    0 -> showEditDialog(booking)
                    1 -> startActivity(
                            Intent(Intent.ACTION_DIAL,
                                android.net.Uri.parse("tel:${booking.troupePhone}"))
                         )
                    2 -> confirmDelete(booking)
                }
            }
            .show()
    }

    private fun showEditDialog(booking: LocalBooking) {
        val dialogView = LayoutInflater.from(requireContext())
            .inflate(R.layout.dialog_quick_book, null)
        val tvTitle    = dialogView.findViewById<android.widget.TextView>(R.id.tvDialogTitle)
        val etOrgName  = dialogView.findViewById<android.widget.EditText>(R.id.etDialogOrgName)
        val etPhone    = dialogView.findViewById<android.widget.EditText>(R.id.etDialogPhone)
        val etEvent    = dialogView.findViewById<android.widget.EditText>(R.id.etDialogEventName)
        val etDate     = dialogView.findViewById<android.widget.EditText>(R.id.etDialogDate)
        val etLocation = dialogView.findViewById<android.widget.EditText>(R.id.etDialogLocation)

        tvTitle.text = "✏️ Edit Booking"
        etOrgName.setText(booking.organizerName)
        etPhone.setText(booking.organizerPhone)
        etEvent.setText(booking.eventName)
        etDate.setText(booking.eventDate)
        etLocation.setText(booking.eventLocation)

        etDate.isFocusable = false
        etDate.setOnClickListener { showDatePicker(etDate) }

        AlertDialog.Builder(requireContext(), R.style.KBAlertDialog)
            .setView(dialogView)
            .setPositiveButton("💾 Save") { _, _ ->
                val updated = booking.copy(
                    organizerName  = etOrgName.text.toString().trim(),
                    organizerPhone = etPhone.text.toString().trim(),
                    eventName      = etEvent.text.toString().trim(),
                    eventDate      = etDate.text.toString().trim(),
                    eventLocation  = etLocation.text.toString().trim()
                )
                prefs.updateBooking(updated)
                refreshBookings()
                Toast.makeText(requireContext(), "Booking updated!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showDatePicker(target: android.widget.EditText) {
        val cal = java.util.Calendar.getInstance()
        android.app.DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                target.setText("%02d/%02d/%04d".format(day, month + 1, year))
            },
            cal.get(java.util.Calendar.YEAR),
            cal.get(java.util.Calendar.MONTH),
            cal.get(java.util.Calendar.DAY_OF_MONTH)
        ).also { it.datePicker.minDate = cal.timeInMillis }.show()
    }

    private fun confirmDelete(booking: LocalBooking) {
        AlertDialog.Builder(requireContext(), R.style.KBAlertDialog)
            .setTitle("🗑️ Delete Booking?")
            .setMessage("Remove \"${booking.eventName}\" on ${booking.eventDate}?")
            .setPositiveButton("Delete") { _, _ ->
                prefs.deleteBooking(booking.id)
                refreshBookings()
                Toast.makeText(requireContext(), "Booking deleted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Keep", null)
            .show()
    }

    private fun updateNotifBadge() {
        val c = prefs.notifCount
        binding.tvNotifBadge.visibility = if (c > 0) View.VISIBLE else View.GONE
        if (c > 0) binding.tvNotifBadge.text = if (c > 9) "9+" else "$c"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
