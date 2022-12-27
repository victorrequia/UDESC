import math

def lagrange(x, y):
    # a equação do polinomio de lagrange
    n = len(x)
    if n == len(y):
        c = ''
        for k in range(n):
            numer = '*'.join([f'(x{-xi:+})' for i, xi in enumerate(x) if i != k])
            denom = '*'.join([f'({x[k]}{-xi:+})' for i, xi in enumerate(x) if i != k])
            c += f'{y[k]:+}/({denom})'
        return c
    else:
        raise TypeError('O número de coordenadas de x é diferente do número de coordenadas de y')

if __name__ == '__main__':
    x = [-1.081, 1.155, 3.097, 4.21, 5.91] # coordenadas x dos pontos
    y = [0.875, 0.855, -0.414, -0.99, -0.113] # coordenadas y dos pontos
    
    eq = lagrange(x,y)

    print('c =',eq)