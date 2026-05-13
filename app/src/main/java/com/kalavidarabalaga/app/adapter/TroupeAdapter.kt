package com.kalavidarabalaga.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.databinding.ItemTroupeCardBinding
import com.kalavidarabalaga.app.model.Troupe

/**
 * RecyclerView adapter for displaying Troupe cards on the Home and Search screens.
 * Uses ListAdapter with DiffUtil for efficient updates.
 */
class TroupeAdapter(
    private val onTroupeClick: (Troupe) -> Unit
) : ListAdapter<Troupe, TroupeAdapter.TroupeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TroupeViewHolder {
        val binding = ItemTroupeCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TroupeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TroupeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TroupeViewHolder(
        private val binding: ItemTroupeCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_ID.toInt()) {
                    onTroupeClick(getItem(position))
                }
            }
        }

        fun bind(troupe: Troupe) {
            binding.tvTroupeName.text = troupe.name
            binding.tvDistrict.text = "📍 ${troupe.district}"
            binding.tvMembers.text = "👥 ${troupe.memberCount}"
            binding.tvArtTypeBadge.text = troupe.artType

            // Load cover photo with Glide
            Glide.with(binding.ivTroupePhoto.context)
                .load(troupe.coverPhotoUrl.ifBlank { null })
                .placeholder(R.drawable.bg_card_gradient)
                .error(R.drawable.bg_card_gradient)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivTroupePhoto)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Troupe>() {
            override fun areItemsTheSame(old: Troupe, new: Troupe) = old.id == new.id
            override fun areContentsTheSame(old: Troupe, new: Troupe) = old == new
        }
    }
}
