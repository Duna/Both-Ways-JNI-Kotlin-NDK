#include <jni.h>
#include <string.h>
#include <stdarg.h>
#include <android/log.h>

#define JNI_METHOD(RETURN, METHOD_NAME) \
    JNIEXPORT RETURN JNICALL Java_com_ndk_bi_MainActivity_##METHOD_NAME

#define LOG(MESSAGE) \
    __android_log_print(ANDROID_LOG_VERBOSE, "MainActivity", MESSAGE)

#ifdef __cplusplus
extern "C" {
#endif

JNI_METHOD(jstring, stringFromJNI)( JNIEnv* env, jobject obj) {
     LOG("Returning some string data to Kotlin");
     return env->NewStringUTF("Some String Data from C");
}
/*jstring Java_com_ndk_bi_MainActivity_stringFromJNI(JNIEnv* env, jobject obj){
    return (*env)->NewStringUTF(env, "Some String Data from C");
}*/

#ifdef __cplusplus
}
#endif
