import math

def trapz(f, a, b, n):
    #é um método ruim para aproximar integrais
    h = (b - a) / n
    soma = 0
    for k in range(1, n):
        soma += f(a + k * h)
    soma *=  2
    soma += (f(a) + f(b))
    return (h/2) * soma

def soma_trapx(x,y):
    soma = 0
    for i in range(len(x)-1):
        resultado_formula = ((x[i+1]-x[i])*(y[i] + y[i+1]))/2
        soma += resultado_formula
    return soma

x = [0.571, 0.832, 0.864, 0.984, 1.101, 1.382, 1.494, 1.914, 2.454, 2.872, 3.001, 3.29, 3.698, 3.755, 3.854, 3.871, 4.162, 4.289, 4.553, 4.692, 4.956]
y = [2.891, 2.979, 2.961, 2.858, 2.723, 2.373, 2.253, 2.007, 2.205, 2.689, 2.843, 2.996, 2.256, 2.062, 1.709, 1.649, 1.001, 1.136, 2.232, 2.821, 2.634]

resultado_final = soma_trapx(x, y)
print(resultado_final)