package com.ndk.bi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName
    lateinit var ndk: NdkExposed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var han = Handler(Looper.getMainLooper())
        ndk = NdkExposed()
        setContentView(R.layout.activity_main)
        val cButton = findViewById<Button>(R.id.button_call_c)
        cButton.setOnClickListener(View.OnClickListener {
            cButton.text = ndk.stringFromJNI()
            Toast.makeText(this, ndk.concatStr("Toast str: "), Toast.LENGTH_LONG).show()
            han.postDelayed(Runnable {
                Toast.makeText(this, ndk.concatStrParam("Toast str: "), Toast.LENGTH_LONG).show()
            }, 3000)
        })

        val newActButton = findViewById<Button>(R.id.button_start_speedify)
        newActButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SpeedifyActivity::class.java))
        })
    }


}