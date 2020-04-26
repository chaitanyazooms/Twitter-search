package com.pairdev.twittersearch.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pairdev.twittersearch.databinding.ActivityMainBinding
import com.pairdev.twittersearch.infra.di.AppViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
