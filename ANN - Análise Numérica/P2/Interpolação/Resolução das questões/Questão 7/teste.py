import math


def f(x):
    y = []
    for i in range(len(x)):
        a0 = -0.64189352561
        a1 = 2.72365470251
        a2 = -0.68765923246
        funcao = a0 + a1*x[i] + a2*pow(x[i],2)
        y.append(funcao)
    return y


x = [0.365,3.294]
s = f(x)
print([f'{s[element]:+}' for element in range(len(s))])
