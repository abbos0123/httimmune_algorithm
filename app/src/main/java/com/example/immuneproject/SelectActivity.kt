package com.example.immuneproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.immuneproject.adapters.MyAdapter
import com.example.immuneproject.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater);
        setContentView(binding.root)
        supportActionBar?.hide()

        setDefault()
        setClicks()
    }



    @SuppressLint("SetTextI18n")
    private fun setDefault(){
        binding.textDisease1.text = "Disease one"
        binding.textDisease.text = "Disease two"
        binding.textDisease3.text = "Disease three"
        binding.textDisease4.text = "Disease four"
        binding.textDisease5.text = "Disease five"
        binding.textDisease6.text = "Disease six"
        binding.textDisease7.text = "Disease seven"
        binding.textDisease8.text = "Disease eight"

        binding.radio1.isChecked = true
        binding.radio2.isChecked = true
        binding.radio3.isChecked = true
        binding.radio4.isChecked = true
        binding.radio5.isChecked = true
        binding.radio6.isChecked = true
        binding.radio7.isChecked = true
        binding.radio8.isChecked = true
    }
    private fun setClicks() {
        binding.nextButton.setOnClickListener {
            val n = getData()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("n", n)
            startActivity(intent)
        }

    }

    private fun getData(): Int {
        val checkedRadioButtonId = binding.group1.checkedRadioButtonId
        val checkedRadioButtonId2 = binding.group2.checkedRadioButtonId
        val checkedRadioButtonId3 = binding.group3.checkedRadioButtonId
        val checkedRadioButtonId4 = binding.group4.checkedRadioButtonId
        val checkedRadioButtonId5 = binding.group5.checkedRadioButtonId
        val checkedRadioButtonId6 = binding.group6.checkedRadioButtonId
        val checkedRadioButtonId7 = binding.group7.checkedRadioButtonId
        val checkedRadioButtonId8 = binding.group8.checkedRadioButtonId

        return checkedRadioButtonId + checkedRadioButtonId2 +
                checkedRadioButtonId3 + checkedRadioButtonId4 +
                checkedRadioButtonId5 + checkedRadioButtonId6 +
                checkedRadioButtonId7 + checkedRadioButtonId8

    }
}