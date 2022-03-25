package com.ndk.bi

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName

    /**
     * Native functions
     */
    private external fun stringFromJNI(): String?
    private external fun concatStr(str: String): String?
    private external fun concatStrParam(str: String): String?

    /**
     * Loading the native library in runtime
     */
    init {
        System.loadLibrary("ndktest")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var han = Handler(Looper.getMainLooper())
        setContentView(R.layout.activity_main)
        val cButton = findViewById<Button>(R.id.button_call_c)
        cButton.setOnClickListener(View.OnClickListener {
            cButton.text = stringFromJNI()
            Toast.makeText(this, concatStr("Toast str: "), Toast.LENGTH_LONG).show()
            han.postDelayed(Runnable {
                Toast.makeText(this, concatStrParam("Toast str: "), Toast.LENGTH_LONG).show()
            }, 3000)
        })
    }

    /**
     * Expose the method to be called from c code
     */
    fun obtainId(): String {
        Log.e(TAG, "Value received from native code")
        return "ID - null"
    }

    fun obtainIdParam(value: String): String {
        Log.e(TAG, "Value received from native code: $value")
        return "ID - $value"
    }


}