#método da diferença dividida (de newton)
import matplotlib.pyplot as plt
import numpy as np

x = [1.12, 1.584, 3.43]
y = [1.546, 1.947, 0.61]
def divided_differences(x,y):
    Y = [item for item in y] #vai mudando a cada iteração
    n = len(y)
    coeffs = [y[0]] + [0] * (n-1)
    for i in range(n-1):
        for j in range(n-1-i):
            numer = Y[j+1] - Y[j]
            denom = x[j+1+i] - x[j]
            Y[j] = numer/denom
        coeffs[i+1] = Y[0]
    return coeffs

def eq(x, coeffs):
    """
    Constrói uma equação do tipo
    #p(x) = a0 + a1*(x-x2) + a2*(x-x1)*(x-x2) + a3*(x-x1)*(x-x2)*(x-x3)...
    """
    n = len(x)
    equation = ''
    for i in range(n):
        sign = ''
        if i != 0:
            sign = '*'
        equation += f'{coeffs[i]:+}{sign}' + '*'.join([f'(x{-xj:+})' for j, xj in enumerate(x) if j < i])
    return equation

coeffs = divided_differences(x,y)
print(coeffs)
poly = eq(x,coeffs)
print('p(x) = ' + poly)
print(f"f({0.678}) = {coeffs[0]+coeffs[1]*0.678+coeffs[2]*(0.678*0.678)}")

t = np.linspace(min(x), max(x), 100)
def p(x):
    return eval(poly)
plt.plot(t, p(t))
plt.scatter(x,y, zorder=10)
plt.savefig('diff_div.png')