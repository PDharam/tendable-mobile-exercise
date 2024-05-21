package com.pdharam.tendable.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InspectionEntity(
    @PrimaryKey()
    val inspectionId: Int,
    val inspectionJson: String,
    val inspectionStatus: InspectionStatus
)