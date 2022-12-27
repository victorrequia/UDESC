import math

def lagrange(x, y):
    # a equação do polinomio de lagrange
    n = len(x)
    if n == len(y):
        eq = ''
        for k in range(n):
            numer = '*'.join([f'(x{-xi:+})' for i, xi in enumerate(x) if i != k])
            denom = '*'.join([f'({x[k]}{-xi:+})' for i, xi in enumerate(x) if i != k])
            eq += f'{y[k]:+}*({numer})/({denom})'
        return eq
    else:
        raise TypeError('O número de coordenadas de x é diferente do número de coordenadas de y')

if __name__ == '__main__':
    x = [0.671, 2.031, 2.851] # coordenadas x dos pontos
    y = [1.027, 1.881, 0.203] # coordenadas y dos pontos
    
    eq = lagrange(x,y)

    def subs(x):
        return eval(eq)

    print('p(x) =',eq)
    #print(subs(1), subs(2), subs(3))

    def f(x):
        return math.cos(x+math.sqrt(math.log(pow(x,2))))

    num = 5
    x2 = [2.646, 4.453]
    y2 = [f(i) for i in x2]
    print(x2)
    print(y2)

    #vamos plotar os gráficos
    from matplotlib import pyplot as plt
    import numpy as np

    t = np.linspace(1,3,100)

    plt.plot(t, subs(t))
    plt.scatter(x,y)

    plt.savefig('lagrange3.png')