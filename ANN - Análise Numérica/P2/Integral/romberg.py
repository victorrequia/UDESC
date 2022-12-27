# o método de integração de Romberg é o método de extrapolação de Richardson aplicado sobre a regra dos trapézios
import math


def romberg(col1):
    col1 = [item for item in col1]  # cópia da coluna 1
    n = len(col1)
    for j in range(n-1):
        temp_col = [0] * (n - 1 - j)
        for i in range(n - 1 - j):
            power = j + 1 # é igual ao numero da coluna anterior
            temp_col[i] = (4 ** power * col1[i + 1] - col1[i]) / (4 ** power - 1)
        col1[:n - 1 - j] = temp_col
        print(f'F_{j+2}',temp_col)
    return col1[0] # a aproximação procurada

'''def trapz(f, a, b, h):
    # é um método ruim para aproximar integrais
    n = int((b - a) / h)
    soma = 0
    for k in range(1, n):
        soma += f(a + k * h)
    return (h/2) * (f(a) + 2 * soma + f(b))'''

##############################
#def f(x):
 #   return math.sqrt(1+pow(math.cos(x),2))
    

#a, b = [-1.352, -0.352]
#h = 1.0
#k = 6 # h/2  h/4 h/8 h/16 # Oh = 2 * k ou seja, para oh10, usamos k = 5
#hs = [h / 2 ** i for i in range(k)]
#col1 = [trapz(f, a, b, hi) for hi in hs]
#print('F_1', col1)
# encontre uma aproximação O(h^10)
r = romberg([2.9949213473310774,3.543939050194472,3.588126224126026,3.5948626807928563,3.596453658201941])
