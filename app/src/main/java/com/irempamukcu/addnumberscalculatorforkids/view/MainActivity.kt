package com.irempamukcu.addnumberscalculatorforkids.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irempamukcu.addnumberscalculatorforkids.databinding.ActivityMainBinding
import com.irempamukcu.addnumberscalculatorforkids.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)


        binding.button.setOnClickListener {

            val num1 = binding.editTextNum1.text.toString().toIntOrNull() ?: 0
            val num2 = binding.editTextNum2.text.toString().toIntOrNull() ?: 0

            val result = calculatorViewModel.calculateSum(num1,num2)
            binding.resultTextView.text = "${result.sum}"
        }


    }
}