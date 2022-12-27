
import math

x = [0.374, 1.302, 2.23, 2.2425, 2.255, 2.3955, 2.536, 3.511, 4.486]
y = [2.477, 2.468, 2.053, 2.059, 2.065, 2.156, 2.283, 2.757, 1.897]
def somaparab(x, y):
    soma = 0
    for k in range(0, len(x) - 2, 2):
        soma += ((x[k + 1] - x[k])/3) * (y[k] + 4 * y[k + 1] + y[k + 2])
    return soma

print(somaparab(x, y))