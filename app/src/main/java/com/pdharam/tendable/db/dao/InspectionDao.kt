package com.pdharam.tendable.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdharam.tendable.db.entity.InspectionEntity

@Dao
interface InspectionDao {
    @Query("SELECT * FROM InspectionEntity")
    fun getAll(): List<InspectionEntity>

    @Query("SELECT * FROM InspectionEntity WHERE inspectionId=:inspectionId")
    fun getInspectionById(inspectionId: Int): InspectionEntity

    @Insert
    fun insert(inspectionEntity: InspectionEntity)

    @Update
    fun update(inspectionEntity: InspectionEntity)

    @Delete
    fun delete(inspectionEntity: InspectionEntity)
}