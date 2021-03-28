package com.example.hierarchy_class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hierarchy_class.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculatebt.setOnClickListener{(calculateTip())}

    }
    private fun calculateTip(){
        val costOfServiceText = binding.costOfService.text.toString()
        val cost = costOfServiceText.toDouble()

        val tipMultiplier = when (binding.options.checkedRadioButtonId){
            R.id.button_thirty_percent-> 0.30
            R.id.button_twenty_percent-> 0.20
            R.id.button_fifteen_percent-> 0.15
            R.id.button_ten_percent-> 0.10
            else -> 0.05
        }
        var tip = tipMultiplier * cost
        val roundingUp = binding.roundupswitch.isChecked
        if (roundingUp) tip = ceil(tip)
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.totaltip.text = getString(R.string.total_tip, formattedTip)

    }
}
