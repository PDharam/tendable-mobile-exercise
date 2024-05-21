package com.pdharam.tendable.root

import android.app.Application
import android.content.Context
import com.pdharam.tendable.db.DatabaseBuilder
import com.pdharam.tendable.db.TendableDatabase

class TendableApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        tendableDatabase = DatabaseBuilder.getInstance(instance!!.applicationContext)
    }

    companion object {
        private var instance: TendableApplication? = null
        lateinit var tendableDatabase: TendableDatabase
        fun getAppContext(): Context? = instance?.applicationContext
        fun getInstance(): TendableApplication? = instance

    }
}