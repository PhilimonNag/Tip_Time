package com.philimonnag.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.philimonnag.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateBtn.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        var StringInTextField=binding.costEv.text.toString()
        val cost=StringInTextField.toDouble()
        val selectedId=binding.chooseRg.checkedRadioButtonId
        val tipPercentage=when(selectedId){
            R.id.amazingBtn-> 0.25
            R.id.okBtn->0.18
            else->0.15
        }
        var tip=cost*tipPercentage
        val roundUp=binding.toggleBtn.isChecked
        if(roundUp){
            tip= ceil(tip)
        }
        val formatTip=NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text=getString(R.string.tip_amount ,formatTip)

    }
}