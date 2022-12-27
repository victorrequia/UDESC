import math

#calculando f(x)
def f(x):
    y = []
    for i in range(len(x)):
        funcao = pow(math.cos(x[i]),3) + 2*pow(math.cos(x[i]),2) + 1
        y.append(funcao)
    return y


values = [-0.773, -0.459, 0.046, 0.337, 0.662]
fdex = f(values)
print(fdex)