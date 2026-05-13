package com.kalavidarabalaga.app.data

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray
import org.json.JSONObject

/**
 * SharedPreferences helper for:
 *  - User profile (name, phone, address, photoUri)
 *  - Local bookings list
 *  - Notification count
 */
class UserPreferences(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("kb_prefs", Context.MODE_PRIVATE)

    // ── Profile ──────────────────────────────────────────────
    var userName: String
        get() = prefs.getString("user_name", "Your Name") ?: "Your Name"
        set(v) = prefs.edit().putString("user_name", v).apply()

    var userPhone: String
        get() = prefs.getString("user_phone", "") ?: ""
        set(v) = prefs.edit().putString("user_phone", v).apply()

    var userAddress: String
        get() = prefs.getString("user_address", "") ?: ""
        set(v) = prefs.edit().putString("user_address", v).apply()

    var userPhotoUri: String
        get() = prefs.getString("user_photo_uri", "") ?: ""
        set(v) = prefs.edit().putString("user_photo_uri", v).apply()

    // ── Notifications ─────────────────────────────────────────
    var notifCount: Int
        get() = prefs.getInt("notif_count", 1)
        set(v) = prefs.edit().putInt("notif_count", v).apply()

    // ── Auth ──────────────────────────────────────────────────
    var isLoggedIn: Boolean
        get() = prefs.getBoolean("is_logged_in", false)
        set(v) = prefs.edit().putBoolean("is_logged_in", v).apply()

    var loggedInUsername: String
        get() = prefs.getString("logged_in_user", "") ?: ""
        set(v) = prefs.edit().putString("logged_in_user", v).apply()

    /** Register a new account. Returns error string or null on success. */
    fun register(name: String, username: String, password: String, phone: String): String? {
        if (username.isBlank()) return "Username cannot be empty"
        if (password.length < 4)  return "Password must be at least 4 characters"
        if (accountExists(username)) return "Username already taken. Choose another."
        // Save account
        prefs.edit()
            .putString("acc_name_$username",     name)
            .putString("acc_pass_$username",     password)
            .putString("acc_phone_$username",    phone)
            .apply()
        return null  // success
    }

    /** Login. Returns error string or null on success. */
    fun login(username: String, password: String): String? {
        if (username.isBlank()) return "Enter your username"
        if (password.isBlank()) return "Enter your password"
        if (!accountExists(username)) return "Account not found. Please register first."
        val saved = prefs.getString("acc_pass_$username", "") ?: ""
        if (saved != password) return "Incorrect password. Please try again."
        // Login success — persist session
        isLoggedIn = true
        loggedInUsername = username
        userName = prefs.getString("acc_name_$username", username) ?: username
        userPhone = prefs.getString("acc_phone_$username", "") ?: ""
        return null
    }

    /** Reset password. Returns error string or null on success. */
    fun resetPassword(username: String, newPassword: String): String? {
        if (username.isBlank())      return "Enter your username"
        if (!accountExists(username)) return "No account found with that username"
        if (newPassword.length < 4)  return "New password must be at least 4 characters"
        prefs.edit().putString("acc_pass_$username", newPassword).apply()
        return null
    }

    /** Logout — clear session */
    fun logout() {
        isLoggedIn = false
        loggedInUsername = ""
    }

    private fun accountExists(username: String): Boolean =
        prefs.contains("acc_pass_$username")

    // ── Bookings ──────────────────────────────────────────────
    fun saveBooking(booking: LocalBooking) {
        val list = getBookings().toMutableList()
        list.add(0, booking)   // newest first
        persistList(list)
        notifCount = notifCount + 1
    }

    fun getBookings(): List<LocalBooking> {
        // Key is per-user — each account has its own isolated booking list
        val key  = "bookings_${loggedInUsername.ifBlank { "guest" }}"
        val json = prefs.getString(key, "[]") ?: "[]"
        return try {
            val arr = JSONArray(json)
            (0 until arr.length()).map { i ->
                val o = arr.getJSONObject(i)
                LocalBooking(
                    id             = o.optString("id"),
                    artFormName    = o.optString("artFormName"),
                    artFormEmoji   = o.optString("artFormEmoji", "🎭"),
                    district       = o.optString("district"),
                    eventName      = o.optString("eventName"),
                    eventDate      = o.optString("eventDate"),
                    eventLocation  = o.optString("eventLocation"),
                    organizerName  = o.optString("organizerName"),
                    organizerPhone = o.optString("organizerPhone"),
                    troupePhone    = o.optString("troupePhone"),
                    status         = o.optString("status", "Confirmed"),
                    createdAt      = o.optLong("createdAt", System.currentTimeMillis())
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun updateBooking(updated: LocalBooking) {
        val list = getBookings().toMutableList()
        val idx = list.indexOfFirst { it.id == updated.id }
        if (idx >= 0) list[idx] = updated
        else list.add(0, updated)
        persistList(list)
    }

    fun deleteBooking(id: String) {
        val list = getBookings().toMutableList().filter { it.id != id }
        persistList(list)
    }

    private fun persistList(list: List<LocalBooking>) {
        val arr = org.json.JSONArray()
        list.forEach { b ->
            arr.put(org.json.JSONObject().apply {
                put("id", b.id)
                put("artFormName", b.artFormName)
                put("artFormEmoji", b.artFormEmoji)
                put("district", b.district)
                put("eventName", b.eventName)
                put("eventDate", b.eventDate)
                put("eventLocation", b.eventLocation)
                put("organizerName", b.organizerName)
                put("organizerPhone", b.organizerPhone)
                put("troupePhone", b.troupePhone)
                put("status", b.status)
                put("createdAt", b.createdAt)
            })
        }
        val key = "bookings_${loggedInUsername.ifBlank { "guest" }}"
        prefs.edit().putString(key, arr.toString()).apply()
    }
}
