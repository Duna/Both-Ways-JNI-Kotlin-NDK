# TwoWayJNI

The project is POC of using JNI for Android NDK. It consists in 2 modules:
- Calling C++ function from Kotlin
- Calling Kotlin function from C++

On Mac install the NDK and execute the following command lines:

```
export ANDROID_SDK=/Users/mariusduna/Library/Android/sdk

export PATH=$PATH:$ ANDROID_SDK/tools:$ANDROID_SDK/platform-tools

export ANDROID_NDK=/Users/mariusduna/Library/Android/sdk/ndk/24.0.8215888

export PATH=$PATH:$ANDROID_SDK/tools:$ANDROID_SDK/platform-tools:$ANDROID_NDK
```

`ndk-build` - for building the native libraries

Copy the output .so files to jniLibs folder
