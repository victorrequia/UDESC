#algoritmo spline cúbico
import matplotlib.pyplot as plt
import numpy as np
import math

def spline(x, y):
    """
    retorna todos os coeficientes de todos os polinômios
    ou seja,todos os ak, bk, ck, dk
    """
    n = len(x)
    a = {k: v for k, v, in enumerate(y)}
    h = {k: x[k+1] - x[k] for k in range(n - 1)}

    A = [[1] + [0] * (n - 1)]
    for i in range(1, n-1):
        row = [0] * n
        row[i - 1] = h[i - 1]
        row[i] = 2*(h[i-1] + h[i])
        row[i + 1] = h[i]
        A.append(row)    
    A.append([0] * (n-1) + [1])

    B = [0]
    for k in range(1, n - 1):
        row = 3 * (a[k+1] - a[k]) / h[k] - 3 * ((a[k] - a[k-1])) / h[k-1]
        B.append(row)
    B.append(0)
    
    c = dict(zip(range(n), np.linalg.solve(A, B)))
    
    b = {}
    d = {}
    for k in range(n-1):
        b[k] = (1/h[k]) * (a[k+1] - a[k]) - (h[k]/3) * (2*c[k]+c[k+1])
        d[k] = (c[k+1] - c[k]) / (3*h[k])
    
    s = {}
    for k in range(n - 1):
        eq = f'{a[k]}{b[k]:+}*(x-{x[k]}){c[k]:+}*(x-{x[k]})**2{d[k]:+}*(x-{x[k]})**3'
        #s[k] = {'eq': eq, 'domain': [x[k], x[k+1]]}
        s[k] = eq

    return s
        
# (1,2), (2,4), (4,2), (5,2)
x = [0.109, 1.149, 2.346, 3.189, 3.671, 4.776, 5.651, 6.514]
y = [4.982, 3.676, 2.304, 2.001, 2.137, 3.064, 3.807, 3.973]
valores = [0.73, 1.663, 4.116]

""""

def func(x):
    return pow(2.71828182846, -x**2) + math.cos(x) + 3

for i in range(len(x)):
    y += [func(x[i])]

"""

eqs = spline(x, y)

"""

for i in eqs:
    print(eqs[i])

"""

for i in range(len(valores)):
    for j in range(len(x)-1):
        eq = eqs[j]
        def abs(x):
            return eval(eq)
        
        if(valores[i] >= x[j] and valores[i] <= x[j+1]):
            print(abs(valores[i]))