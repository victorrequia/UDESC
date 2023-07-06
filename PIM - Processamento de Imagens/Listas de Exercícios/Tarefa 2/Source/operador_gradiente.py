import cv2
import np as np
from PIL import Image

def mediana(list:list):
    list = sorted(list)
    n = len(list)
    if n % 2 == 0:
        return (int(list[n//2])+int(list[int(n//2)-1]))//2
    return list[n//2]

def matriz_aceita(x, y, size):
    return x >= 0 and y >= 0 and x < size[1] and y < size[0]

def passa_baixa(img, tamanho:tuple):
    for x in range(tamanho[1]):
        for y in range(tamanho[0]):
            vizinhos = []
            for i in range(-1,2):
                for j in range(-1,2):
                    if matriz_aceita(x+i, y+j, tamanho):
                        vizinhos.append(img[x+i][y+j])
            img[x][y] = mediana(vizinhos)
    return img

def sobel_filter(image, x, y):
    # Converter a imagem em um array np
    gray_array = np.array(image, dtype=np.float32)

    # Aplicar o filtro Sobel nas direções x e y
    gradient_x = convolucao(gray_array, x)
    gradient_y = convolucao(gray_array, y)

    # Calcular a magnitude do gradiente
    magnitude = np.sqrt(gradient_x**2 + gradient_y**2)

    # Normalizar a magnitude para o intervalo [0, 255]
    magnitude *= 255.0 / np.max(magnitude)

    # Converter a magnitude para o tipo de dado uint8
    magnitude = magnitude.astype(np.uint8)

    # Criar uma nova imagem PIL a partir do array da magnitude
    filtered_image = Image.fromarray(magnitude)

    return filtered_image

def convolucao(image, kernel):
    height, width = image.shape
    kernel_size = kernel.shape[0]
    padding = kernel_size // 2

    # Adicionar padding à imagem
    padded_image = np.pad(image, padding, mode='edge')

    # Criar uma matriz vazia para armazenar o resultado da convolução
    result = np.zeros_like(image)

    # Aplicar a convolução
    for i in range(height):
        for j in range(width):
            patch = padded_image[i:i+kernel_size, j:j+kernel_size]
            result[i, j] = np.sum(patch * kernel)

    return result

def operadores(type:int):
    if type == 0: # Sobel
        OX = np.array([
            [-1, 0, 1],
            [-2, 0, 2],
            [-1, 0, 1]
        ])
        OY = np.array([
            [-1, -2, -1],
            [0, 0, 0],
            [1, 2, 1]
        ])
    elif type == 1: # Prewitt
        OX = np.array([
            [-1, 0, 1],
            [-1, 0, 1],
            [-1, 0, 1]
        ])
        OY = np.array([
            [-1, -1, -1],
            [0, 0, 0],
            [1, 1, 1]
        ])
    else: # Scharr
        OX = np.array([
            [-3, 0, 3],
            [-10, 0, 10],
            [-3, 0, 3]
        ])
        OY = np.array([
            [-3, -10, -3],
            [0, 0, 0],
            [3, 10, 3]
        ])
    return (OX, OY)

# Lua Gray (Sober)
imagem = "imagens/Lua1_gray.jpg"
img = cv2.imread(imagem, 2)
size = (len(img[0]), len(img))
# Aplica passa-baixa
passaBaixa = passa_baixa(img, size)
# Buscando matriz
operadores_x, operadores_y = operadores(0)
# Aplicar o filtro Sobel
filtered_image = sobel_filter(img, operadores_x, operadores_y)
# Mostrar a imagem original e a imagem filtrada
filtered_image.show()

