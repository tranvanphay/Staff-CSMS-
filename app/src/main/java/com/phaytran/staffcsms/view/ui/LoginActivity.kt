package com.phaytran.staffcsms.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.phaytran.staffcsms.R
import com.phaytran.staffcsms.databinding.ActivityLoginBinding
import com.phaytran.staffcsms.service.request.LoginReq
import com.phaytran.staffcsms.util.MyDialog
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
        val loading = MyDialog.initLoadingDialog(this@LoginActivity,null,resources.getString(R.string.loginProcessing))
        loading.show()
        Log.e("Phaydev:: ","Pressed login")
        if(binding.edtUsername.text.isEmpty()||binding.edtPassword.text.isEmpty()){
            MyDialog.showAlert(this@LoginActivity,resources.getString(R.string.loginFailedTitle),resources.getString(R.string.loginFieldIsEmpty),null,getString(R.string.ok)){}
        }else{
            val res = viewModel.login(LoginReq(binding.edtUsername.text.toString(),binding.edtPassword.text.toString()))
            if(res.isSuccess){
                loading.dismiss()
                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                finish()
            }else{
                MyDialog.showAlert(this@LoginActivity,resources.getString(R.string.loginFailedTitle),resources.getString(R.string.loginFailedMsg),null,resources.getString(R.string.ok)){}
            }
        }
        loading.dismiss()
    }
}