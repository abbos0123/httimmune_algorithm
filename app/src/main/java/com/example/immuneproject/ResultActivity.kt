package com.example.immuneproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.immuneproject.databinding.ActivityResultBinding
import com.example.immuneproject.immune.Display
import com.example.immuneproject.immune.ImmuneAlgorithm


class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    var n = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater);

        setContentView(binding.root)
        supportActionBar?.hide()
        setData()
        setClick()
    }

    private fun setClick() {
        binding.btn.setOnClickListener {
            val intent = Intent(this, DiseaseDescriptionActivity::class.java)
            intent.putExtra("n", n)
            startActivity(intent)
        }
    }

    private fun setData() {
        val immuneAlgorithm = ImmuneAlgorithm()

        Display.showChildMassive(immuneAlgorithm)

        println(
            """
                 
                RESULT: Matrix M is mostly related to group ${immuneAlgorithm.getResultOfImmuneAlgorithm()}.
                """.trimIndent()
        )

        val resultOfImmuneAlgorithm = immuneAlgorithm.getResultOfImmuneAlgorithm()
        n = intent.getIntExtra("n", 1)
        var text = (n % 8 + 1)

        if (text == 0)
            text = 1

        if (text < 0)
            text = -text

        if (text == 2)
            text = 1

        binding.textGroup.text = text.toString()
    }
}