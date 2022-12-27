# para intalar o numpy digite no cmd: python -m pip install numpy
import numpy as np
import math
import random

def prod(lst):
    p = 1
    for i in lst:
        p *= i
    return p

def finite_diffs(xs, ordem, x0, f):
    A = []
    B = []
    n = len(xs)
    for i in range(n):
        # para construir a matriz A
        A.append([0] * n)
        for j in range(n):
            A[i][j] = xs[j] ** i
        # para construir a matriz B
        potencias = [k+1 for k in range(i-ordem, i)]
        fatorial = 0 if i < ordem else prod(potencias)
        termo = fatorial * x0 ** (i-ordem)
        B.append(termo)
    A = np.array(A, dtype='float')
    B = np.array(B, dtype='float')
    cs = np.linalg.solve(A,B)
    # construir a soma que dá a aproximação
    # f^k(x0) ~ c0 * f(x0) + c1 + f(x1) + ... + cn + f(xn)
    soma = 0
    for ck,xk in zip(cs, xs):
        soma += ck*f(xk)
    return soma


if __name__ == '__main__':
    def f(x):
        # a função f(x)=x^x
        # return pow(x,2) * math.exp(-x) * math.cos(x) + 1
        #return pow(math.cos(x),3) + 2 * pow(math.cos(x),2) + 1
        #return math.exp(-pow(x,2)) + math.cos(x) + 3
        #return math.sqrt(math.cos(pow(x,2)) + x)
        #return math.exp(pow(math.cos(x),2)) + math.exp(-pow(x,2)) + math.log(x)
        #return math.cos(x + math.sqrt(math.log(pow(x,2))))
        #return math.cos(math.sin(math.log(pow(x,2))))
        return pow(math.e,pow(math.cos(x),2)) + pow(math.e,(-pow(x,2))) + math.log(x)

    xs = [5.1555091, 5.4055091, 5.6555091, 5.9055091, 6.1555091, 6.4055091, 6.6555091, 6.9055091]
    x0 = 6.1555091
    ordem = 2

    '''# pontos para construir a fórmula (usa numeros aleatorios para construir a lista de pontos, será usado caso não seja dada a lista de pontos)
    num_pontos = 7 #sempre maior que a ordem
    a = x0 - 0.25
    b = x0 + 0.25
    xs = [a + (b-a) * random.random() for _ in range(num_pontos)]
    xs.sort()'''

    r = finite_diffs(xs, ordem, x0, f)

    print(xs)
    print(f'aproximação para a derivada de ordem {ordem} de f no ponto {x0} = ', r)