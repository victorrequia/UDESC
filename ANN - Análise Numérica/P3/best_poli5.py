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
    xises_setima = 0
    xises_oitava = 0
    xises_nona = 0
    xises_decima = 0
    #MATRIZ B
    yis = 0
    xises_yis = 0
    xises2_yis = 0
    xises3_yis = 0
    xises4_yis = 0
    xises5_yis = 0
    for i in range(n):
        #MatrizA
        xises += x[i]
        xises_quadrado += x[i]**2
        xises_cubo +=x[i]**3
        xises_quarta +=x[i]**4
        xises_quinta +=x[i]**5
        xises_sexta +=x[i]**6
        xises_setima +=x[i]**7
        xises_oitava +=x[i]**8
        xises_nona +=x[i]**9
        xises_decima +=x[i]**10

        #MatrizB
        yis += y[i]
        xises_yis +=x[i] * y[i]
        xises2_yis += y[i] * (x[i]**2)
        xises3_yis += y[i] * (x[i]**3)
        xises4_yis += y[i] * (x[i]**4)
        xises5_yis += y[i] * (x[i]**5)
        
    
    
    A = [[n,xises,xises_quadrado,xises_cubo,xises_quarta,xises_quinta],[xises,xises_quadrado,xises_cubo,xises_quarta,xises_quinta,xises_sexta],
        [xises_quadrado,xises_cubo,xises_quarta,xises_quinta,xises_sexta,xises_setima],[xises_cubo,xises_quarta,xises_quinta,xises_sexta,xises_setima,xises_oitava],
        [xises_quarta,xises_quinta,xises_sexta,xises_setima,xises_oitava,xises_nona],[xises_quinta,xises_sexta,xises_setima,xises_oitava,xises_nona,xises_decima]]
    B = [yis,xises_yis,xises2_yis,xises3_yis,xises4_yis,xises5_yis]
    a,b,c,d,e,f = np.linalg.solve(A,B)
    return a,b,c,d,e,f

x = [-4.0495, -3.9317, -3.578, -3.3727, -3.0527, -2.6599, -2.4572, -2.2486, -1.9653, -1.674, -1.4819, -1.1768, -0.9134, -0.7649, -0.4186, -0.2182, 0.2352, 0.3793, 0.6264, 1.0339, 1.2884, 1.5555, 1.6928, 2.0145, 2.2103, 2.5743, 2.8219, 3.1572, 3.4203, 3.7156, 3.7995, 4.0469]
y = [4.3373, 5.4364, 6.7114, 7.6116, 7.5631, 6.6191, 4.8071, 5.849, 4.9329, 4.459, 4.1881, 4.0019, 3.7168, 4.2209, 4.293, 4.073, 5.1315, 5.7963, 5.6654, 6.1285, 5.8582, 5.6857, 5.5123, 5.4717, 4.3322, 3.3289, 2.9696, 2.1835, 2.4197, 2.2276, 3.3015, 5.5854]
r = best_parabola(x,y)
print(r)
    