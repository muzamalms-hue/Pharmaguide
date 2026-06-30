package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_monographs")
data class UserMonographEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val productName: String,
    val activeIngredient: String,
    val dosageForm: String,
    val pf: String,
    val lgsCode: String,
    val brand: String,
    val testType: String,
    val comments: String,
    val timestamp: Long = System.currentTimeMillis()
)
