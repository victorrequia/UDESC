import math

#calculando f(x)
def f(x):
    y = []
    for i in range(len(x)):
        funcao = math.cos(x[i]+math.sqrt(math.log(pow(x[i],2))))
        y.append(funcao)
    return y


values = [1.983, 3.007]
fdex = f(values)
print(fdex)

#calculando p(x)
def p(x):
    funcao = -0.9943229789592762*((x-3.375)*(x-4.253))/((2.05-3.375)*(2.05-4.253))+0.22052392879227434*((x-2.05)*(x-4.253))/((3.375-2.05)*(3.375-4.253))+0.9464814841609756*((x-2.05)*(x-3.375))/((4.253-2.05)*(4.253-3.375))
    return funcao

pdex = [p(i) for i in values]
print(pdex)

#|f(x)-p(x)|
def fxmenospx(x,y):
    aux = []
    for i in range(len(x)):
        result = abs(x[i]-y[i])
        aux.append(result)
    return aux

resp = fxmenospx(fdex,pdex)
print(resp)

