package com.rikkei.training.mywallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rikkei.training.mywallpaper.databinding.ActivityMainBinding
import com.rikkei.training.mywallpaper.fragments.WallpaperFragment

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private val currentFragment
        get() = supportFragmentManager.findFragmentById(R.id.content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, WallpaperFragment())
                .commit()
        }
    }
}