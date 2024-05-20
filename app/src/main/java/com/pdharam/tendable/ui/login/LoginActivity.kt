package com.pdharam.tendable.ui.login

import CustomAlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pdharam.tendable.R
import com.pdharam.tendable.databinding.ActivityMainBinding
import com.pdharam.tendable.network.ApiResult
import com.pdharam.tendable.ui.dashboard.DashboardActivity
import com.pdharam.tendable.ui.login.model.LoginResponse
import mahindra.supplier.tpm.utils.UIUtils

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var observerLoginApiResponse: Observer<ApiResult<LoginResponse>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        initState()
//        checkSession()
        setListener()


    }

    private fun initState() {
        observerLoginApiResponse = Observer {
            UIUtils.hideProgress()
            when (it) {
                is ApiResult.Success -> {
                    CustomAlertDialog()
                        .setTitle(resources.getString(R.string.app_name))
                        .setMsg("Login Successful.")
                        .setOKClickListener(object : CustomAlertDialog.OKlistener {
                            override fun onClick(dialog: CustomAlertDialog) {
                                dialog.dismiss()
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        DashboardActivity::class.java
                                    )
                                )
                                finish()
                            }
                        })
                        .show(supportFragmentManager, "")
                }

                is ApiResult.Error -> {
                    CustomAlertDialog()
                        .setTitle(resources.getString(R.string.app_name))
                        .setMsg("Invalid Credentials")
                        .setOKClickListener(object : CustomAlertDialog.OKlistener {
                            override fun onClick(dialog: CustomAlertDialog) {
                                dialog.dismiss()
                            }
                        })
                        .show(supportFragmentManager, "")
                }
            }
        }
    }

    private fun setListener() {
        binding.btnLogin.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                if (validateLoginForm()) {
                    UIUtils.showProgress(this@LoginActivity, "Authenticating...")
                    loginViewModel.login(
                        binding.edtEmail.text.toString(),
                        binding.edtPassword.text.toString()
                    )
                }
            }
        }
    }

    private fun validateLoginForm(): Boolean {
        var isFormValid = true
        if (TextUtils.isEmpty(binding.edtEmail.text)) {
            isFormValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.edtEmail.text.toString()).matches()) {
            isFormValid = false
        } else if (TextUtils.isEmpty(binding.edtPassword.text)) {
            isFormValid = false
        }
        return isFormValid;
    }
}