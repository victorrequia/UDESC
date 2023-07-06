import sys
import os
import cv2 as cv

# python videoToFrames.py path_to_video.mp4 path_to_object_template.jpg

videoFile = sys.argv[1]
objectFile = sys.argv[2]

fileName = os.path.splitext(videoFile)[0]
outputDirectory = fileName + "-tracking"

objeto = cv.imread(objectFile, 1)
h, w, _ = objeto.shape

if not os.path.isdir(outputDirectory):
    os.mkdir(outputDirectory)

capture = cv.VideoCapture(videoFile)

frameNr = 0
frames = []

while (True):

    success, frame = capture.read()

    if success:
        res = cv.matchTemplate(frame, objeto, cv.TM_CCORR_NORMED)
        min_val, max_val, min_loc, max_loc = cv.minMaxLoc(res)
        top_left = max_loc
        bottom_right = (top_left[0] + w, top_left[1] + h)
        cv.rectangle(frame, top_left, bottom_right, 255, 2)
        cv.imwrite(f'{outputDirectory}/frame_{frameNr}.jpg', frame)
        height, width, layers = frame.shape
        size = (width, height)
        frames.append(frame)
    else:
        break

    frameNr = frameNr+1

fps = capture.get(cv.CAP_PROP_FPS)
capture.release()

output = cv.VideoWriter(f'{fileName}-tracking.mp4',
                        cv.VideoWriter_fourcc('m', 'p', '4', 'v'), fps, size)

for i in range(len(frames)):
    output.write(frames[i])

output.release()
