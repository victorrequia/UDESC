import math

n1 = [(-0.14887433898163122, 0.29552422471475287), (0.14887433898163122, 0.29552422471475287), (-0.4333953941292472, 0.26926671930999635), (0.4333953941292472, 0.26926671930999635), (-0.6794095682990244, 0.21908636251598204), 
(0.6794095682990244, 0.21908636251598204), (-0.8650633666889845, 0.1494513491505806), (0.8650633666889845, 0.1494513491505806), (-0.9739065285171717, 0.06667134430868814), (0.9739065285171717, 0.06667134430868814)]

print('{x:<20}{c:<20}'.format(x='x_k', c='c_k'))
for x_k, c_k in n1:
    print('{x:<20}{c:<20}'.format(x=x_k, c=c_k))

# se for -1 a 1 usamos a forma f(x) direto
def f(x):
    return math.sin(math.exp(-pow(x,2))) + 1

def quadratura(f, pontos_e_pesos):
    soma = 0
    for x_k, c_k in pontos_e_pesos:
        soma += c_k * f(x_k)
    return soma

# se for distancia diferente de -1 e 1 
def change(f, a, b, u):
    return f((b+a)/2 + (b-a)*u/2) * (b-a)/2

a,b = [-1.74305, 1.3819]
def g(u):
    return change(f, a, b, u)

r = quadratura(g, n1)

print(r)