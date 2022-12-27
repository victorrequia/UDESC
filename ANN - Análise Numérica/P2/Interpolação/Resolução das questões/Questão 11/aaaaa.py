import math

def lagrange(x, y):
    # eq polinomio lagrange
    n = len(x)
    if n == len(y):
        eq = ''
        for k in range(n):
            numer = '*'.join([f'(x{-xi:+})' for i, xi in enumerate(x) if i != k])
            denom = '*'.join([f'({x[k]}{-xi:+})' for i, xi in enumerate(x) if i != k])
            eq += f'{y[k]:+}*({numer})/({denom})'
            #eq += f'{y[k]:+}*({denom})'
        return eq
    else:
        raise TypeError('O numero de coordenadas x é diferente'
                        'do numero de coordenadas y')

def denom_lagrange(x, y):
    # eq polinomio de lagrange de grau n
    n = len(y)
    
    if (n == 1):
        eq = 1
    else:
        eq = (x[n-1] - x[0])
        
    for i in range(1, len(x)):
        if (i != (n-1)):
            eq *= (x[n-1] - x[i])
            
    return eq

if __name__ == '__main__':

    def func(x):
        return 1/(1+25*pow(x,2))

    x = [-0.773, -0.459, 0.046, 0.337, 0.662]
    y = []
    values = [-0.944, 0.209, 0.486]
    
    #definindo valores de y pela função
    
    for i in range(len(x)):
        y += [func(x[i])]
    #print(y)
    eq = lagrange(x,y)
    print('p(x) =',eq)

    def subs(x):
        return eval(eq)   

    
    for i in range(len(values)):
        print(abs(func(values[i]) - subs(values[i])))