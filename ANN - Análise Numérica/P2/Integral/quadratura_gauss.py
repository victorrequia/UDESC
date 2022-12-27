import math

#Coordenadas x e Pesos c para Quadratura Gaussiana
# O primeiro valor e a coordenada x e o segundo valor eh o peso

pontos = (-0.33998104358485626, 0.33998104358485626, -0.8611363115940526, 0.8611363115940526)
pesos = (0.6521451548625461, 0.6521451548625461, 0.34785484513745385, 0.34785484513745385)
pontos_e_pesos = zip(pontos, pesos)
a,b = [-1.32, 0.92]

def f(x):
    return x

def quadratura(f,pontos_e_pesos):
    soma = 0
    for x_k,c_k in pontos_e_pesos:
        soma += c_k * f(x_k)
    return soma

def change(f,a,b,u):
    return f( (b+a)/2 + (b-a)*u/2) * (b-a) / 2

def g(u):
    return change(f,a,b,u)

r = quadratura(g,pontos_e_pesos)
print(r)