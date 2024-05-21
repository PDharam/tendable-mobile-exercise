package com.pdharam.tendable.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pdharam.tendable.databinding.ActivityDashboardBinding
import com.pdharam.tendable.network.ApiResult
import com.pdharam.tendable.ui.inspection.InspectionActivity
import com.pdharam.tendable.ui.inspection.model.InspectionModel
import mahindra.supplier.tpm.utils.UIUtils

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var observerInspection: Observer<ApiResult<InspectionModel>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initState()
        setListeners()

    }

    private fun setListeners() {
        binding.btnStartInspection.setOnClickListener {
            UIUtils.showProgress(this@DashboardActivity, "Loading Inspection...")
            dashboardViewModel.startInspection().observe(this, observerInspection)
        }
    }

    private fun openInspection(inspectionId: Int) {
        startActivity(
            Intent(
                this@DashboardActivity,
                InspectionActivity::class.java
            ).putExtra("inspectionId", inspectionId)
        )
    }

    private fun initState() {
        dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        observerInspection = Observer {
            UIUtils.hideProgress()
            when (it) {
                is ApiResult.Success -> {
                    val inspectionId = it.data.inspection.id
                    openInspection(inspectionId)
                }

                is ApiResult.Error -> {
                    UIUtils.t(this@DashboardActivity, "ApiResult.Error: ${it.error}")
                }
            }
        }

    }
}