package com.ndk.bi

import android.content.Context
import androidx.appcompat.app.AlertDialog

class CustomAlert constructor(ctx: Context, title: String, details: String) {
    init {
        val builder1: AlertDialog.Builder = AlertDialog.Builder(ctx)
        builder1.setMessage(details)
        builder1.setTitle(title)
        builder1.setCancelable(true)

        builder1.setPositiveButton(
            "Close"
        ) { dialog, _ -> dialog.cancel() }

        builder1.setNegativeButton(
            "Next"
        ) { dialog, _ -> dialog.cancel() }

        val alert11: AlertDialog = builder1.create()
        alert11.show()
    }
}