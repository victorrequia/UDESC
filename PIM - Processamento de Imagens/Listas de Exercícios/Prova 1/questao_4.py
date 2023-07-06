import numpy as np

# Dados da câmera e da imagem
d = 5e-3   # distância focal em metros
f = np.array([0, 0, 0])   # centro de projeção na origem
pixel_size = 7.5e-6   # tamanho do pixel em metros
sensor_center = np.array([1024, 1024])   # centro do sensor em pixels

# Coordenadas 3D dos pontos identificados
points = np.array([
    [650.7, 2000.0, 1500.0],
    [653.5, 2000.0, 1500.0],
    [650.7, 1990.0, 1500.0],
    [645.3, 500.3, 1500.0],
    [645.0, 500.3, 1500.0],
    [645.3, 500.0, 1500.0]
])

# Matriz de projeção
P = np.array([
    [1, 0, 0, 0],
    [0, 1, 0, 0],
    [0, 0, 1, 0],
    [0, 0, 1/d, 0]
])

# Calcular projeção de cada ponto na imagem
for i in range(points.shape[0]):
    # Adicionar coordenada homogênea
    X = np.append(points[i], 1)
    # Calcular projeção
    x = P.dot(X)
    # Dividir por coordenada z para obter coordenadas em pixels
    x = (x / x[2])[:-1]
    # Converter para coordenadas na imagem
    x = np.round(x / pixel_size + sensor_center).astype(int)
    # Verificar se ponto está dentro da imagem
    if (x[0] >= 0 and x[0] < 2048 and x[1] >= 0 and x[1] < 2048):
        # Marcar ponto na imagem com um quadrado preto
        img[x[1]-1:x[1]+1, x[0]-1:x[0]+1] = 0

# Verificar se reentrâncias estão claramente visíveis na imagem
if np.sum(img == 0) > 10:
    print("As reentrâncias estão claramente visíveis na imagem.")
else:
    print("As reentrâncias não estão claramente visíveis na imagem.")