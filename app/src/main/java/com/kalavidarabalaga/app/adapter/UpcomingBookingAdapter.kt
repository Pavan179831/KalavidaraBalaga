package com.kalavidarabalaga.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kalavidarabalaga.app.data.LocalBooking
import com.kalavidarabalaga.app.databinding.ItemUpcomingBookingBinding

class UpcomingBookingAdapter(
    private var bookings: List<LocalBooking>,
    private val onEdit: (LocalBooking) -> Unit
) : RecyclerView.Adapter<UpcomingBookingAdapter.VH>() {

    inner class VH(private val b: ItemUpcomingBookingBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(booking: LocalBooking) {
            // Parse date "DD/MM/YYYY" → day + month abbreviation
            val parts = booking.eventDate.split("/")
            b.tvDay.text = if (parts.size >= 1) parts[0].trim() else "–"
            b.tvMonth.text = if (parts.size >= 2) {
                monthAbbr(parts[1].trim().toIntOrNull() ?: 0)
            } else "–"

            b.tvBookingArtForm.text  = "${booking.artFormEmoji} ${booking.artFormName}"
            b.tvBookingEvent.text    = booking.eventName.ifBlank { "Event" }
            b.tvBookingLocation.text = "📍 ${booking.eventLocation.ifBlank { booking.district }}"
            b.tvStatus.text          = if (booking.status == "Confirmed") "✅ Confirmed" else "⏳ Pending"

            // Fade-up entry
            b.root.alpha = 0f
            b.root.translationY = 20f
            b.root.animate().alpha(1f).translationY(0f)
                .setDuration(300)
                .setStartDelay((bindingAdapterPosition * 60L).coerceAtMost(300L))
                .start()

            b.tvEdit.setOnClickListener { onEdit(booking) }
            b.root.setOnClickListener  { onEdit(booking) }
        }
    }

    fun updateList(newList: List<LocalBooking>) {
        bookings = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemUpcomingBookingBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(bookings[position])

    override fun getItemCount() = bookings.size

    private fun monthAbbr(m: Int) = listOf("","JAN","FEB","MAR","APR","MAY","JUN",
                                            "JUL","AUG","SEP","OCT","NOV","DEC")
                                        .getOrElse(m) { "–" }
}
