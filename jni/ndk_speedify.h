#include <jni.h>

#ifndef _Included_com_ndk_bi_NdkExposed
#define _Included_com_ndk_bi_NdkExposed

extern "C" {


JNIEXPORT jstring Java_com_ndk_bi_NdkExposed_getSpeedifyString( JNIEnv* env, jobject instance, jstring str);


}
#endif

