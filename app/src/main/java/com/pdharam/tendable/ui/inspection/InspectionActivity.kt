package com.pdharam.tendable.ui.inspection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pdharam.tendable.databinding.ActivityInspectionBinding
import com.pdharam.tendable.ui.inspection.model.InspectionModel
import mahindra.supplier.tpm.utils.UIUtils

class InspectionActivity : AppCompatActivity() {
    lateinit var binding: ActivityInspectionBinding
    private lateinit var inspectionViewModel: InspectionViewModel
    var inspectionId: Int = 0
    private lateinit var observerInspection: Observer<InspectionModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInspectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extractIntentData()


        initState();

    }

    private fun extractIntentData() {
        if (intent != null) {
            inspectionId = intent.getIntExtra("inspectionId", 0)
        }
    }

    private fun initState() {
        inspectionViewModel = ViewModelProvider(this)[InspectionViewModel::class.java]

        observerInspection = Observer {
            UIUtils.hideProgress()
            UIUtils.t(this@InspectionActivity, "Inspection : ${it.inspection}")
        }
        UIUtils.showProgress(this@InspectionActivity, "getting inspection...")
        inspectionViewModel.getInspectionFromDB(inspectionId).observe(this, observerInspection)
    }
}