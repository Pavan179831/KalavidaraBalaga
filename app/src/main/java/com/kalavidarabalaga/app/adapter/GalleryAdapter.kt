package com.kalavidarabalaga.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.kalavidarabalaga.app.R
import com.kalavidarabalaga.app.databinding.ItemGalleryPhotoBinding

/**
 * Adapter for the StaggeredGridLayoutManager gallery on the Troupe Profile screen.
 * Each image naturally fills its grid cell height (adjustViewBounds = true).
 */
class GalleryAdapter(
    private val photoUrls: List<String>,
    private val onPhotoClick: (String) -> Unit = {}
) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun getItemCount(): Int = photoUrls.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding = ItemGalleryPhotoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(photoUrls[position])
    }

    inner class GalleryViewHolder(
        private val binding: ItemGalleryPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.ivGalleryThumb.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_ID.toInt()) {
                    onPhotoClick(photoUrls[position])
                }
            }
        }

        fun bind(url: String) {
            Glide.with(binding.ivGalleryThumb.context)
                .load(url.ifBlank { null })
                .placeholder(R.drawable.bg_rounded_card)
                .error(R.drawable.bg_rounded_card)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivGalleryThumb)
        }
    }
}
