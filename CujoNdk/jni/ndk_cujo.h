#include <jni.h>

#ifndef _Included_com_ndk_bi_NdkExposed
#define _Included_com_ndk_bi_NdkExposed
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jstring Java_com_ndk_bi_NdkExposed_stringFromJNI( JNIEnv* env, jobject instance);
JNIEXPORT jstring Java_com_ndk_bi_NdkExposed_concatStr( JNIEnv* env, jobject instance, jstring str);
JNIEXPORT jstring Java_com_ndk_bi_NdkExposed_concatStrParam( JNIEnv* env, jobject instance, jstring str);
jstring getCujoString(JNIEnv* env, jobject instance, jstring str);

#ifdef __cplusplus
}
#endif
#endif
