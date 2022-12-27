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
    x = [-0.773, -0.459, 0.046, 0.337, 0.662] # coordenadas x dos pontos
    y = [2.3915772359968437, 3.3279285288539175, 3.9926008994953994, 3.6218980261101645, 2.735027853480201] # coordenadas y dos pontos
    
    eq = lagrange(x,y)

    print('c =',eq)