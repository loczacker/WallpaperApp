package com.rikkei.training.mywallpaper.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.rikkei.training.mywallpaper.R
import com.rikkei.training.mywallpaper.adapter.WallpaperAdapter
import com.rikkei.training.mywallpaper.adapter.WallpaperItemClickListener
import com.rikkei.training.mywallpaper.databinding.FragmentWallpaperBinding
import com.rikkei.training.mywallpaper.model.Wallpaper

class WallpaperFragment: Fragment(), WallpaperItemClickListener {
    private lateinit var binding: FragmentWallpaperBinding
    //data
    private val images = arrayListOf(
        Pair(R.drawable.january, "January"),
        Pair(R.drawable.february, "February"),
        Pair(R.drawable.march, "March"),
        Pair(R.drawable.april, "April"),
        Pair(R.drawable.may, "May"),
        Pair(R.drawable.june, "June"),
        Pair(R.drawable.july, "July"),
        Pair(R.drawable.august, "August"),
        Pair(R.drawable.september, "September"),
        Pair(R.drawable.november, "November"),
        Pair(R.drawable.october, "October"),
        Pair(R.drawable.december, "December"),
    )

    private val wallpapers by lazy {
        Array(12) {
            i ->  Wallpaper(images[i].first, images[i].second, "Tien Loc")
        }
    }
    //adapter

    //adapterView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWallpaperBinding.inflate(inflater, container, false)
        binding.rcWallpaper.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rcWallpaper.adapter = WallpaperAdapter(wallpapers.toList(), this)
        return binding.root
    }

    override fun onWallpaperItemClick(position: Int) {
        val wallpaper = wallpapers[position]
        val fragment = DetailWallpaperFragment.newInstance(wallpaper)

        exitTransition = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.explode)
        enterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.fade)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment)
            .addToBackStack(null)
            .commit()
    }
}