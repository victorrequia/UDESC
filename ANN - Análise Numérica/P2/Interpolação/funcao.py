import math

#calculando f(x)
def f(x):
    y = []
    for i in range(len(x)):
        funcao = pow(math.e,-pow(x[i],2)) + math.cos(x[i]) + 3
        y.append(funcao)
    return y


values = [0.447, 0.792, 1.598, 2.25, 3.357, 3.622, 4.644, 5.37, 5.843, 6.636]
fdex = f(values)
print(fdex)


'''
#calculando p(x)
def p(x):
    funcao = -0.9984476481543355*((x-3.644)*(x-4.254))/((2.014-3.644)*(2.014-4.254))+0.5139356785789122*((x-2.014)*(x-4.254))/((3.644-2.014)*(3.644-4.254))+0.9468482225047374*((x-2.014)*(x-3.644))/((4.254-2.014)*(4.254-3.644))
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
'''