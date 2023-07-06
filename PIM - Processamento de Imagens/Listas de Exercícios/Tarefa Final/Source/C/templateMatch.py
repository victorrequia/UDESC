import sys
import cv2 as cv
import numpy as np
from matplotlib import pyplot as plt

# python templateMatchingTest.py path_to_frame.jpg path_to_object_template.jpg

frame = sys.argv[1]
objeto = sys.argv[2]

img = cv.imread(frame, 0)
img2 = img.copy()
template = cv.imread(objeto, 0)
imgWidth, imgHeight = template.shape[::-1]

methods = ['cv.TM_CCOEFF', 'cv.TM_CCOEFF_NORMED', 'cv.TM_CCORR',
           'cv.TM_CCORR_NORMED', 'cv.TM_SQDIFF', 'cv.TM_SQDIFF_NORMED']

print("Métodos:")
for i, method in enumerate(methods):
    print(f"{i + 1}. {method}")
indiceMetodoSelecionado = int(
    input("Qual método quer usar: ")) - 1

metodoSelecionado = methods[indiceMetodoSelecionado]

img = img2.copy()
method = eval(metodoSelecionado)
res = cv.matchTemplate(img, template, method)
_, _, minLoc, maxLoc = cv.minMaxLoc(res)

if method in [cv.TM_SQDIFF, cv.TM_SQDIFF_NORMED]:
    topLeft = minLoc
else:
    topLeft = maxLoc

bottomRight = (topLeft[0] + imgWidth, topLeft[1] + imgHeight)

cv.rectangle(img, topLeft, bottomRight, 255, 2)

plt.subplot(122)
plt.imshow(img, cmap='gray')
plt.title('')
plt.xticks([])
plt.yticks([])

plt.subplot(121)
plt.imshow(res, cmap='gray')
plt.title(metodoSelecionado)
plt.xticks([])
plt.yticks([])

print(f'Método: {metodoSelecionado}\nMin: {minLoc}\nMax: {maxLoc}\n')

plt.show()
