package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "sops")
data class SopEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val code: String,
    val title: String,
    val department: String, // e.g., "Quality Control", "Quality Assurance", "Production", "Warehouse", "Microlab"
    val section: String,    // e.g., "Instruments", "General", "Solution Preparation", "Oral", "Sterile", "Non-Sterile"
    val objective: String,
    val scope: String,
    val responsibility: String,
    val procedure: String,   // Semicolon-separated or newline-separated steps
    val safetyPrecautions: String,
    val frequency: String,
    val version: String = "1.0",
    val effectiveDate: String,
    val roleRequired: String, // e.g., "Analyst", "QA Officer", "Operator", "Warehouse Executive", "All"
    val isBookmarked: Boolean = false,
    val isSignedOff: Boolean = false,
    val signOffBy: String? = null,
    val signOffTimestamp: Long? = null
) : Serializable
