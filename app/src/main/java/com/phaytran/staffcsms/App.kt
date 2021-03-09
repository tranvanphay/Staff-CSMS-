package com.phaytran.staffcsms

import android.app.Application
import android.content.Context
import android.content.ServiceConnection
import android.os.Looper
import com.phaytran.staffcsms.util.SharedPrefs


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        mSelf = this
    }

    companion object {
        private var instance: Application? = null
        private var mSelf: App? = null
        fun self(): App? {
            return mSelf
        }
    }
}