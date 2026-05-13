package com.kalavidarabalaga.app.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Local booking saved to SharedPreferences (as JSON) after user confirms booking.
 */
@Parcelize
data class LocalBooking(
    val id: String = "",
    val artFormName: String = "",
    val artFormEmoji: String = "🎭",
    val district: String = "",
    val eventName: String = "",
    val eventDate: String = "",       // "DD/MM/YYYY"
    val eventLocation: String = "",
    val organizerName: String = "",
    val organizerPhone: String = "",
    val troupePhone: String = "",
    val status: String = "Confirmed", // "Confirmed" | "Pending"
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable
