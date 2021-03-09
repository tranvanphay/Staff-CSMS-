package com.phaytran.staffcsms.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.phaytran.staffcsms.repository.LoginRepository
import com.phaytran.staffcsms.service.request.LoginReq
import com.phaytran.staffcsms.service.response.LoginRes

class LoginViewModel(application: Application): AndroidViewModel(application) {
    val repository = LoginRepository(application)

    fun login(req:LoginReq): LoginRes {
       return repository.doLogin(req)
    }
}