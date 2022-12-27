import math

#calculando f(x)
def f(x):
    y = []
    for i in range(len(x)):
        funcao = math.sin(math.sqrt(1+math.tan(x[i])))
        y.append(funcao)
    return y


values = [2.978, 4.189, 4.317]
fdex = f(values)
print(fdex)

#calculando p(x)
def p(x):
    funcao = +0.7558686968433715*((x-3.058)*(x-3.578)*(x-3.853)*(x-4.33))/((2.882-3.058)*(2.882-3.578)*(2.882-3.853)*(2.882-4.33))+0.8175765636377788*((x-2.882)*(x-3.578)*(x-3.853)*(x-4.33))/((3.058-2.882)*(3.058-3.578)*(3.058-3.853)*(3.058-4.33))+0.9359508180079145*((x-2.882)*(x-3.058)*(x-3.853)*(x-4.33))/((3.578-2.882)*(3.578-3.058)*(3.578-3.853)*(3.578-4.33))+0.978805162804684*((x-2.882)*(x-3.058)*(x-3.578)*(x-4.33))/((3.853-2.882)*(3.853-3.058)*(3.853-3.578)*(3.853-4.33))+0.9563947223461173*((x-2.882)*(x-3.058)*(x-3.578)*(x-3.853))/((4.33-2.882)*(4.33-3.058)*(4.33-3.578)*(4.33-3.853))
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