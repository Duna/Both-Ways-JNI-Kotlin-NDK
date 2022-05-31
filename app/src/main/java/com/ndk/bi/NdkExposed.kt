package com.ndk.bi

import android.util.Log

class NdkExposed {
    private val TAG = NdkExposed::class.simpleName

    /**
     * Native functions from ndk_cujo
     */
    external fun stringFromJNI(): String?
    external fun concatStr(str: String): String?
    external fun concatStrParam(str: String): String?

    /**
     * Native functions from ndk_speedify
     */
    external fun getSpeedifyString(str: String): String?

    /**
     * Loading the native library in runtime
     */
    init {
        System.loadLibrary("ndk_speedify")
        System.loadLibrary("ndk_cujo")
    }

    /**
     * Expose the method to be called from c code
     */
    fun obtainId(): String {
        Log.e(TAG, "Value received from native code")
        return "\n[C->Kotlin] Call No Param, return and concat value"
    }

    fun obtainIdParam(value: String): String {
        Log.e(TAG, "[C->Kotlin] concat: $value \n")
        return "[Kotlin->C] return: $value"
    }
}