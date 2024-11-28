package com.example.carrentalapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.carrentalapp.model.CarRental
import com.example.carrentalapp.model.Customer
import com.example.carrentalapp.model.NotificationService

class CarRentalViewModel : ViewModel(){
    private val notificationService = NotificationService()

    private val isSpeedLimitExceeded = MutableLiveData<Boolean>()
    val speedLimitExceeded: LiveData<Boolean> get() = isSpeedLimitExceeded

    private lateinit var customer: Customer
    private lateinit var carRental: CarRental

    fun setCustomer(customer: Customer) {
        this.customer = customer
        carRental = CarRental(customer, notificationService)
    }

    fun drive(speed: Double) {
        carRental.drive(speed)
        isSpeedLimitExceeded.value = speed > customer.speedLimit
    }
}