# TwoWayJNI

![](https://komarev.com/ghpvc/?username=Duna) [![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FDuna%2FBoth-Ways-JNI-Kotlin-NDK&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

The project is POC of using JNI for Android NDK. It consists in 3 modules:
- Calling C++ function from Kotlin
- Calling Kotlin function from C++
- Calling Kotlin function from Kotlin, then calling C++ function from another C++ Lib then calling Kotlin function again

On Mac(or any other OS) install the NDK and execute the following command lines:

```
export ANDROID_SDK=/Users/mariusduna/Library/Android/sdk

export PATH=$PATH:$ ANDROID_SDK/tools:$ANDROID_SDK/platform-tools

export ANDROID_NDK=/Users/mariusduna/Library/Android/sdk/ndk/24.0.8215888

export PATH=$PATH:$ANDROID_SDK/tools:$ANDROID_SDK/platform-tools:$ANDROID_NDK
```
`ndk-build` - is needed for for building the native libraries

Steps:
1. Execute #Build #1 section from Android.mk file, leave #Build #2 section commented out
2. Copy the output from `/jni` folder to `/jniLibs` folder
3. Execute #Build #2 section from Android.mk file, leave #Build #1 section commented out
4. Copy the output from `/jni` folder to `/jniLibs` folder
5. Run the Android app

Notes:
 - On step 1 the speedify.so lib is generated and includes also static reference to cujo.so lib
 - On step 2 only shared cujo lib is generated - used to show how JNI works in both directions

 Also:
 1. From the MainActivity the direct JNI calls from and to c library are made
 2. From the SpeedActivity calls from c to another c library and back to Kotlin are made.
 All calls can be triggered in both directions.
