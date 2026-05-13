package com.kalavidarabalaga.app.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Complete art form / troupe data — fully self-contained, no Firestore needed.
 */
object ArtFormData {

    @Parcelize
    data class ArtForm(
        val name: String,
        val emoji: String,
        val phone: String,
        val district: String,
        val description: String = "",
        val leadContact: String = "",
        val serviceArea: String = "",
        val instruments: List<String> = emptyList(),
        val equipment: List<String> = emptyList(),
        val galleryUrls: List<String> = emptyList()
    ) : Parcelable

    // ── Detailed profile data for each art form ──────────────
    private val profiles = mapOf(

        "Dollu Kunitha" to mapOf(
            "description" to "Dollu Kunitha is a vibrant folk dance of Karnataka performed with large cylindrical drums called Dollu. Groups of 12–16 performers play rhythmic beats while dancing with high energy, celebrating harvests, festivals, and community events. The performance combines powerful drumming with acrobatic movements.",
            "leadContact" to "Sri Ramesh Gowda",
            "serviceArea" to "Mysuru, Mandya, Tumakuru, Bengaluru Urban, Dharwad",
            "instruments" to listOf("Dollu (large drum)", "Tasha (small drum)", "Jagate (cymbal)", "Kombu (horn)"),
            "equipment" to listOf("12 Dollu drums", "Traditional Kannada costumes", "Sound amplification system", "Stage lights", "Transport vehicle"),
            "gallery" to listOf(
                "https://picsum.photos/seed/dollu1/400/300",
                "https://picsum.photos/seed/dollu2/400/300",
                "https://picsum.photos/seed/dollu3/400/300",
                "https://picsum.photos/seed/dollu4/400/300",
                "https://picsum.photos/seed/folk1/400/300",
                "https://picsum.photos/seed/folk2/400/300"
            )
        ),

        "Yakshagana" to mapOf(
            "description" to "Yakshagana is a traditional theatre form from coastal Karnataka combining dance, music, dialogue, costume, and stage techniques. A night-long performance narrates stories from Hindu epics like Ramayana, Mahabharata and Puranas. Known for its elaborate costumes and impressive headgear (Kirita).",
            "leadContact" to "Sri Subraya Hegde",
            "serviceArea" to "Dakshina Kannada, Udupi, Uttara Kannada, Shivamogga",
            "instruments" to listOf("Chande (drum)", "Maddale (barrel drum)", "Harmonium", "Idakka (hourglass drum)", "Jagate (cymbal)"),
            "equipment" to listOf("Full costume set (8 characters)", "Elaborate Kirita headgear", "Stage backdrop set", "PA system", "Makeup and prosthetics kit"),
            "gallery" to listOf(
                "https://picsum.photos/seed/yaksha1/400/300",
                "https://picsum.photos/seed/yaksha2/400/300",
                "https://picsum.photos/seed/yaksha3/400/300",
                "https://picsum.photos/seed/theatre1/400/300",
                "https://picsum.photos/seed/theatre2/400/300"
            )
        ),

        "Veeragase" to mapOf(
            "description" to "Veeragase is a solo devotional dance form performed by devotees of Lord Veerabhadra. The dancer, dressed in a warrior costume, performs vigorous movements depicting the heroic deeds of Veerabhadra. It is performed during Shivaratri and other Shaiva festivals across Karnataka.",
            "leadContact" to "Sri Basavaraj",
            "serviceArea" to "Mysuru, Belagavi, Dharwad, Bengaluru Urban, Vijayapura",
            "instruments" to listOf("Nagara (large drum)", "Tasha", "Shankha (conch)", "Tamate"),
            "equipment" to listOf("Veerabhadra warrior costume", "Sword and shield props", "Face makeup kit", "Nagara drums (2)", "Transport vehicle"),
            "gallery" to listOf(
                "https://picsum.photos/seed/veera1/400/300",
                "https://picsum.photos/seed/veera2/400/300",
                "https://picsum.photos/seed/veera3/400/300",
                "https://picsum.photos/seed/warrior1/400/300"
            )
        ),

        "Gorava Kunitha" to mapOf(
            "description" to "Gorava Kunitha is a devotional folk dance associated with Lord Shiva's devotees called Goravas. Performers carry a decorated wooden structure (kamba) on their heads and dance while chanting hymns. It is a common sight at Shiva temples during religious festivals in southern Karnataka.",
            "leadContact" to "Sri Nagaraj",
            "serviceArea" to "Mysuru, Bengaluru Urban, Mandya, Tumakuru",
            "instruments" to listOf("Kamba (decorated pole)", "Damaru", "Jagate", "Buguri"),
            "equipment" to listOf("Decorated Kamba structures (6)", "Traditional Gorava costumes", "Damaru drums", "Flower and leaf decorations"),
            "gallery" to listOf(
                "https://picsum.photos/seed/gorava1/400/300",
                "https://picsum.photos/seed/gorava2/400/300",
                "https://picsum.photos/seed/folk3/400/300"
            )
        ),

        "Kamsale" to mapOf(
            "description" to "Kamsale is a devotional dance performed in honor of Lord Mahadeshwara. Performers play Kamsale (bronze cymbals) rhythmically while dancing and singing devotional songs. The dance builds in tempo and intensity and is often performed barefoot on thorns as an act of devotion.",
            "leadContact" to "Sri Mahadeva",
            "serviceArea" to "Mysuru, Mandya, Belagavi, Chikkamagaluru",
            "instruments" to listOf("Kamsale (bronze cymbals)", "Dhol", "Shruti (drone instrument)"),
            "equipment" to listOf("Kamsale cymbal sets (8 pairs)", "Mahadeshwara deity portrait", "Devotional banner", "Thorn bed (for ritual walks)"),
            "gallery" to listOf(
                "https://picsum.photos/seed/kamsale1/400/300",
                "https://picsum.photos/seed/kamsale2/400/300",
                "https://picsum.photos/seed/devotion1/400/300"
            )
        ),

        "Pooja Kunitha" to mapOf(
            "description" to "Pooja Kunitha is a colorful folk art form where performers carry beautifully decorated palanquin-like structures (pooje) on their heads representing a deity. It is performed during temple festivals and processions in Tumakuru and Mandya districts.",
            "leadContact" to "Sri Somashekhar",
            "serviceArea" to "Tumakuru, Mandya, Bengaluru Rural",
            "instruments" to listOf("Dolu (drum)", "Kahi (wind instrument)", "Jagate"),
            "equipment" to listOf("Decorated Pooje structures (4)", "Bright festival costumes", "Flower garlands", "Drum set"),
            "gallery" to listOf(
                "https://picsum.photos/seed/pooja1/400/300",
                "https://picsum.photos/seed/pooja2/400/300",
                "https://picsum.photos/seed/festival1/400/300"
            )
        ),

        "Nagamandala" to mapOf(
            "description" to "Nagamandala is a night-long ritual performance from coastal Karnataka honoring the serpent deity Naga. A woman (medium) performs as the serpent goddess, drawing intricate patterns and performing to devotional music. It's considered a sacred healing ritual performed annually at temples.",
            "leadContact" to "Sri Damodara Bhat",
            "serviceArea" to "Dakshina Kannada, Udupi, Kodagu",
            "instruments" to listOf("Nagaswara", "Pung (cylindrical drum)", "Flute", "Shruti box"),
            "equipment" to listOf("Naga idol and ritual items", "Kolam powder (5 colors)", "Temple oil lamps (20+)", "Silk costume"),
            "gallery" to listOf(
                "https://picsum.photos/seed/naga1/400/300",
                "https://picsum.photos/seed/naga2/400/300",
                "https://picsum.photos/seed/ritual1/400/300"
            )
        ),

        "Lambani Dance" to mapOf(
            "description" to "Lambani is a traditional dance of the Banjara (Lambani) tribal community of northern Karnataka. Performed by women in colorful mirror-work embroidered costumes, the dance celebrates life events like weddings and harvests. The elaborate jewelry and bright costumes are iconic to this art form.",
            "leadContact" to "Smt. Yellamma Nayak",
            "serviceArea" to "Dharwad, Raichur, Kalaburagi, Belagavi, Vijayapura",
            "instruments" to listOf("Dholak (two-headed drum)", "Manjeera (finger cymbals)", "Flute", "Ektara"),
            "equipment" to listOf("8 Lambani embroidered costumes", "Mirror-work jewelry sets", "Dholak drums (2)", "Colorful folk props"),
            "gallery" to listOf(
                "https://picsum.photos/seed/lambani1/400/300",
                "https://picsum.photos/seed/lambani2/400/300",
                "https://picsum.photos/seed/tribal1/400/300",
                "https://picsum.photos/seed/tribal2/400/300"
            )
        ),

        "Bhuta Kola" to mapOf(
            "description" to "Bhuta Kola is a spirit worship ritual unique to Tulu Nadu (coastal Karnataka). Elaborately costumed performers embody local deities (Bhuta) and deliver oracles during all-night ceremonies. The ritual involves complex costumes, dramatic makeup, and intense dancing that connects the community to their ancestral spirits.",
            "leadContact" to "Sri Narayana Poojary",
            "serviceArea" to "Dakshina Kannada, Udupi",
            "instruments" to listOf("Chende (drum)", "Kansa (gong)", "Taase", "Kombu (horn)"),
            "equipment" to listOf("Bhuta deity full costume set", "Elaborate headdress (Muchilota)", "Ritual fire equipment", "Sacred ritual items"),
            "gallery" to listOf(
                "https://picsum.photos/seed/bhuta1/400/300",
                "https://picsum.photos/seed/bhuta2/400/300",
                "https://picsum.photos/seed/coastal1/400/300"
            )
        ),

        "Karaga" to mapOf(
            "description" to "Karaga is one of the oldest folk festivals of Bengaluru, performed by the Thigala community in honor of Draupadi. The performer carries a flower-decorated pot (Karaga) on his head through streets in a trance state. It's a spectacular night procession combining devotion, athleticism, and community bonding.",
            "leadContact" to "Sri Venkatesha Thigala",
            "serviceArea" to "Bengaluru Urban, Bengaluru Rural, Tumakuru",
            "instruments" to listOf("Nadaswara", "Dolu (drum)", "Tamate", "Shehnai"),
            "equipment" to listOf("Karaga (flower pot structure)", "Draupadi deity costume", "Torchbearers equipment", "Flower decorations (100kg+)"),
            "gallery" to listOf(
                "https://picsum.photos/seed/karaga1/400/300",
                "https://picsum.photos/seed/karaga2/400/300",
                "https://picsum.photos/seed/festival2/400/300"
            )
        ),

        "Kolata" to mapOf(
            "description" to "Kolata is a stick dance performed during festivals in Karnataka. Groups of performers dance in a circle, striking decorated sticks (kolata) in rhythmic patterns. It is especially popular during Krishnashtami and Dasara festivals, and is performed by both men and women across the state.",
            "leadContact" to "Sri Krishnamurthy",
            "serviceArea" to "Tumakuru, Bengaluru Urban, Mandya, Mysuru",
            "instruments" to listOf("Kolata sticks (decorated)", "Mridangam", "Flute", "Cymbals"),
            "equipment" to listOf("Kolata stick sets (24 pairs)", "Festival costumes (24)", "PA system", "Lighting rig"),
            "gallery" to listOf(
                "https://picsum.photos/seed/kolata1/400/300",
                "https://picsum.photos/seed/kolata2/400/300",
                "https://picsum.photos/seed/dance1/400/300"
            )
        ),

        "Huttari" to mapOf(
            "description" to "Huttari is the harvest festival dance of the Kodava (Coorg) community. Men and women dressed in traditional Kodava attire perform Huttari folk dances celebrating the rice harvest. The dance is a community gathering that reaffirms Kodava identity and gratitude to nature.",
            "leadContact" to "Sri Chengappa",
            "serviceArea" to "Shivamogga, Chikkamagaluru, Kodagu",
            "instruments" to listOf("Duddu (double-sided drum)", "Kolata sticks", "Kombu (horn)"),
            "equipment" to listOf("Kodava traditional costumes (16)", "Agricultural props", "Harvest decoration items", "Duddu drums"),
            "gallery" to listOf(
                "https://picsum.photos/seed/huttari1/400/300",
                "https://picsum.photos/seed/harvest1/400/300",
                "https://picsum.photos/seed/folk4/400/300"
            )
        )
    )

    // ── Build full ArtForm with profile data ──────────────────
    private fun buildArtForm(
        name: String, emoji: String, phone: String, district: String
    ): ArtForm {
        val p = profiles[name] ?: emptyMap<String, Any>()
        @Suppress("UNCHECKED_CAST")
        return ArtForm(
            name        = name,
            emoji       = emoji,
            phone       = phone,
            district    = district,
            description = p["description"] as? String ?: "A traditional Karnataka folk art form.",
            leadContact = p["leadContact"] as? String ?: "Contact Troupe Leader",
            serviceArea = p["serviceArea"] as? String ?: district,
            instruments = p["instruments"] as? List<String> ?: listOf("Traditional instruments"),
            equipment   = p["equipment"] as? List<String> ?: listOf("Standard performance equipment"),
            galleryUrls = p["gallery"] as? List<String> ?: listOf(
                "https://picsum.photos/seed/$name/400/300"
            )
        )
    }

    // ── District → Art Forms map — ALL 31 Karnataka Districts ──
    private val allArtForms: Map<String, List<ArtForm>> = mapOf(
        "Bagalkot" to listOf(
            buildArtForm("Lambani Dance", "💃", "+91 9902112233", "Bagalkot"),
            buildArtForm("Veeragase",     "⚔️", "+91 9882112234", "Bagalkot")
        ),
        "Ballari" to listOf(
            buildArtForm("Lambani Dance", "💃", "+91 9902223344", "Ballari"),
            buildArtForm("Dollu Kunitha", "🥁", "+91 9882223345", "Ballari")
        ),
        "Belagavi" to listOf(
            buildArtForm("Veeragase",     "⚔️", "+91 9900445566", "Belagavi"),
            buildArtForm("Lambani Dance", "💃", "+91 9880445567", "Belagavi"),
            buildArtForm("Kamsale",       "🎵", "+91 9845445568", "Belagavi")
        ),
        "Bengaluru Rural" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9900556681", "Bengaluru Rural"),
            buildArtForm("Karaga",        "🏺", "+91 9880556682", "Bengaluru Rural")
        ),
        "Bengaluru Urban" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9900556677", "Bengaluru Urban"),
            buildArtForm("Veeragase",     "⚔️", "+91 9880556678", "Bengaluru Urban"),
            buildArtForm("Karaga",        "🏺", "+91 9845556679", "Bengaluru Urban"),
            buildArtForm("Gorava Kunitha","🌺", "+91 9741556680", "Bengaluru Urban")
        ),
        "Bidar" to listOf(
            buildArtForm("Lambani Dance", "💃", "+91 9902334455", "Bidar"),
            buildArtForm("Veeragase",     "⚔️", "+91 9882334456", "Bidar")
        ),
        "Chamarajanagara" to listOf(
            buildArtForm("Veeragase",     "⚔️", "+91 9901667788", "Chamarajanagara"),
            buildArtForm("Kamsale",       "🎵", "+91 9881667789", "Chamarajanagara")
        ),
        "Chikkaballapur" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9901334455", "Chikkaballapur"),
            buildArtForm("Veeragase",     "⚔️", "+91 9881334456", "Chikkaballapur"),
            buildArtForm("Gorava Kunitha","🌺", "+91 9741334457", "Chikkaballapur")
        ),
        "Chikkamagaluru" to listOf(
            buildArtForm("Huttari",       "🌾", "+91 9901223344", "Chikkamagaluru"),
            buildArtForm("Yakshagana",    "🎭", "+91 9881223345", "Chikkamagaluru")
        ),
        "Chitradurga" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9901778899", "Chitradurga"),
            buildArtForm("Veeragase",     "⚔️", "+91 9881778900", "Chitradurga")
        ),
        "Dakshina Kannada" to listOf(
            buildArtForm("Yakshagana",    "🎭", "+91 9886001122", "Dakshina Kannada"),
            buildArtForm("Nagamandala",   "🐍", "+91 9845001123", "Dakshina Kannada"),
            buildArtForm("Bhuta Kola",    "🔥", "+91 9741001124", "Dakshina Kannada")
        ),
        "Davanagere" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9901889900", "Davanagere"),
            buildArtForm("Lambani Dance", "💃", "+91 9881889901", "Davanagere")
        ),
        "Dharwad" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9900334455", "Dharwad"),
            buildArtForm("Veeragase",     "⚔️", "+91 9880334456", "Dharwad"),
            buildArtForm("Lambani Dance", "💃", "+91 9845334457", "Dharwad")
        ),
        "Gadag" to listOf(
            buildArtForm("Veeragase",     "⚔️", "+91 9902001122", "Gadag"),
            buildArtForm("Dollu Kunitha", "🥁", "+91 9882001123", "Gadag")
        ),
        "Hassan" to listOf(
            buildArtForm("Yakshagana",    "🎭", "+91 9900778899", "Hassan"),
            buildArtForm("Dollu Kunitha", "🥁", "+91 9880778900", "Hassan"),
            buildArtForm("Veeragase",     "⚔️", "+91 9845778901", "Hassan")
        ),
        "Haveri" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9901990011", "Haveri"),
            buildArtForm("Lambani Dance", "💃", "+91 9881990012", "Haveri")
        ),
        "Kalaburagi" to listOf(
            buildArtForm("Lambani Dance", "💃", "+91 9900990011", "Kalaburagi"),
            buildArtForm("Dollu Kunitha", "🥁", "+91 9880990012", "Kalaburagi")
        ),
        "Kodagu" to listOf(
            buildArtForm("Huttari",       "🌾", "+91 9902667788", "Kodagu"),
            buildArtForm("Nagamandala",   "🐍", "+91 9882667789", "Kodagu")
        ),
        "Kolar" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9901445566", "Kolar"),
            buildArtForm("Karaga",        "🏺", "+91 9881445567", "Kolar")
        ),
        "Koppal" to listOf(
            buildArtForm("Lambani Dance", "💃", "+91 9902445566", "Koppal"),
            buildArtForm("Dollu Kunitha", "🥁", "+91 9882445567", "Koppal")
        ),
        "Mandya" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9900667788", "Mandya"),
            buildArtForm("Pooja Kunitha", "🪔", "+91 9880667789", "Mandya"),
            buildArtForm("Kamsale",       "🎵", "+91 9845667790", "Mandya")
        ),
        "Mysuru" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9876543210", "Mysuru"),
            buildArtForm("Veeragase",     "⚔️", "+91 9845011223", "Mysuru"),
            buildArtForm("Gorava Kunitha","🌺", "+91 9741234567", "Mysuru"),
            buildArtForm("Kamsale",       "🎵", "+91 9632587410", "Mysuru")
        ),
        "Raichur" to listOf(
            buildArtForm("Lambani Dance", "💃", "+91 9900889900", "Raichur"),
            buildArtForm("Veeragase",     "⚔️", "+91 9880889901", "Raichur")
        ),
        "Ramanagara" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9901556677", "Ramanagara"),
            buildArtForm("Gorava Kunitha","🌺", "+91 9881556678", "Ramanagara")
        ),
        "Shivamogga" to listOf(
            buildArtForm("Yakshagana",    "🎭", "+91 9901112233", "Shivamogga"),
            buildArtForm("Dollu Kunitha", "🥁", "+91 9881112234", "Shivamogga"),
            buildArtForm("Huttari",       "🌾", "+91 9741112235", "Shivamogga")
        ),
        "Tumakuru" to listOf(
            buildArtForm("Dollu Kunitha", "🥁", "+91 9845099001", "Tumakuru"),
            buildArtForm("Pooja Kunitha", "🪔", "+91 9741099002", "Tumakuru"),
            buildArtForm("Kolata",        "🪄", "+91 9632099003", "Tumakuru")
        ),
        "Udupi" to listOf(
            buildArtForm("Yakshagana",    "🎭", "+91 9880112233", "Udupi"),
            buildArtForm("Nagamandala",   "🐍", "+91 9741112235", "Udupi")
        ),
        "Uttara Kannada" to listOf(
            buildArtForm("Yakshagana",    "🎭", "+91 9880223344", "Uttara Kannada"),
            buildArtForm("Dollu Kunitha", "🥁", "+91 9845223345", "Uttara Kannada")
        ),
        "Vijayapura" to listOf(
            buildArtForm("Veeragase",     "⚔️", "+91 9901001122", "Vijayapura"),
            buildArtForm("Lambani Dance", "💃", "+91 9881001123", "Vijayapura")
        ),
        "Yadgir" to listOf(
            buildArtForm("Lambani Dance", "💃", "+91 9902556677", "Yadgir"),
            buildArtForm("Veeragase",     "⚔️", "+91 9882556678", "Yadgir")
        )
    )

    fun getForDistrict(district: String): List<ArtForm> =
        allArtForms[district] ?: emptyList()

    fun allDistricts(): List<String> =
        listOf("Select District") + allArtForms.keys.sorted()
}
