package com.ndk.bi

import android.util.Log

class NdkExposed {
    private val TAG = NdkExposed::class.simpleName

    /**
     * Native functions
     */
    external fun stringFromJNI(): String?
    external fun concatStr(str: String): String?
    external fun concatStrParam(str: String): String?

    /**
     * Loading the native library in runtime
     */
    init {
        System.loadLibrary("ndk_cujo")
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