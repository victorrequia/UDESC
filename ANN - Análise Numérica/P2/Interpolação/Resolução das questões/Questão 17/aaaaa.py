# método das diferenças divididas  (de Newton)
import matplotlib.pyplot as plt
import numpy as np
import math

# (1,2), (2,5), (3,1), (4,3)
x = x = [-0.47, -0.079, 0.113, 0.582, 0.894, 1.04, 1.401]
y = []


def func(x):
    return pow(x,5) - 4*pow(x,2) + 2 * math.sqrt(x+1) + math.cos(x)

for i in range(len(x)):
    y += [func(x[i])]

def divided_difference(x, y):
    Y = [item for item in y] # vai mudando a cada iteração
    n = len(y)
    coeffs = [y[0]] + [0] * (n - 1)
    for i in range(n-1):
        for j in range(n - 1 - i):
            numer = Y[j+1] - Y[j]
            denom = x[j+1+i] - x[j]
            Y[j] = numer/denom
        coeffs[i+1] = Y[0]
    
    return coeffs

def eq(x, coeffs):
    """
    Constrói uma equação do tipo
    a0 + a1*(x - x1) + a2*(x - x1)*(x - x2) + a3*(x - x1)*(x - x2)*(x - x3)
    """
    n = len(x)
    equation = ''
    for i in range(n):
        sign = ''
        if i != 0:
            sign = "*"
        equation += f'{coeffs[i]:+}{sign}' + '*'.join([f'(x{-xj:+})' for j, xj in enumerate(x) if j < i])
    
    return equation

coeffs = divided_difference(x,y)
print(coeffs)
poly = eq(x, coeffs)
print('p(x) =', poly)

t = np.linspace(min(x), max(x))
def p(x):
    return eval(poly)

plt.plot(t, p(t))
plt.scatter(x,y, zorder = 10)
plt.savefig("diff_div.png")