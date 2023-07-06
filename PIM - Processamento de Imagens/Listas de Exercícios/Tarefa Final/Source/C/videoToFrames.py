import sys
import os
import cv2 as cv

dirName = "frames"

videoFile = sys.argv[1]
fileName = os.path.splitext(videoFile)[0]
os.makedirs(dirName)

capture = cv.VideoCapture(videoFile)

n = 0
while (True):
    success, frame = capture.read()

    if success:
        cv.imwrite(f'{dirName}/frame_{n}.jpg', frame)
    else:
        break

    n += 1

capture.release()
