package com.example.immuneproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.immuneproject.R
import com.example.immuneproject.adapters.MyAdapter
import com.example.immuneproject.databinding.ActivityDiseaseDescriotionBinding

class DiseaseDescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiseaseDescriotionBinding
    private var n = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiseaseDescriotionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        getData()

        setData()

        setAdapter()
    }



    @SuppressLint("SetTextI18n")
    private fun setData() {
        when (n) {
            1 -> {
                binding.nameIllness.text = "Disease One"
            }
            2 -> {
                binding.nameIllness.text = "Disease Two"
            }
            3 -> {
                binding.nameIllness.text = "Disease Three"
            }
            4 -> {
                binding.nameIllness.text = "Disease Four"
            }
            5 -> {
                binding.nameIllness.text = "Disease Five"
            }
            6 -> {
                binding.nameIllness.text = "Disease Six"
            }
            7 -> {
                binding.nameIllness.text = "Disease Seven"
            }
            8 -> {
                binding.nameIllness.text = "Disease Eight"
            }
        }
    }

    private fun getData() {
        n = intent.getIntExtra("n", 1)
        n = (n % 8 + 1)

        if (n == 0)
            n = 1

        if (n < 0)
            n = -n

        if (n == 2)
            n = 1

    }

    private fun setAdapter() {
        val list = ArrayList<String>()
        list.add("one")
        list.add("two")
        list.add("three")
        list.add("four")
        list.add("five")
        list.add("six")

        val adapter = MyAdapter(list)
        binding.rv.adapter = adapter
    }
}