#include <jni.h>
#include <stdarg.h>
#include <android/log.h>
#include <string>
#include <ndk_cujo.h>
#include <dlfcn.h>

#define JNI_METHOD(RETURN, METHOD_NAME) \
    JNIEXPORT RETURN JNICALL Java_com_ndk_bi_NdkExposed_##METHOD_NAME

#define LOG(MESSAGE) \
    __android_log_print(ANDROID_LOG_VERBOSE, "NdkExposed", MESSAGE)

#ifdef __cplusplus
extern "C" {
#endif

JNI_METHOD(jstring, stringFromJNI)( JNIEnv* env, jobject instance) {
     LOG("Returning some string data to Kotlin");
     return env->NewStringUTF("String Data from C lib");
}

JNI_METHOD(jstring, getSpeedifyString)( JNIEnv* env, jobject instance, jstring str) {
    jboolean isCopy = true;
    const char *cParam = (env)->GetStringUTFChars(str, &isCopy);
    std::string sParam = cParam;

    typedef jstring (*foo_t)(JNIEnv* env, jobject instance, jstring str);
    foo_t foo = NULL;

    void *pLib = ::dlopen("libndk_cujo.so", RTLD_LAZY);
    if (!pLib) {
        LOG("Function not found");
        return str;
    }
    foo = (foo_t)::dlsym(pLib, "getCujoString");

    //jstring jReturnParam = Java_com_ndk_bi_NdkExposed_concatStr(env, instance, str);
    //jstring jReturnParam =  getCujoString_cujo(env, instance, str);
    jstring jReturnParam = foo(env, instance, str);

    const char* cReturnParam = env->GetStringUTFChars(jReturnParam, JNI_FALSE);
    std::string strReturnParam = cReturnParam;

    return env->NewStringUTF(strReturnParam.append(sParam).c_str());
    //return str;
}

#ifdef __cplusplus
}
#endif
