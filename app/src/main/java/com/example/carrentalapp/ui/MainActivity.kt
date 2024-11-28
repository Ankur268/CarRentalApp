package com.example.carrentalapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.carrentalapp.databinding.ActivityMainBinding
import com.example.carrentalapp.model.Customer
import com.example.carrentalapp.viewModel.CarRentalViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val carRentalViewModel: CarRentalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customer = Customer(id = 1, name = "Alice", speedLimit = 100.0)
        carRentalViewModel.setCustomer(customer)

        carRentalViewModel.speedLimitExceeded.observe(this, Observer {
            if (it) {
                showToast("Speed limit exceeded! Slow down.")
            } else {
                showToast("Speed is within the limit.")
            }
        })

        binding.driveButton.setOnClickListener {
            val speed = binding.speedEditText.text.toString().toDoubleOrNull() ?: 0.0
            carRentalViewModel.drive(speed)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}