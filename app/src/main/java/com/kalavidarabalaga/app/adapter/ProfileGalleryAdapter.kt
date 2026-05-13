package com.kalavidarabalaga.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.kalavidarabalaga.app.databinding.ItemGalleryPhotoBinding

/**
 * Gallery adapter for TroupeProfileActivity.
 * Loads URL images with Glide + shimmer fadeout.
 */
class ProfileGalleryAdapter(
    private val urls: List<String>
) : RecyclerView.Adapter<ProfileGalleryAdapter.VH>() {

    inner class VH(private val b: ItemGalleryPhotoBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(url: String) {
            Glide.with(b.ivGalleryThumb.context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade(300))
                .centerCrop()
                .into(b.ivGalleryThumb)

            // Hide shimmer once image starts loading
            b.ivGalleryThumb.post { b.shimmer.visibility = ViewGroup.GONE }

            // Fade-up animation
            b.root.alpha = 0f
            b.root.animate()
                .alpha(1f)
                .setDuration(400)
                .setStartDelay((bindingAdapterPosition * 50L).coerceAtMost(300L))
                .start()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemGalleryPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(urls[position])

    override fun getItemCount() = urls.size
}
