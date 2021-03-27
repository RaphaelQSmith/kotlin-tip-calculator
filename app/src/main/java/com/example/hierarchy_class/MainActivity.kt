package com.example.hierarchy_class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hierarchy_class.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculatebt.setOnClickListener(calculateTip())
    }
    fun calculateTip(){
        val costOfServiceText = binding.costOfService.text.toString()
        val cost = costOfServiceText.toDouble()

        val chosenTip = binding.options.checkedRadioButtonId
        val tip = when (chosenTip){
            R.id.button_thirty_percent-> 0.30;
            R.id.button_thirty_percent-> 0.20;
            R.id.button_thirty_percent-> 0.15;
            R.id.button_thirty_percent-> 0.10;
            else -> 0.05
        }

        }
    }
}
