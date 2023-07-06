import numpy as np
from PIL import Image
from skimage.morphology import binary_dilation, binary_erosion

# Criando a imagem binária W com 4 e 5 em uma matriz de 11 linhas por 8 colunas
W = np.array([[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
              [0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0],
              [0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0],
              [0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0],
              [0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0],
              [0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0],
              [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
              [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]])

# Exibindo a imagem W
image_w = Image.fromarray(W * 255)
image_w.show()

# Determinando o elemento estruturante B
B = np.array([[0, 1, 0],
              [1, 1, 0],
              [0, 1, 0]])

# Obtendo X0 através da operação de erosão entre W e B
X0 = binary_erosion(W, B)

# Exibindo X0
image_x0 = Image.fromarray(X0)
image_x0.show()

# Inicializando Xk como X0
Xk = X0

# Aplicando a operação de dilatação
prev_Xk = None
for i in range (4):
    prev_Xk = Xk
    Xk = np.logical_and(binary_dilation(Xk, B), W)

# Exibindo o X final contendo apenas o 4
image_x_final = Image.fromarray(Xk)
image_x_final.show()