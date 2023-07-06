# Lucas Dallabeneta e Victor Eduardo Requia
# Processamento de imagens  09/05/2023

from skimage import io, color
import math

import numpy as np
from matplotlib import pyplot as plt
from PIL import Image

'''calcula a média dos valores de intensidade de pixels em uma imagem'''
def media(img: Image):
    soma = sum(img.getpixel((x, y)) for x in range(img.size[0]) for y in range(img.size[1]))
    return soma / (img.size[0] * img.size[1])

'''calcula a variância dos valores de intensidade de pixels em uma imagem'''
def variancia(img: Image):
    m = media(img)
    soma = sum((img.getpixel((x, y)) - m) ** 2 for x in range(img.size[0]) for y in range(img.size[1]))
    return soma / (img.size[0] * img.size[1])

'''calcula a entropia de uma imagem'''
def entropia(img: Image):
    frequencias = histograma(img)
    tam = math.prod(img.size)
    ent = 0
    for n in frequencias:
        if n == 0:
            continue
        p = n / tam
        ent += p * math.log2(p)
    return -ent

'''define um conjunto de pixels vizinhos a um pixel de coordenadas (x, y) 
   dentro de uma janela quadrada de tamanho n.'''
def vizinhos(x:int,y:int,n:int):
	assert(n%2==1 and n > 3)
	n = int((n-1)/2)
	return {f'{i}:{j}':(x + i, y + j) for i in range(-n,n+1) for j in range(-n,n+1)}

'''calcula o histograma de intensidades de pixels em uma imagem'''
def histograma(img:Image):
    vet = [0 for x in range(256)]
    for x in range(img.size[0]):
        for y in range(img.size[1]):
            vet[img.getpixel((x,y))] += 1
    return vet

'''equaliza o histograma de uma imagem globalmente,
   sem distinção de regiões na imagem'''
def equalizacaoGlobal(img:Image):
    hist = histograma(img)
    tam = img.size[0] * img.size[1]
    prob = [0 for _ in range(256)]
    map = [0 for _ in range(256)]
    prob[0] = hist[0]/tam
    map[0] = int(prob[0] * 256)
    for i in range(1,256):
        prob[i] = prob[i - 1] + hist[i] / tam
        map[i] = int(prob[i] * 256)
    c = Image.new('L', img.size)
    for x in range(img.size[0]):
        for y in range(img.size[1]):
            c.putpixel((x, y), map[img.getpixel((x, y))])
    return c

'''equaliza o histograma de uma imagem localmente
   considerando apenas uma vizinhança de pixels em cada ponto da imagem.'''
def equalizacaoLocal(img:Image):
    c = Image.new('L', img.size)
    for x in range(img.size[0]):
        for y in range(img.size[1]):
            v = []
            for i, j in vizinhos(x,y,15).values():
                try:
                    v.append(img.getpixel((i,j)))
                except:
                    continue
            hist = [0 for _ in range(256)]
            for x in v:
                hist[x] += 1
            tam = len(v)
            prob = [0 for _ in range(256)]
            map = [0 for _ in range(256)]
            prob[0] = hist[0]/tam
            map[0] = int(prob[0] * 256)
            for i in range(1,256):
                prob[i] = prob[i - 1] + hist[i] / tam
                map[i] = int(prob[i] * 256)
            c.putpixel((x, y), map[img.getpixel((x, y))])
    return c

'''equaliza o histograma de uma imagem localmente,
   mas considerando um intervalo de valores menor, 
   limitado pelos valores mínimo e máximo encontrados 
   em uma janela de vizinhança de pixels em cada ponto da imagem.'''
def equalizacaoLocalAjustada(img:Image):
    c = Image.new('L', img.size)
    for x in range(img.size[0]):
        for y in range(img.size[1]):
            v = []
            for i, j in vizinhos(x,y,15).values():
                try:
                    v.append(img.getpixel((i,j)))
                except:
                    continue
            tam = len(v)
            v.append(img.getpixel((x,y)))
            ran = len(set(v))
            mx = max(v)
            mn = min(v)
            e = 0.00000001
            hist = [0 for _ in range(ran)]
            for m in v:
                hist[int((m-mn)/(mx-mn+e))] += 1
            prob = [0 for _ in range(ran)]
            map = [0 for _ in range(ran)]
            prob[0] = hist[0]/tam
            map[0] = int(prob[0] * ran)
            for i in range(1,ran):
                prob[i] = prob[i-1] + hist[i] / tam
                map[i] = int(prob[i] * (mx-mn))
            c.putpixel((x, y), map[int((img.getpixel((x, y))-mn)/(mx-mn+e))])
    return c

'''converte uma imagem de formato RGB para YIQ'''
def yiq(img_rgb:Image):
    c = Image.new(img_rgb.mode, img_rgb.size)
    for x in range(img_rgb.size[0]):
        for y in range(img_rgb.size[1]):
            r, g, b = img_rgb.getpixel((x,y))
            yy = 0.299 * r + 0.587 * g + 0.114 * b
            i = 0.596 * r - 0.275 * g - 0.321 * b
            q = 0.212 * r - 0.523 * g + 0.311 * b
            c.putpixel((x,y),(int(yy),int(i),int(q)))
    return c

'''converte uma imagem de formato YIQ para RGB'''
def rgb(img_yiq:Image):
    c = Image.new(img_yiq.mode, img_yiq.size)
    for x in range(img_yiq.size[0]):
        for y in range(img_yiq.size[1]):
            yy, i, q = img_yiq.getpixel((x,y))
            r = yy + 0.956 * i + 0.62 * q
            g = yy - 0.272 * i - 0.647 * q
            b = yy - 1.108 * i + 1.705 * q
            c.putpixel((x,y),(int(r),int(g),int(b)))
    return c

if __name__ == '__main__':
    # Carrega a imagem RGB
    img = io.imread('predios.jpeg')

    # Converte a imagem para o espaço de cor YIQ
    img_yiq = color.rgb2yiq(img)

    # Extrai o canal Y da imagem YIQ
    y = img_yiq[:,:,0]

    # Calcula o histograma do canal Y
    hist, bins = np.histogram(y, bins=256, range=(0,1))

    # Normaliza o histograma para que a área total seja 1
    hist_norm = hist / float(np.sum(hist))

    # Plota o histograma
    plt.plot(bins[:-1], hist_norm)
    plt.title('Histograma do canal Y na imagem RGB')
    plt.xlabel('Valor do canal Y')
    plt.ylabel('Frequência normalizada')
    plt.show()

    # Converte a imagem de volta para o espaço de cor RGB
    img_rgb = color.yiq2rgb(img_yiq)

    # Exibe a imagem e o histograma lado a lado
    fig, axs = plt.subplots(1, 2, figsize=(10, 5))
    axs[0].imshow(img_rgb)
    axs[0].set_title('Imagem YIQ')
    axs[0].axis('off')
    axs[1].plot(bins[:-1], hist_norm)
    axs[1].set_title('Histograma do canal Y')
    axs[1].set_xlabel('Valor do canal Y')
    axs[1].set_ylabel('Frequência normalizada')
    plt.show()