# Edge Detection – Android + OpenGL + Native C++ + Web Viewer

This project demonstrates a complete edge-detection pipeline implemented across multiple layers:

1. Android (Kotlin/Java)
2. OpenGL ES 2.0 Rendering
3. Native C++ (NDK) Image Processing
4. Optional Web Viewer built using TypeScript

It is structured for clarity, modularity, and ease of extension.

---

## Project Overview

The application captures camera frames on Android, sends them to OpenGL for GPU-based pre-processing, and optionally forwards frames to native C++ for CPU-based edge detection.
The project also includes a small TypeScript web viewer for displaying processed frames.

---

## Project Structure

```
app/
 ├── src/
 │    ├── main/
 │    │    ├── cpp/
 │    │    │     ├── native-lib.cpp
 │    │    │     ├── processor.cpp
 │    │    │     └── processor.h
 │    │    ├── java/com/example/edgedetection/
 │    │    │     ├── CameraPreview.kt / .java
 │    │    │     ├── GLRenderer.kt / .java
 │    │    │     ├── GLTextureView.kt / .java
 │    │    │     ├── MainActivity.kt / .java
 │    │    │     └── ShaderProgram.kt / .java
 │    │    ├── res/
 │    │    └── AndroidManifest.xml
 │    └── test/
 │
 ├── build.gradle.kts
 ├── proguard-rules.pro
 │
 └── web_viewer/
       ├── dist/
       ├── node_modules/
       └── src/
             ├── index.ts
             └── ui.ts
```

---

## Components

### 1. Android Layer (Kotlin / Java)

**CameraPreview**
Handles Camera2 or Camera API preview and passes frames to OpenGL through a SurfaceTexture.

**GLTextureView**
Custom TextureView that supports OpenGL ES rendering.

**GLRenderer**
OpenGL ES renderer that:

* Creates external OES texture
* Draws camera frames to a framebuffer
* Applies fragment shaders (edge detection, grayscale, etc.)

**ShaderProgram**
Utility class for compiling and linking GLSL shaders.

**MainActivity**
Entry point connecting UI, camera preview, renderer, and native code.

---

### 2. Native Layer (C++ / NDK)

Located in `src/main/cpp/`.

**native-lib.cpp**
JNI bridge between Android and C++.

**processor.cpp / processor.h**
CPU-side image processing algorithms such as:

* Sobel operator
* Gaussian blur
* Thresholding
* Grayscale conversion

---

### 3. Web Viewer (TypeScript)

Located in `web_viewer/`.

Contains a minimal browser-based viewer for:

* Displaying sample processed frames
* Showing resolution and FPS
* Demonstrating TypeScript DOM updates

Files include:

* `index.ts`: Application logic
* `ui.ts`: UI rendering helpers

`dist/` contains the compiled JavaScript output.

---

## Build Instructions (Android)

1. Install Android Studio Hedgehog or newer
2. Ensure NDK and CMake are installed
3. Open the project in Android Studio
4. Build and run on:

   * Physical Android device (recommended)
   * Emulator with proper ABI support

---

## Build Instructions (Web Viewer)

Navigate to the folder:

```
cd web_viewer
```

Install dependencies:

```
npm install
```

Run the development server:

```
npm run dev
```

Build for production:

```
npm run build
```

---

## Requirements

### Android

* minSdk: 24
* targetSdk: 35 or above
* OpenGL ES 2.0
* NDK 26+
* CMake 3.22+

### Web Viewer

* Node.js 18+
* TypeScript 5+

---

## Key Features

* Real-time camera frame rendering using OpenGL ES
* External OES texture processing
* Native C++ edge detection
* Modular shader pipeline
* Optional browser viewer written in TypeScript

------

