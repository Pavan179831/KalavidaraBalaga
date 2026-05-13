package com.kalavidarabalaga.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kalavidarabalaga.app.data.ArtFormData.ArtForm
import com.kalavidarabalaga.app.databinding.ItemArtFormGridBinding

/**
 * Fixed 2-column grid adapter for the Search screen.
 * Always shows exactly 4 tiles — real art forms fill first slots,
 * remaining slots show a "Coming Soon" placeholder.
 */
class ArtFormGridAdapter(
    private val items: List<ArtForm?>,        // null = placeholder slot
    private val onViewProfile: (ArtForm) -> Unit,
    private val onBook: (ArtForm) -> Unit,
    private val onCall: (ArtForm) -> Unit
) : RecyclerView.Adapter<ArtFormGridAdapter.VH>() {

    inner class VH(private val b: ItemArtFormGridBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(af: ArtForm?) {
            if (af == null) {
                // ── Placeholder slot ──────────────────────────
                b.layoutReal.visibility        = View.GONE
                b.layoutPlaceholder.visibility = View.VISIBLE
                return
            }

            // ── Real art form tile ────────────────────────────
            b.layoutReal.visibility        = View.VISIBLE
            b.layoutPlaceholder.visibility = View.GONE

            b.tvGridEmoji.text    = af.emoji
            b.tvGridName.text     = af.name
            b.tvGridDistrict.text = "📍 ${af.district}"

            // Entry animation — staggered fade-up
            b.root.alpha = 0f
            b.root.translationY = 40f
            b.root.animate()
                .alpha(1f).translationY(0f)
                .setDuration(400)
                .setStartDelay((bindingAdapterPosition * 80L).coerceAtMost(350L))
                .start()

            // Tap entire card → view profile
            b.root.setOnClickListener { onViewProfile(af) }

            // Book emoji button
            b.btnGridBook.setOnClickListener { onBook(af) }

            // Call emoji button
            b.btnGridCall.setOnClickListener { onCall(af) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemArtFormGridBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    companion object {
        /** Always pads list to a minimum of 4 slots (null = placeholder). */
        fun padToGrid(artForms: List<ArtForm>, minSlots: Int = 4): List<ArtForm?> {
            val result = artForms.map { it as ArtForm? }.toMutableList()
            while (result.size < minSlots) result.add(null)
            return result
        }
    }
}
