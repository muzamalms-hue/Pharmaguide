package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_inquiries")
data class ContactInquiryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fullName: String,
    val email: String,
    val contactNumber: String,
    val subject: String,
    val message: String,
    val timestamp: Long = System.currentTimeMillis()
)
