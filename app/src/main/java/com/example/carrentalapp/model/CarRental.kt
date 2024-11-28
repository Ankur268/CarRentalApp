package com.example.carrentalapp.model

class CarRental(private val customer: Customer, private val notificationService: NotificationService) {

    private var currentSpeed: Double = 0.0

    fun drive(speed: Double) {
        this.currentSpeed = speed
        checkSpeedLimit()
    }

    private fun checkSpeedLimit() {
        if (currentSpeed > customer.speedLimit) {
            // Notifications send to the company and the user
            notificationService.notifyCompany(customer)
            notificationService.alertUser(customer)
        }
    }
}
