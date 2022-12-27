import math
import numpy as np

# precisamos encontrar uma função da forma g = c1*f1 + c2*f2 + ... + cn*fn
# supondo que temos n funções 

def trapz(f, a, b, n):
    h = (b - a) / n
    soma = 0
    for k in range(1, n):
        soma += f(a + k * h)
    return (h/2)* (f(a) + 2*soma + f(b))

def best_func(f, a, b, fs, *,intervalos=100):
    n = len(fs)
    A = [[0]*n for _ in range(n)]
    B = []
    for i in range(n):
        for j in range(n):
            if i >= j:
                # integral de fj * fi em [a, b]
                def f_ij(x):
                    return fs[j](x) * fs[i](x)
                a_ij = trapz(f_ij, a, b, intervalos)
                A[i][j] = a_ij
            else:
                A[i][j] = A[j][i]
        def ff_i(x):
            return f(x) * fs[i](x)
        b_i = trapz(ff_i, a, b, intervalos)
        B.append(b_i)
    coeffs = np.linalg.solve(A, B)    
    return coeffs

#definindo as funções 
def f(x):
    return 2*math.sin(x)+math.cos(-x**2)+4

a, b = [-1.009,1.484]

def f1(x):
    return x**2
def f2(x):
    return math.cos(3*x)


fs = [f1,f2] # lisat contendo as funções

coeffs = best_func(f, a, b, fs, intervalos=128)
print(coeffs)

def g(x):
    soma = 0
    for c_k, f_k in zip(coeffs, fs):
        soma += c_k * f_k(x)
    return soma