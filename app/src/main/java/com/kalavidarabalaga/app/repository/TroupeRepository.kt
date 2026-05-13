package com.kalavidarabalaga.app.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.kalavidarabalaga.app.model.Troupe
import kotlinx.coroutines.tasks.await

/**
 * Repository for all Firestore operations related to Troupes.
 * All suspend functions are safe to call from a ViewModel coroutine scope.
 */
class TroupeRepository {

    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("troupes")

    /** Fetch all featured troupes (for Home screen) */
    suspend fun getFeaturedTroupes(): List<Troupe> {
        return try {
            collection
                .whereEqualTo("isFeatured", true)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get()
                .await()
                .toObjects(Troupe::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    /** Fetch all troupes */
    suspend fun getAllTroupes(): List<Troupe> {
        return try {
            collection
                .orderBy("name")
                .get()
                .await()
                .toObjects(Troupe::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    /** Fetch troupes filtered by district and/or art type */
    suspend fun searchTroupes(
        district: String? = null,
        artType: String? = null,
        query: String? = null
    ): List<Troupe> {
        return try {
            var ref: Query = collection.orderBy("name")

            if (!district.isNullOrBlank() && district != "All Districts") {
                ref = ref.whereEqualTo("district", district)
            }
            if (!artType.isNullOrBlank() && artType != "All Art Types") {
                ref = ref.whereEqualTo("artType", artType)
            }

            val results = ref.get().await().toObjects(Troupe::class.java)

            // Client-side name filter (Firestore doesn't support LIKE)
            if (!query.isNullOrBlank()) {
                val lower = query.lowercase()
                results.filter {
                    it.name.lowercase().contains(lower) ||
                    it.artType.lowercase().contains(lower) ||
                    it.district.lowercase().contains(lower)
                }
            } else {
                results
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    /** Fetch a single troupe by ID */
    suspend fun getTroupeById(id: String): Troupe? {
        return try {
            collection.document(id)
                .get()
                .await()
                .toObject(Troupe::class.java)
        } catch (e: Exception) {
            null
        }
    }

    /** Seed sample troupes to Firestore for demo/testing */
    suspend fun seedSampleData() {
        val samples = listOf(
            Troupe(
                name = "Gorava Kunitha Kalpataru",
                artType = "Gorava Kunitha",
                district = "Mysuru",
                description = "A traditional Gorava Kunitha troupe from Mysuru with 20+ years of cultural performance experience at major festivals and weddings.",
                leadContact = "Ramesh Gorava",
                phone = "+91 9876543210",
                serviceArea = "Mysuru, Mandya, Hassan districts",
                memberCount = 15,
                instruments = "Nagari Dolu, Shruti Box, Bells",
                equipment = "We have 8 Nagari drums and traditional costumes for all 15 members.",
                isFeatured = true,
                createdAt = System.currentTimeMillis()
            ),
            Troupe(
                name = "Dollu Kunitha Sangha",
                artType = "Dollu Kunitha",
                district = "Tumakuru",
                description = "Energetic Dollu Kunitha troupe performing at corporate events, weddings, and cultural festivals across Karnataka.",
                leadContact = "Suresh Kumar",
                phone = "+91 9845012345",
                serviceArea = "Tumakuru, Bengaluru Rural, Chitradurga",
                memberCount = 20,
                instruments = "Dollu (drum), Harmonium",
                equipment = "We have 10 drums and our own sound system.",
                isFeatured = true,
                createdAt = System.currentTimeMillis() - 1000
            ),
            Troupe(
                name = "Yakshagana Bharatha Mandali",
                artType = "Yakshagana",
                district = "Dakshina Kannada",
                description = "Classical Yakshagana performance group specialising in mythological plays and overnight performances.",
                leadContact = "Venkatramana Bhat",
                phone = "+91 9741234567",
                serviceArea = "Dakshina Kannada, Udupi, Uttara Kannada",
                memberCount = 25,
                instruments = "Chande, Maddale, Harmonium, Jagatta",
                equipment = "Full stage setup, LED backdrop, and authentic costumes.",
                isFeatured = true,
                createdAt = System.currentTimeMillis() - 2000
            ),
            Troupe(
                name = "Veeragase Kalavantharu",
                artType = "Veeragase",
                district = "Bengaluru Urban",
                description = "Urban Veeragase group with high-energy acrobatic performances for large-scale events.",
                leadContact = "Prakash Nayak",
                phone = "+91 9632587410",
                serviceArea = "Bengaluru, Ramanagara, Kolar",
                memberCount = 12,
                instruments = "Dolu, Kombu",
                equipment = "Traditional weapons props, fire performance equipment.",
                isFeatured = false,
                createdAt = System.currentTimeMillis() - 3000
            )
        )
        samples.forEach { troupe ->
            collection.add(troupe).await()
        }
    }
}
