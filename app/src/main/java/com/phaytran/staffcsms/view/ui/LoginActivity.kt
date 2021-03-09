package com.phaytran.staffcsms.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.phaytran.staffcsms.R
import com.phaytran.staffcsms.databinding.ActivityLoginBinding
import com.phaytran.staffcsms.service.request.LoginReq
import com.phaytran.staffcsms.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(LoginViewModel::class.java)
    }

    fun onLoginButtonClicked(view: View) {
        Log.e("Phaydev:: ","Pressed login")
        viewModel.login(LoginReq(binding.edtUsername.text.toString(),binding.edtPassword.text.toString()))
    }
}