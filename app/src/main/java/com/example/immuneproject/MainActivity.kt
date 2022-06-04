package com.example.immuneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.immuneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        supportActionBar?.hide()

    }

    override fun onResume() {
        super.onResume()
        binding.btn.setOnClickListener {
            startActivity(Intent(this, SelectActivity::class.java))
            finish()
        }
    }

}