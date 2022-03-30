package com.ndk.bi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName
    lateinit var ndk: NdkExposed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var han = Handler(Looper.getMainLooper())
        ndk = NdkExposed()
        setContentView(R.layout.activity_main)

        val cButton = findViewById<Button>(R.id.button_get_string_c)
        cButton.setOnClickListener {
            val text: String? = "[Kotlin->C] Call \n" + ndk.stringFromJNI() + "\n[C->Kotlin] Return value"
            CustomAlert(this, "String from C", text!!)
        }

        val cButton1 = findViewById<Button>(R.id.button_call_c)
        cButton1.setOnClickListener {
            val text: String? = "[Kotlin->C] Call with param: xyz" + ndk.concatStr("\n[C] xyz") + "\n[C->Kotlin] Return value"
            CustomAlert(this, "Call to Kotlin>C>Kotlin without C parameter", text!!)
        }

        val cButton2 = findViewById<Button>(R.id.button_call_c_parameter)
        cButton2.setOnClickListener {
            val text: String? =
                "[Kotlin->C] Call with param: xyz" + ndk.concatStrParam("\n[C->Kotlin] with param: xyz\n") + "\n[C->Kotlin] Return value"
            CustomAlert(this, "Call from: Kotlin>C>Kotlin with C parameter", text!!)
        }

        val newActButton = findViewById<Button>(R.id.button_start_speedify)
        newActButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SpeedifyActivity::class.java))
        })
    }


}