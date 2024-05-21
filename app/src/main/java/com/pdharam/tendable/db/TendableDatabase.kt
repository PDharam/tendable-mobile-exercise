package com.pdharam.tendable.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pdharam.tendable.db.dao.InspectionDao
import com.pdharam.tendable.db.entity.InspectionEntity
import com.pdharam.tendable.db.entity.InspectionStatusConverter

@Database(entities = [InspectionEntity::class], version = 1)
@TypeConverters(InspectionStatusConverter::class)
abstract class TendableDatabase : RoomDatabase() {

    abstract fun inspectionDao(): InspectionDao

}