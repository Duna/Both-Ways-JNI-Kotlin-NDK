#include<jni.h>
#include<string.h>

jstring Java_com_ndk_bi_MainActivity_stringFromJNI(JNIEnv* env, jobject obj){
    return (*env)->NewStringUTF(env, "Some String Data from C");
}
