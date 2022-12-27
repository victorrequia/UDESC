import math


def f(x):
    y = []
    for i in range(len(x)):
        a0 = -15.3111998479
        a1 = 13.2270140677
        a2 = -2.0885102675
        funcao = a0 + a1*x[i] + a2*pow(x[i],2)
        y.append(funcao)
    return y


x = [3.1, 4.289]
s = f(x)
print([f'{s[element]:+}' for element in range(len(s))])
