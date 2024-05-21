package com.pdharam.tendable.db.entity

import androidx.room.TypeConverter

enum class InspectionStatus(val status: String) {
    DRAFT("draft"),
    COMPLETED("completed");

}

class InspectionStatusConverter {
    @TypeConverter
    fun toHealth(value: String) = enumValueOf<InspectionStatus>(value)

    @TypeConverter
    fun fromHealth(value: InspectionStatus) = value.name
}