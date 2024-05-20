package com.pdharam.tendable.ui.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pdharam.tendable.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initState()

    }

    private fun initState() {
        TODO("Not yet implemented")
    }
}