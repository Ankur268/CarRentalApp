package com.example.carrentalapp.model

class NotificationService {

    fun notifyCompany(customer: Customer) {
        // API called to send notification to the company
        println("Customer ${customer.name} exceeded the speed limit!")
    }

    fun alertUser(customer: Customer) {
        // API called to Notify the user
        println("Alert: Customer ${customer.name}, slow down!")
    }
}