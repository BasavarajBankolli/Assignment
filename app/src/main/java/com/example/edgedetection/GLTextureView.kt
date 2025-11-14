package com.example.edgedetection

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet

class GLTextureView(context: Context, attrs: AttributeSet? = null) :
    GLSurfaceView(context, attrs) {

    init {
        setEGLContextClientVersion(2)
    }
}
