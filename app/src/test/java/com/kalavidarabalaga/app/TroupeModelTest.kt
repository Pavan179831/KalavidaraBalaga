package com.kalavidarabalaga.app

import org.junit.Test
import org.junit.Assert.*

class TroupeModelTest {

    @Test
    fun troupe_defaultValues_areCorrect() {
        val troupe = com.kalavidarabalaga.app.model.Troupe()
        assertEquals("", troupe.id)
        assertEquals("", troupe.name)
        assertEquals(0, troupe.memberCount)
        assertEquals(false, troupe.isFeatured)
        assertTrue(troupe.galleryUrls.isEmpty())
    }

    @Test
    fun troupe_withValues_setsCorrectly() {
        val troupe = com.kalavidarabalaga.app.model.Troupe(
            id        = "abc123",
            name      = "Dollu Kunitha Sangha",
            artType   = "Dollu Kunitha",
            district  = "Tumakuru",
            phone     = "+91 9845012345",
            memberCount = 20,
            isFeatured  = true
        )
        assertEquals("abc123", troupe.id)
        assertEquals("Dollu Kunitha Sangha", troupe.name)
        assertEquals("Tumakuru", troupe.district)
        assertEquals(20, troupe.memberCount)
        assertTrue(troupe.isFeatured)
    }
}
