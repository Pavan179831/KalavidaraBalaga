package com.kalavidarabalaga.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kalavidarabalaga.app.data.ArtFormData.ArtForm
import com.kalavidarabalaga.app.databinding.ItemArtFormBinding

class ArtFormAdapter(
    private val artForms: List<ArtForm>,
    private val onViewProfile: (ArtForm) -> Unit,
    private val onBook: (ArtForm) -> Unit,
    private val onCall: (ArtForm) -> Unit
) : RecyclerView.Adapter<ArtFormAdapter.VH>() {

    inner class VH(private val b: ItemArtFormBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(af: ArtForm) {
            b.tvArtEmoji.text      = af.emoji
            b.tvArtFormName.text   = af.name
            b.tvDistrictBadge.text = "📍 ${af.district}"
            b.tvPhone.text         = "📞 ${af.phone}"

            // Staggered entry animation
            b.root.alpha = 0f
            b.root.translationY = 30f
            b.root.animate()
                .alpha(1f).translationY(0f)
                .setDuration(350)
                .setStartDelay((bindingAdapterPosition * 80L).coerceAtMost(400L))
                .start()

            b.btnViewProfile.setOnClickListener { onViewProfile(af) }
            b.btnBook.setOnClickListener        { onBook(af) }
            b.btnCall.setOnClickListener        { onCall(af) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemArtFormBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(artForms[position])

    override fun getItemCount() = artForms.size
}
