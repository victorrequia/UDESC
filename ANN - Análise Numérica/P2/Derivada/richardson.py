import math

def richardson(col1):
    col1 = [item for item in col1] # cópia da coluna 1
    n = len(col1)
    for j in range(n-1):
        temp_col = [0] * (n - 1 - j)
        for i in range(n - 1 - j):
            power = j + 1 # é igual ao numero da coluna anterior
            temp_col[i] = (2 ** power * col1[i + 1] - col1[i]) / (2 ** power - 1)
        col1[:n - 1 - j] = temp_col
        print(temp_col)
    return col1[0] # a aproximação procurada

################ Constrói a primeira coluna com 'h' e 'fórmula'
'''def F1(f, x0, h):
    return (f(x0 + h) - f(x0)) / h

def f(x):
    return x**x

x0 = 2
h = 0.5
col1 = [F1(f, x0, h / 2 ** i) for i in range(6)]
print(col1)

r = richardson(col1)'''


################ Dado a coluna
#def g(x):
#    return pow(math.sin(x),4) - 4*pow(math.sin(x),2) + math.cos(pow(x,2)) + math.exp(-pow(x,2)) + 5

x0 = 2.72525
col1 = [0.28021958738706587, 0.31574562843047715, 0.32459548288898077, 0.32680083084233047]
print(col1)

r = richardson(col1)