import numpy as np

def best_parabola(x,y):
    n = len(x)
    xises = 0
    #MATRIZ A
    xises = 0
    xises_quadrado = 0
    xises_cubo = 0
    xises_quarta = 0
    xises_quinta = 0
    xises_sexta = 0
    #MATRIZ B
    yis = 0
    xises_yis = 0
    xises2_yis = 0
    xises3_yis = 0
    for i in range(n):
        #MatrizA
        xises += x[i]
        xises_quadrado += x[i]**2
        xises_cubo +=x[i]**3
        xises_quarta +=x[i]**4
        xises_quinta +=x[i]**5
        xises_sexta +=x[i]**6
        #MatrizB
        yis += y[i]
        xises_yis +=x[i] * y[i]
        xises2_yis += y[i] * (x[i]**2)
        xises3_yis += y[i] * (x[i]**3)
        
    
    
    A = [[n,xises,xises_quadrado,xises_cubo],[xises,xises_quadrado,xises_cubo,xises_quarta],[xises_quadrado,xises_cubo,xises_quarta,xises_quinta],[xises_cubo,xises_quarta,xises_quinta,xises_sexta]]
    B = [yis,xises_yis,xises2_yis,xises3_yis]
    a,b,c,d = np.linalg.solve(A,B)
    return a,b,c,d

x = [-4.7924, -4.6321, -4.498, -4.1684, -4.1531, -3.7635, -3.6475, -3.4233, -3.272, -3.0612, -2.8631, -2.5102, -2.3906, -2.1815, -1.9019, -1.6774, -1.5464, -1.3023, -1.0998, -0.9522, -0.6265, -0.4797, -0.2954, -0.0505, 0.217, 0.3978, 0.5821, 0.8123, 1.1226, 1.2501, 1.4936, 1.6887, 1.7746, 2.1586, 2.2587, 2.6041, 2.784, 2.8841, 3.1365, 3.3491, 3.5117, 3.7468, 4.0601, 4.2605, 4.3913, 4.5594, 4.8721, 5.0138, 5.3517, 5.462, 5.6322, 5.9998]
y = [4.5988, 4.0183, 4.4316, 5.2685, 6.2514, 5.9722, 6.0165, 5.542, 6.4382, 6.8015, 7.1505, 7.1929, 8.5665, 6.998, 6.8276, 6.9656, 7.0101, 6.797, 6.4973, 6.2706, 4.8807, 5.9282, 5.7944, 5.4012, 5.405, 4.3257, 4.8659, 4.5678, 4.6528, 5.8863, 5.6883, 3.3753, 4.2607, 4.1665, 4.0096, 4.9327, 3.7941, 3.9899, 4.1348, 4.5415, 3.948, 5.094, 5.436, 5.8377, 6.5518, 6.7339, 7.4293, 8.9178, 8.7747, 10.2329, 10.6972, 12.3943]

r = best_parabola(x,y)
print(r)
    