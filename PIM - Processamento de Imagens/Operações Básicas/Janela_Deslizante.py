import cv2
import numpy as np
from matplotlib import pyplot as plt

def extract_patches(img,patch_shape):
  patches = []
  y_offset = (patch_shape[1]-1)//2
  x_offset = (patch_shape[0]-1)//2
  for x in range(0, img.shape[1]):
    for y in range(0, img.shape[0]):
        if(y-y_offset < 0 or x-x_offset < 0 ):
          continue
        if(y+y_offset > img.shape[1] or x+x_offset > img.shape[0]):
          continue
        patch_img = np.copy(img[y-y_offset:y+y_offset+1, x-x_offset:x+x_offset+1])
        patches.append(patch_img)

				# #temporario para testes
        if(len(patches) == 60):
          return patches

    
path='./'
nome=path+'lena_B.png'#'insetoGray.png' #'copan.jpg'#'lena_B.png'#
img = cv2.imread(nome,cv2.IMREAD_GRAYSCALE)
patches = extract_patches(img,[200,200])    
g1=plt.figure(figsize=(20,10))
plt.subplot(471),plt.imshow(img, cmap = 'gray')
plt.title('Entrada'), plt.xticks([]), plt.yticks([])
plt.subplot(472),plt.imshow(patches[0], cmap = 'gray')
plt.title('patch 0'), plt.xticks([]), plt.yticks([])
plt.subplot(473),plt.imshow(patches[2], cmap = 'gray')
plt.title('patch 2'), plt.xticks([]), plt.yticks([])
plt.subplot(474),plt.imshow(patches[4], cmap = 'gray')
plt.title('patch 4'), plt.xticks([]), plt.yticks([])
plt.subplot(475),plt.imshow(patches[6], cmap = 'gray')
plt.title('patch 6'), plt.xticks([]), plt.yticks([])
plt.subplot(476),plt.imshow(patches[8], cmap = 'gray')
plt.title('patch 8'), plt.xticks([]), plt.yticks([])
plt.subplot(477),plt.imshow(patches[10], cmap = 'gray')
plt.title('patch 10'), plt.xticks([]), plt.yticks([])

plt.subplot(478),plt.imshow(patches[12], cmap = 'gray')
plt.title('patches 12'), plt.xticks([]), plt.yticks([])
plt.subplot(479),plt.imshow(patches[14], cmap = 'gray')
plt.title('patch 14'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,10),plt.imshow(patches[16], cmap = 'gray')
plt.title('patch 16'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,11),plt.imshow(patches[18], cmap = 'gray')
plt.title('patch 18'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,12),plt.imshow(patches[20], cmap = 'gray')
plt.title('patch 20'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,13),plt.imshow(patches[22], cmap = 'gray')
plt.title('patch 22'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,14),plt.imshow(patches[24], cmap = 'gray')
plt.title('patch 24'), plt.xticks([]), plt.yticks([])

plt.subplot(4,7,15),plt.imshow(patches[26], cmap = 'gray')
plt.title('patches 26'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,16),plt.imshow(patches[28], cmap = 'gray')
plt.title('patch 28'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,17),plt.imshow(patches[30], cmap = 'gray')
plt.title('patch 30'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,18),plt.imshow(patches[32], cmap = 'gray')
plt.title('patch 32'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,19),plt.imshow(patches[34], cmap = 'gray')
plt.title('patch 34'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,20),plt.imshow(patches[36], cmap = 'gray')
plt.title('patch 36'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,21),plt.imshow(patches[38], cmap = 'gray')
plt.title('patch 38'), plt.xticks([]), plt.yticks([])

plt.subplot(4,7,22),plt.imshow(patches[40], cmap = 'gray')
plt.title('patches 26'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,23),plt.imshow(patches[42], cmap = 'gray')
plt.title('patch 28'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,24),plt.imshow(patches[44], cmap = 'gray')
plt.title('patch 30'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,25),plt.imshow(patches[46], cmap = 'gray')
plt.title('patch 32'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,26),plt.imshow(patches[48], cmap = 'gray')
plt.title('patch 34'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,27),plt.imshow(patches[50], cmap = 'gray')
plt.title('patch 36'), plt.xticks([]), plt.yticks([])
plt.subplot(4,7,28),plt.imshow(patches[52], cmap = 'gray')
plt.title('patch 38'), plt.xticks([]), plt.yticks([])

g1.show()
plt.pause(10)



