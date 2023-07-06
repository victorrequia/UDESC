import sys
import cv2 as cv
import numpy as np

# python templateMatchingVideo.py path_to_video.mp4 path_to_object_template.jpg

frame = sys.argv[1]
objeto = sys.argv[2]

obj = cv.imread(objeto, 0)
objWidth, objHeight = obj.shape[::-1]

capture = cv.VideoCapture(frame)

frameWidth = int(capture.get(cv.CAP_PROP_FRAME_WIDTH))
frameHeight = int(capture.get(cv.CAP_PROP_FRAME_HEIGHT))

method = cv.TM_CCOEFF_NORMED

while True:
    ret, frame = capture.read()

    grayFrame = cv.cvtColor(frame, cv.COLOR_BGR2GRAY)
    img = grayFrame.copy()
    res = cv.matchTemplate(img, obj, method)

    cv.imshow('', res)

    if cv.waitKey(1) == ord('q'):
        break

cv.destroyAllWindows()
