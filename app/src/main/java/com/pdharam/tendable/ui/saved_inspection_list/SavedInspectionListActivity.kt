package com.pdharam.tendable.ui.saved_inspection_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pdharam.tendable.databinding.ActivitySavedInspectionListBinding
import com.pdharam.tendable.ui.inspection.model.InspectionModel

class SavedInspectionListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySavedInspectionListBinding
    private lateinit var savedInspectionListViewModel: SavedInspectionListViewModel
    private lateinit var observerInspection: Observer<List<InspectionModel>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySavedInspectionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initState()

    }

    private fun initState() {
        savedInspectionListViewModel =
            ViewModelProvider(this)[SavedInspectionListViewModel::class.java]

        observerInspection = Observer {

        }
    }
}