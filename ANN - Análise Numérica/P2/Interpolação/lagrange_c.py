import math

def lagrange(x, y):
    # a equação do polinomio de lagrange
    n = len(x)
    if n == len(y):
        c = ''
        for k in range(n):
            denom = '*'.join([f'({x[k]}{-xi:+})' for i, xi in enumerate(x) if i != k])
            c += f'{y[k]:+}/({denom})'
        return c
    else:
        raise TypeError('O número de coordenadas de x é diferente do número de coordenadas de y')

if __name__ == '__main__':
    x = [1.12, 1.584, 3.43] # coordenadas x dos pontos
    y = [1.546, 1.947, 0.61] # coordenadas y dos pontos
    
    eq = lagrange(x,y)

    print('c =',eq)