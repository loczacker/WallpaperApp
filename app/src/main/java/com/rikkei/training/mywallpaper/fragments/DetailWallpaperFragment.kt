package com.rikkei.training.mywallpaper.fragments

import android.app.WallpaperManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.rikkei.training.mywallpaper.R
import com.rikkei.training.mywallpaper.databinding.FragmentWallpaperDetailBinding
import com.rikkei.training.mywallpaper.model.Wallpaper

class DetailWallpaperFragment: Fragment() {
    private lateinit var binding: FragmentWallpaperDetailBinding
    private lateinit var wallpaper: Wallpaper


    //singleton
    companion object {
        fun newInstance(wallpaper: Wallpaper): DetailWallpaperFragment {
            val fragment = DetailWallpaperFragment()
            fragment.wallpaper = wallpaper
            return  fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWallpaperDetailBinding.inflate(inflater, container, false)
        binding.tvImageName.text = wallpaper.name
        binding.tvImageAuthor.text = wallpaper.author
        Glide.with(binding.imgWallpaper)
            .load(wallpaper.imageId)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(binding.imgWallpaper)
        binding.btnSetAsWallpaper.setOnClickListener {
            Thread{
                WallpaperManager.getInstance(requireContext()).setResource(wallpaper.imageId)
            }.start()
        }
        return binding.root
    }
}