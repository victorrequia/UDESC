import math

def f(x):
    return math.exp(-x**2)

a, b = -0.575, 0.845    #intervalo
n = [10, 14, 42, 56, 100, 110, 214, 364, 502, 946, 1034]       #n = subintervalos, n/2 = parabolas, n+1 = pontos na partição


def simps(a, b, n):
    if n%2 != 0 or n < 1:
        raise ValueError("n deve ser par e maior que 1")
    h = (b - a)/n
    soma_odd, soma_even = 0, 0
    for k in range(1, n, 2):
        soma_odd += f(a + k * h)
    for k in range(2, n, 2):
        soma_even += f(a + k * h)
    return (f(a) + 4 * soma_odd + 2 * soma_even + f(b)) * (h/3)

""""
for ni in n:
    print(f'n = {ni} => {simps(a, b, ni)}')
"""

x = [0.374, 1.302, 2.23, 2.2425, 2.255, 2.3955, 2.536, 3.511, 4.486]
y = [2.477, 2.468, 2.053, 2.059, 2.065, 2.156, 2.283, 2.757, 1.897]

def somaparab(x, y):
    soma = 0
    for k in range(0, len(x) - 2, 2):
        soma += ((x[k + 1] - x[k])/3) * (y[k] + 4 * y[k + 1] + y[k + 2])
    return soma

print(somaparab(x, y))