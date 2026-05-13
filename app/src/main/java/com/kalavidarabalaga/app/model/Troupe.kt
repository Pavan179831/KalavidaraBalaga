package com.kalavidarabalaga.app.model

import android.os.Parcelable
import com.google.firebase.firestore.DocumentId
import kotlinx.parcelize.Parcelize

/**
 * Data model for a Folk Art Troupe.
 * @Parcelize lets it be passed directly between Activities via Intent.
 * Maps to a Firestore document in the "troupes" collection.
 */
@Parcelize
data class Troupe(
    @DocumentId
    val id: String = "",
    val name: String = "",
    val artType: String = "",          // e.g. "Dollu Kunitha"
    val district: String = "",         // e.g. "Mysuru"
    val description: String = "",
    val leadContact: String = "",
    val phone: String = "",
    val serviceArea: String = "",
    val memberCount: Int = 0,
    val instruments: String = "",      // Comma-separated instruments
    val equipment: String = "",        // e.g. "We have 10 drums and our own sound system"
    val coverPhotoUrl: String = "",
    val galleryUrls: List<String> = emptyList(),
    val isFeatured: Boolean = false,
    val createdAt: Long = 0L
) : Parcelable
