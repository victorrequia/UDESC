# Lucas Dallabeneta e Victor Requia     17/04/2023
# Prova 1 - Processamento de Imagens

import matplotlib.pylab as plt
import numpy as np

#### Questão 6 ####
# matriz original de 6x6 com valores de 0 até 255
matriz_original = np.array([[10.0, 130.0, 15.0, 110.0, 15.0, 120.0],
                            [215.0, 40.0, 250.0, 30.0, 250.0, 40.0],
                            [15.0, 255.0, 15.0, 255.0, 15.0, 230.0],
                            [210.0, 30.0, 255.0, 45.0, 250.0, 45.0],
                            [10.0, 115.0, 10.0, 110.0, 10.0, 115.0],
                            [110.0, 30.0, 110.0, 35.0, 115.0, 45.0]])

# criar matriz de 8x8 com bordas de zeros
matriz_original_borda = np.zeros((8, 8), dtype=int)
matriz_original_borda[1:7, 1:7] = matriz_original

# Matriz inicial da interpolação
matriz_interpolada = np.zeros((6, 6, 3), dtype=int)

print("Matriz original:")
print(matriz_original)
print("\nMatriz original com borda")
print(matriz_original_borda)

# Algoritmo para fazer a interpolação de Bayer
for i in range(1, 7):
    for j in range(1, 7):
        if (i % 2 == 0 and j % 2 == 0):  # Pixel Azul
            matriz_interpolada[i-1, j-1, 0] = (matriz_original_borda[i-1, j-1] +
                                               matriz_original_borda[i-1, j+1] +
                                               matriz_original_borda[i+1, j-1] +
                                               matriz_original_borda[i+1, j+1]) // 4  # Vizinho Vermelho

            matriz_interpolada[i-1, j-1, 1] = (matriz_original_borda[i-1, j] +
                                               matriz_original_borda[i+1, j] +
                                               matriz_original_borda[i, j-1] +
                                               matriz_original_borda[i, j+1]) // 4  # Vizinho Verde

            matriz_interpolada[i-1, j-1, 2] = matriz_original_borda[i, j]  # Azul

        elif (i % 2 == 1 and j % 2 == 1):  # Pixel Vermelho
            matriz_interpolada[i-1, j-1, 0] = matriz_original_borda[i, j]  # Vermelho

            matriz_interpolada[i-1, j-1, 1] = (matriz_original_borda[i-1, j] +
                                               matriz_original_borda[i+1, j] +
                                               matriz_original_borda[i, j-1] +
                                               matriz_original_borda[i, j+1]) // 4  # Vizinho Verde

            matriz_interpolada[i-1, j-1, 2] = (matriz_original_borda[i-1, j-1] +
                                               matriz_original_borda[i-1, j+1] +
                                               matriz_original_borda[i+1, j-1] +
                                               matriz_original_borda[i+1, j+1]) // 4  # Vizinho Azul

        else:  # Pixel Verde
            matriz_interpolada[i-1, j-1, 1] = matriz_original_borda[i, j]  # Verde
            if i % 2 == 0:
                # Se a linha for par
                matriz_interpolada[i-1, j-1, 0] = (matriz_original_borda[i+1, j] +
                                                   matriz_original_borda[i-1, j]) // 2  # Vizinho Vermelho

                matriz_interpolada[i-1, j-1, 2] = (matriz_original_borda[i, j-1] +
                                                   matriz_original_borda[i, j+1]) // 2  # Vizinho Azul
            else:
                # Se a linha for ímpar
                matriz_interpolada[i-1, j-1, 0] = (matriz_original_borda[i, j+1] +
                                                   matriz_original_borda[i, j-1]) // 2  # Vizinho Vermelho

                matriz_interpolada[i-1, j-1, 2] = (matriz_original_borda[i-1, j] +
                                                   matriz_original_borda[i+1, j]) // 2  # Vizinho Azul

# retornar a matriz interpolada 6x6
print("\nMatriz Interpolada:")
for linha in range(6):
    for coluna in range(6):
        print("[{}][{}] Vermelho:{} Verde:{} Azul:{}".format(linha, coluna, matriz_interpolada[linha, coluna, 0], matriz_interpolada[linha, coluna, 1], matriz_interpolada[linha, coluna, 2]))

matriz_aux = np.zeros((6, 6), dtype=int)
print("\nMatriz Vermelha")
for linha in range(6):
    for coluna in range(6):
        matriz_aux[linha, coluna] = matriz_interpolada[linha, coluna, 0]
print(matriz_aux)

matriz_aux = np.zeros((6, 6), dtype=int)
print("\nMatriz Verde")
for linha in range(6):
    for coluna in range(6):
        matriz_aux[linha, coluna] = matriz_interpolada[linha, coluna, 1]
print(matriz_aux)

matriz_aux = np.zeros((6, 6), dtype=int)
print("\nMatriz Azul")
for linha in range(6):
    for coluna in range(6):
        matriz_aux[linha, coluna] = matriz_interpolada[linha, coluna, 2]
print(matriz_aux)


#### Questão 6 ####
matriz_cinza = np.zeros((6, 6, 3), dtype=int)

for linha in range(6):
    for coluna in range(6):
        cinza = matriz_interpolada[linha, coluna, 0] * 0.3 + matriz_interpolada[linha, coluna, 1] * 0.59 + matriz_interpolada[linha, coluna, 2]*0.11
        matriz_cinza[linha, coluna, 0] = cinza
        matriz_cinza[linha, coluna, 1] = cinza
        matriz_cinza[linha, coluna, 2] = cinza

print("Escala em cinza")
print(matriz_cinza)

matriz_limiar = np.zeros((6, 6, 3), dtype=int)
limiar = 100  # valor inicial do limiar

# Loop até que o valor de limiar pare de mudar
while True:
    # Separa a imagem em duas classes usando o limiar atual
    classe1 = matriz_cinza[matriz_cinza <= limiar]
    classe2 = matriz_cinza[matriz_cinza > limiar]

    # Calcula as médias das intensidades de pixels de cada classe
    media1 = np.mean(classe1)
    media2 = np.mean(classe2)

    # Atualiza o limiar
    novo_limiar = (media1 + media2) / 2

    # Verifica se o limiar mudou menos que um limite de tolerância
    if abs(novo_limiar - limiar) < 0.5:
        break

    limiar = novo_limiar

# Exibe o valor final de limiar
print("\nLimiar final:", int(limiar))

for linha in range(6):
    for coluna in range(6):
        if matriz_cinza[linha, coluna, 0] >= 0 and matriz_cinza[linha, coluna, 0] <= limiar:
            matriz_limiar[linha, coluna, 0] = 0
            matriz_limiar[linha, coluna, 1] = 0
            matriz_limiar[linha, coluna, 2] = 0
        else:
            matriz_limiar[linha, coluna, 0] = 255
            matriz_limiar[linha, coluna, 1] = 255
            matriz_limiar[linha, coluna, 2] = 255

print("\nMatriz Limiar")
print(matriz_limiar)

# Montar as figuras das matrizes
fig, axs = plt.subplots(1, 4, figsize=(13, 5))
axs[0].set_title('Matriz Original')
axs[0].imshow(matriz_original)
axs[1].set_title('Matriz Interpolada')
axs[1].imshow(matriz_interpolada)
axs[2].set_title('Matriz Cinza')
axs[2].imshow(matriz_cinza)
axs[3].set_title('Matriz Limiar')
axs[3].imshow(matriz_limiar)
plt.show()
