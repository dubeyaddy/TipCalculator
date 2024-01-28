package com.practicekotlin.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practicekotlin.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener{calculateTip()}
    }

    fun calculateTip() {

        val serviceCostText = binding.costOfService.text
        val serviceCost = serviceCostText.toString().toDoubleOrNull()

        if (serviceCost==null){
            binding.tipResult.text = ""
            return}

        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercent = when (selectedId){
            R.id.option_amazing -> 0.20
            R.id.option_good -> 0.18
            else -> 0.15
        }

        var tip = tipPercent * serviceCost
        val roundup = binding.roundUpSwitch.isChecked

        if (roundup){
            tip = kotlin.math.ceil(tip)
        }

        NumberFormat.getCurrencyInstance()
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = "Tip Amount: "+formattedTip


    }
}













