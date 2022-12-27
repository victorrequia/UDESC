#lista dada
pontos_e_pesos = [(-0.1834346424956498,0.362683783378362),(0.1834346424956498,0.362683783378362),(-0.525532409916329, 0.31370664587788727),(0.525532409916329,0.31370664587788727),(-0.7966664774136267, 0.22238103445337448),( 0.7966664774136267,0.22238103445337448),(-0.9602898564975363,0.10122853629037626),(0.9602898564975363,0.10122853629037626)]
#apenas para integrais de intervalo [-1 1]
def quadratura(f,pontos_e_pesos):
    soma = 0
    for x_k,c_k in pontos_e_pesos:
        soma += c_k * f(x_k)
    return soma

# construir uma combinação linear  f = c1*f1 + c2*f2 + c3*f3
def coeffs_best_func(f, a, b, fs):
    if a != -1 or b != 1:
        raise ValueError("a deve ser -1 e b deve ser 1")
    coeffs = []
    for k in range(len(fs)):
        # ck = integral de f*fk em [a, b] dividido por integral de fk*fk em [a,b] 
        def ffk(x):
            return f(x) * fs[k](x)
        def fkfk(x):
            return fs[k](x) **2
        ck = quadratura(ffk, pontos_e_pesos) / quadratura(fkfk, pontos_e_pesos)
        coeffs.append(ck)
    return coeffs

def f1(x): return 1 
def f2(x): return x
def f3(x): return (3 * x ** 2+1)/2 

fs = [f1,f2,f3]

def f(x):
    if x >= 0:
        return 1
    return 2

a, b = [-1, 1]

coeffs = coeffs_best_func(f, a, b, fs)
print(coeffs)