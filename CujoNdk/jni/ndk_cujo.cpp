#include <jni.h>
#include <stdarg.h>
#include <android/log.h>
#include <string>
#include <ndk_cujo.h>

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
/*jstring Java_com_ndk_bi_NdkExposed_stringFromJNI(JNIEnv* env, jobject obj){
    return (*env)->NewStringUTF(env, "Some String Data from C");
}*/
JNI_METHOD(jstring, concatStr)( JNIEnv* env, jobject instance, jstring str) {
    const jclass clazz = env->GetObjectClass(instance);
    const jmethodID method = env->GetMethodID(clazz, "obtainId", "()Ljava/lang/String;");

    if(method == nullptr){
        LOG("Function not found");
        return env->NewStringUTF("");
    }

    //obtain the result of function and cast to string
    const jobject result = env->CallObjectMethod(instance, method);
    const char* id = env->GetStringUTFChars((jstring) result, JNI_FALSE);
    std::string strId = id;

    jboolean isCopy = true;
    const char *convertedValue = (env)->GetStringUTFChars(str, &isCopy);
    std::string s = convertedValue;

    return env->NewStringUTF(s.append(strId).c_str());
}

JNI_METHOD(jstring, concatStrParam)( JNIEnv* env, jobject instance, jstring str) {
    const jclass clazz = env->GetObjectClass(instance);
    const jmethodID method = env->GetMethodID(clazz, "obtainIdParam", "(Ljava/lang/String;)Ljava/lang/String;");

    if(method == nullptr){
        LOG("Function not found");
        return env->NewStringUTF("");
    }

    //obtain the result of function and cast to string
    jstring paramStr = env->NewStringUTF("123e4567-e89b-12d3-a456-556642440000");
    const jobject result = env->CallObjectMethod(instance, method, paramStr);
    const char* id = env->GetStringUTFChars((jstring) result, JNI_FALSE);
    std::string strId = id;

    jboolean isCopy = true;
    const char *convertedValue = (env)->GetStringUTFChars(str, &isCopy);
    std::string s = convertedValue;

    return env->NewStringUTF(s.append(strId).c_str());
}

jstring getCujoString(JNIEnv* env, jobject instance, jstring str){
    //return env->NewStringUTF("Java_com_ndk_bi_NdkExposed_concatStr(env, instance, str)");
    return Java_com_ndk_bi_NdkExposed_concatStr(env, instance, str);
}


#ifdef __cplusplus
}
#endif
