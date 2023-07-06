import numpy as np
import cv2

def filtro_gaussiano(imagem, sigma):
    tamanho = 3
    nucleo = np.zeros((tamanho, tamanho))

    for i in range(tamanho):
        for j in range(tamanho):
            x = i - tamanho // 2
            y = j - tamanho // 2
            nucleo[i, j] = np.exp(-(x**2 + y**2) / (2 * sigma**2))

    nucleo /= np.sum(nucleo)

    altura, largura = imagem.shape
    imgResult = np.zeros((altura, largura), dtype=np.float32)

    for i in range(1, altura - 1):
        for j in range(1, largura - 1):
            patch = imagem[i - 1:i + 2, j - 1:j + 2]
            valor = np.sum(patch * nucleo)
            imgResult[i, j] = valor

    return imgResult.astype(np.uint8)

img = cv2.imread('imagens/Lua1_gray.jpg', cv2.IMREAD_GRAYSCALE)

imgResult1 = filtro_gaussiano(img, sigma=0.6)
imgResult2 = filtro_gaussiano(img, sigma=1.0)
imgResult3 = filtro_gaussiano(img, sigma=2.0)
imgResult4 = filtro_gaussiano(img, sigma=10.0)

cv2.imshow('sigma = 0.6', imgResult1)
cv2.imshow('sigma = 1.0', imgResult2)
cv2.imshow('sigma = 2.0', imgResult3)
cv2.imshow('sigma = 10.0', imgResult4)
cv2.waitKey(0)
cv2.destroyAllWindows()