# Lucas Dallabeneta e Victor Requia     17/04/2023
# Prova 1 - Processamento de Imagens

import math
import numpy as np

# Pontos no espaço 3D
x = [0, 600, 1000, 1000, 1000, 1000]
y = [1000, 1000, 800, 400, 1000, 800]
z = [200, 400, 400, 600, 600, 0]

# Pontos na imagem
xp = [5, 3, 2, 1, 2, 2]
yp = [3, 4, 4, 2, 3, 5]

# Criar a matriz de coeficientes para o sistema de equações
A = []
for i in range(6):
    A.append([x[i], y[i], z[i], 1, 0, 0, 0, 0, -xp[i]*x[i], -xp[i]*y[i], -xp[i]*z[i]])
    A.append([0, 0, 0, 0, x[i], y[i], z[i], 1, -yp[i]*x[i], -yp[i]*y[i], -yp[i]*z[i]])

# Printando a matriz de calibração
print("Matriz de calibração:")
print(np.array(A))

# Removendo a última linha da matriz de calibração
A = A[:-1]

# Matriz dos resultados
r = []
for i in range(6):
    r.extend([xp[i], yp[i]])

# Removendo o último elemento da matriz de resultados
r = r[:-1]

# a11 até a34
matriz = np.linalg.solve(A, r)
matriz_projecao = np.zeros((3, 4))

# Criar a matriz de projeção 3x4
matriz_projecao[:2, :] = matriz[:8].reshape(2, 4)
matriz_projecao[2, :3] = matriz[8:11]
matriz_projecao[2, 3] = 1

# Projetar pontos no espaço 3D na imagem
proj = np.matmul(matriz_projecao, np.vstack((x, y, z, np.ones((1, 6))))).T

# Coordenadas projetadas
xc = np.round(proj[:, 0] / proj[:, 2])
yc = np.round(proj[:, 1] / proj[:, 2])

# Print dos pontos
print("\nCoordenadas no 2d e 3d")
for i in range(6):
    print(f"({xp[i]}, {yp[i]}) -> ({xc[i]}, {yc[i]})")

# # Calcular a distância das coordenadas x e y dos pontos na imagem projetados (acurácia)
def distancia2d(x1, y1, x2, y2):
    a = x2 - x1
    b = y2 - y1
    c = math.sqrt(a**2 + b**2)
    return c

# Calculando a acurácia
acuracia = 0
for i in range(6):
    acuracia += distancia2d(xp[i], xc[i], yp[i], yc[i])/6
acuracia = acuracia/6

print("\nAcurácia: ", acuracia)