package com.pdharam.tendable.db

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var INSTANCE: TendableDatabase? = null
    fun getInstance(context: Context): TendableDatabase {
        if (INSTANCE == null) {
            synchronized(TendableDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            TendableDatabase::class.java,
            "tendable_app_db"
        ).build()
}