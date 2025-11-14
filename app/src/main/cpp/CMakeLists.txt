cmake_minimum_required(VERSION 3.22.1)

project(edgeDetection)

# -------------------------------
# Source files
# -------------------------------
add_library(
        edgeDetection SHARED
        native-lib.cpp
        processor.cpp
)

# -------------------------------
# OpenCV include path
# Replace this with the actual location of your OpenCV Android SDK
# Example folder: app/src/main/cpp/opencv/include
# -------------------------------
include_directories(
        ${CMAKE_SOURCE_DIR}/opencv/include
)

# -------------------------------
# Prebuilt OpenCV library
# -------------------------------
add_library(opencv_java4 SHARED IMPORTED)

set_target_properties(opencv_java4 PROPERTIES
        IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libopencv_java4.so
)

# -------------------------------
# Android system libs
# -------------------------------
find_library(log-lib log)
find_library(android-lib android)

# -------------------------------
# Link everything
# -------------------------------
target_link_libraries(
        edgeDetection
        opencv_java4      # OpenCV native
        ${log-lib}
        ${android-lib}
)
