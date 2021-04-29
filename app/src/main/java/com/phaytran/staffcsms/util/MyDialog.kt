package com.phaytran.staffcsms.util

import android.R
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface


object MyDialog {
    fun showAlert(context: Context, title: String, msg: String, btnNeg: String?, btnPos: String?,
                 onClickCallback: (which: Int) -> Unit) {
        val ocListener = DialogInterface.OnClickListener() {dialog, which ->
            onClickCallback(which)
        }
        val db = AlertDialog.Builder(context)
        db.setTitle(title)
        db.setMessage(msg)
        if (btnPos != null) db.setPositiveButton(btnPos, ocListener)
        if (btnNeg != null) db.setNegativeButton(btnNeg, ocListener)
        db.setIcon(android.R.drawable.ic_dialog_alert)
        db.show()
    }

    fun initLoadingDialog(context: Context,title: String?,msg: String?):ProgressDialog{
        val loadingDialog = ProgressDialog(context)
        if (title!=null) loadingDialog.setTitle(title)
        if (msg!=null) loadingDialog.setMessage(msg)
        loadingDialog.setCancelable(false)
        return loadingDialog
    }
}