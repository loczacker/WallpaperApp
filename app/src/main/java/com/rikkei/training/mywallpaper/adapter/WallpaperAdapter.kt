package com.rikkei.training.mywallpaper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rikkei.training.mywallpaper.R
import com.rikkei.training.mywallpaper.databinding.ItemWallpaperBinding
import com.rikkei.training.mywallpaper.model.Wallpaper

class WallpaperAdapter(
    private val wallpaper: List<Wallpaper>,
    private val callback: WallpaperItemClickListener
): RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemWallpaperBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(wallpaper: Wallpaper) {
                binding.tvImageName.text = wallpaper.name
                binding.tvImageAuthor.text = wallpaper.author
                Glide.with(binding.imgWallpaper)
                    .load(wallpaper.imageId)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(binding.imgWallpaper)
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemWallpaperBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = wallpaper.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        wallpaper[position].let {
            holder.bind(it)
        }
        holder.itemView.setOnClickListener {
            callback.onWallpaperItemClick(position)
        }
    }
}