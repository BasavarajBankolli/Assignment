#include <jni.h>
#include <string>
#include "processor.h"

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_example_edgedetection_MainActivity_processFrameNative(
        JNIEnv *env,
        jobject /* this */,
        jbyteArray input,
        jint width,
        jint height) {

    jbyte *nv21Data = env->GetByteArrayElements(input, nullptr);
    int dataLength = env->GetArrayLength(input);

    std::vector<unsigned char> rgbaOutput(width * height * 4);

    processFrame(reinterpret_cast<unsigned char *>(nv21Data),
                 dataLength, width, height, rgbaOutput.data());

    env->ReleaseByteArrayElements(input, nv21Data, JNI_ABORT);

    jbyteArray out = env->NewByteArray(rgbaOutput.size());
    env->SetByteArrayRegion(out, 0, rgbaOutput.size(), reinterpret_cast<jbyte*>(rgbaOutput.data()));

    return out;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_example_edgeDetection_MainActivity_processFrameRGBA(JNIEnv *env, jobject thiz,
                                                             jbyteArray input, jint width,
                                                             jint height) {
    // TODO: implement processFrameRGBA()
}