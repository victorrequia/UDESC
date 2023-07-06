import cv2
import numpy as np

def operador_media(imagem):
    # Núcleo da média
    nucleo = np.ones((3, 3)) / 9 # [[1/9, 1/9, 1/9], [1/9, 1/9, 1/9], [1/9, 1/9, 1/9]]

    # Altura e largura da imagem
    height, width = imagem.shape

    # Auxiliar para armazenar a matriz de saída
    imagem_saida = np.zeros((height, width), dtype=np.uint8)

    for i in range(1, height - 1):
        for j in range(1, width - 1):
            vizinhos = imagem[i-1:i+2, j-1:j+2]
            media = np.sum(vizinhos * nucleo)
            imagem_saida[i, j] = media
    return imagem_saida

imagem_entrada = cv2.imread('imagens/Lua1_gray.jpg', cv2.IMREAD_GRAYSCALE)

imagem_saida = operador_media(imagem_entrada)

cv2.imshow('Media', imagem_saida)
cv2.waitKey(0)
cv2.destroyAllWindows()
