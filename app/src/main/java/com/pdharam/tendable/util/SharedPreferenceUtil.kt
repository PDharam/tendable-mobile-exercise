package com.pdharam.tendable.util

import android.content.SharedPreferences
import com.google.gson.Gson
import com.pdharam.tendable.R
import com.pdharam.tendable.root.TendableApplication
import com.pdharam.tendable.ui.inspection.model.Inspection


class SharedPreferenceUtil {
    private var preferences: SharedPreferences? = null
    private val IS_LOGIN = "is_login"

    constructor() {
        preferences = TendableApplication.getAppContext()
            ?.getSharedPreferences(
                TendableApplication.getAppContext()?.getString(R.string.app_name), 0
            )
    }

    constructor(preferenceName: String) {
        preferences = TendableApplication.getAppContext()?.getSharedPreferences(preferenceName, 0)
    }

    /*
    put any type of value in sharePreference
    */

    fun putPref(key: String, value: Any) {
        val editor = preferences!!.edit()
        if (value is Boolean)
            editor.putBoolean(key, value)
        else if (value is Float)
            editor.putFloat(key, value)
        else if (value is Int)
            editor.putInt(key, value)
        else if (value is Long)
            editor.putLong(key, value)
        else if (value is String)
            editor.putString(key, value)
        editor.apply()
    }

    fun getPrefisString(key: String): String? {
        return preferences!!.getString(key, null)
    }


    fun getPrefisBoolean(key: String): Boolean {
        return preferences!!.getBoolean(key, false)
    }


    fun getPrefisBoolean(key: String, defaultVal: Boolean): Boolean {
        return preferences!!.getBoolean(key, defaultVal)
    }

    fun getPrefisInt(key: String): Int {
        return preferences!!.getInt(key, 0)
    }

    fun getPrefisInt(key: String, defaultValue: Int): Int {
        return preferences!!.getInt(key, defaultValue)
    }

    fun getPrefisFloat(key: String): Float {
        return preferences!!.getFloat(key, 0.0f)
    }


    fun getPrefisLong(key: String): Long {
        return preferences!!.getLong(key, 0)
    }

    fun clearSharedPrefs() {
        preferences!!.edit().clear().apply()

    }

    /**
     * check key is exist or not in preference
     * key is exist return true
     * key is not exist return false
     */
    fun checkPrefs(key: String): Boolean {
        return preferences!!.contains(key)
    }

    fun checkUserLogin(): Boolean {
        return getPrefisBoolean(IS_LOGIN)
    }


    fun setUserLogin(isLogin: Boolean) {
        putPref(IS_LOGIN, isLogin)
    }

    /**
     * Remove specific value from preference using there key
     */
    fun removePref(key: String) {
        val editor = preferences!!.edit()
        editor.remove(key)
        editor.apply()
    }

    fun saveInspection(inspectionId: Int, inspection: Inspection) {
        val json = Gson().toJson(inspection)
        putPref(inspectionId.toString(), json)
    }

    fun getInspectionById(inspectionId: Int): Inspection? {
        val json = getPrefisString(inspectionId.toString())
        return Gson().fromJson(json, Inspection::class.java)
    }

}
