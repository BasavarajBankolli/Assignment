package com.example.edgedetection

import android.graphics.SurfaceTexture
import android.hardware.Camera
import android.util.Log

@Suppress("DEPRECATION")
class CameraPreview {

    private var camera: Camera? = null

    fun startCamera(surfaceTexture: SurfaceTexture) {
        try {
            camera = Camera.open()

            val cam = camera ?: return

            cam.setPreviewTexture(surfaceTexture)

            val params = cam.parameters
            val bestSize = params.supportedPreviewSizes.maxByOrNull { it.width * it.height }

            bestSize?.let {
                params.setPreviewSize(it.width, it.height)
                Log.d("CameraPreview", "Preview size = ${it.width}x${it.height}")
            }

            cam.parameters = params
            cam.setDisplayOrientation(90)
            cam.startPreview()

        } catch (e: Exception) {
            Log.e("CameraPreview", "Camera start error: ${e.message}")
        }
    }

    fun stopCamera() {
        try {
            camera?.stopPreview()
            camera?.release()
        } catch (_: Exception) { }
        camera = null
    }
}
