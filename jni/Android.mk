LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := ndk_cujo
LOCAL_C_INCLUDES := ndk_cujo.h
LOCAL_SRC_FILES := ndk_cujo.cpp
LOCAL_LDLIBS := -llog

include $(BUILD_SHARED_LIBRARY)

