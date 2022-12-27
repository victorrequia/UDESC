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
    #MATRIZ B
    yis = 0
    xises_yis = 0
    xises2_yis = 0
    xises3_yis = 0
    xises4_yis = 0
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
        #MatrizB
        yis += y[i]
        xises_yis +=x[i] * y[i]
        xises2_yis += y[i] * (x[i]**2)
        xises3_yis += y[i] * (x[i]**3)
        xises4_yis += y[i] * (x[i]**4)
        
    
    
    A = [[n,xises,xises_quadrado,xises_cubo,xises_quarta],[xises,xises_quadrado,xises_cubo,xises_quarta,xises_quinta],
        [xises_quadrado,xises_cubo,xises_quarta,xises_quinta,xises_sexta],[xises_cubo,xises_quarta,xises_quinta,xises_sexta,xises_setima],
        [xises_quarta,xises_quinta,xises_sexta,xises_setima,xises_oitava]]
    B = [yis,xises_yis,xises2_yis,xises3_yis,xises4_yis]
    a,b,c,d,e = np.linalg.solve(A,B)
    return a,b,c,d,e

x = [-4.4272, -4.2364, -4.1176, -3.8755, -3.7384, -3.5766, -3.2718, -3.17, -2.9923, -2.8551, -2.5194, -2.3431, -2.1773, -2.1155, -1.9317, -1.6113, -1.5418, -1.3429, -1.1757, -0.9751, -0.6654, -0.5197, -0.4716, -0.1913, -0.098, 0.0918, 0.3271, 0.5105, 0.6298, 0.8867, 1.1238, 1.311, 1.5273, 1.6731, 1.8918, 1.973, 2.0788, 2.3985, 2.5585, 2.6513, 2.9701, 3.1103, 3.2582, 3.4667, 3.5389, 3.8465, 3.927, 4.2379, 4.3504, 4.5444, 4.8168, 4.8439]
y = [2.9233, 4.1231, 4.3267, 5.2079, 6.4789, 6.3105, 6.7106, 6.5494, 6.4487, 6.841, 6.675, 6.2204, 6.3072, 6.3634, 5.6603, 5.9067, 7.2036, 4.7763, 5.0197, 4.8706, 4.9623, 4.4688, 4.5312, 4.3201, 4.3753, 4.2521, 3.0947, 4.7464, 4.9053, 4.6672, 5.0108, 4.6209, 5.5032, 6.1154, 6.0024, 6.434, 7.2205, 6.8463, 7.3197, 7.7068, 8.4038, 8.7461, 7.2402, 8.3834, 8.4579, 8.0932, 8.3736, 7.8366, 7.4504, 7.004, 5.9999, 5.9448]
r = best_parabola(x,y)
print(r)
    