package com.example.edgedetection

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private lateinit var glView: GLTextureView
    private val cameraPreview = CameraPreview()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPermissions()

        glView = GLTextureView(this)

        glView.setRenderer(
            GLRenderer { surfaceTexture ->
                cameraPreview.startCamera(surfaceTexture)
            }
        )

        setContentView(glView)
    }

    override fun onPause() {
        super.onPause()
        cameraPreview.stopCamera()
    }

    private fun requestPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 123)
        }
    }
}
