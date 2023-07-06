import numpy as np
from PIL import Image

def laplaciano(imagem_array, kernel):
    imagem_resultante = np.zeros_like(imagem_array)
    for i in range(1, imagem_array.shape[0] - 1):
        for j in range(1, imagem_array.shape[1] - 1):
            vizinhos = imagem_array[i-1:i+2, j-1:j+2]
            valor = np.sum(vizinhos * kernel)
            imagem_resultante[i, j] = valor
    return imagem_resultante

def agucamento_laplaciano_a(imagem):
    # Converte a imagem para uma matriz
    imagem_array = np.array(imagem, dtype=np.float32)

    # Kernel_a do operador Laplaciano
    kernel = np.array([[0, 1, 0],
                       [1, -4, 1],
                       [0, 1, 0]])

    # Aplicar o operador Laplaciano
    imagem_resultante = laplaciano(imagem_array,kernel)

    # Adicionar a imagem original à imagem resultante para obter o efeito de aguçamento
    imagem_agucada = np.clip(imagem_array + imagem_resultante, 0, 255).astype(np.uint8)

    # Converter a matriz NumPy de volta para imagem PIL
    imagem_agucada = Image.fromarray(imagem_agucada)

    return imagem_agucada

def agucamento_laplaciano_b(imagem):
    # Converte a imagem para uma matriz
    imagem_array = np.array(imagem, dtype=np.float32)
    
    # Kernel_b do operador Laplaciano
    kernel = np.array([[1, 1, 1],
                       [1, -8, 1],
                       [1, 1, 1]])

    # Aplicar o operador Laplaciano
    imagem_resultante = laplaciano(imagem_array,kernel)

    # Adicionar a imagem original à imagem resultante para obter o efeito de aguçamento
    imagem_agucada = np.clip(imagem_array + imagem_resultante, 0, 255).astype(np.uint8)

    # Converter a matriz NumPy de volta para imagem PIL
    imagem_agucada = Image.fromarray(imagem_agucada)

    return imagem_agucada

# Exemplo
imagem_original = Image.open('imagens/11_test.png').convert('L')

imagem_agucada_a = agucamento_laplaciano_a(imagem_original)
imagem_agucada_b = agucamento_laplaciano_b(imagem_original)

# Mostra as imagens com filtro
imagem_agucada_a.show()
imagem_agucada_b.show()