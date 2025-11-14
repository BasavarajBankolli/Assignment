//
// Created by basav on 14-11-2025.
//


#include "processor.h"
#include <opencv2/opencv.hpp>

void processFrame(unsigned char *nv21, int length, int width, int height, unsigned char *rgbaOut)
{
    cv::Mat yuv(height + height / 2, width, CV_8UC1, nv21);
    cv::Mat bgr;
    cv::cvtColor(yuv, bgr, cv::COLOR_YUV2BGR_NV21);

    cv::Mat edges;
    cv::Canny(bgr, edges, 80, 150);

    cv::Mat rgba;
    cv::cvtColor(edges, rgba, cv::COLOR_GRAY2RGBA);

    memcpy(rgbaOut, rgba.data, width * height * 4);
}
