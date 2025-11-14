#pragma once
#include <vector>

void processFrame(unsigned char *nv21,
                  int length,
                  int width,
                  int height,
                  unsigned char *rgbaOut);
