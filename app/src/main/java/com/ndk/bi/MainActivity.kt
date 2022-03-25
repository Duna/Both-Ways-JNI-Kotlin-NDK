package com.ndk.bi

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName

    external fun stringFromJNI(): String?

    init {
        System.loadLibrary("ndktest")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cButton = findViewById<Button>(R.id.button_call_c)
        cButton.setOnClickListener(View.OnClickListener {
            cButton.text = stringFromJNI()
        })
    }

    fun callback(value: String) {
        Log.e(TAG, "value:$value")
    }
}