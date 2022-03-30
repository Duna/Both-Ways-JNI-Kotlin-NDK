package com.ndk.bi

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SpeedifyActivity : AppCompatActivity() {
    private val TAG = SpeedifyActivity::class.simpleName
    lateinit var ndk: NdkExposed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var han = Handler(Looper.getMainLooper())
        ndk = NdkExposed()
        setContentView(R.layout.activity_speedify)
        val cButton = findViewById<Button>(R.id.button_call_c)
        cButton.setOnClickListener(View.OnClickListener {
            try {
                val text = ndk.getSpeedifyString("ComplexID is:")
                Toast.makeText(this, "ndk->speedify->cujo->kotlin: $text", Toast.LENGTH_LONG).show()
            } catch (ex: Exception) {
                Log.d(TAG, "JNI invoke method failed: $ex")
            }
        })
    }


}