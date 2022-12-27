import numpy as np

def best_par(x,y):
    n = len(x)
    xises = 0
    #MATRIZ A
    xises = 0
    xises_quadrado = 0
    xises_cubo = 0
    xises_quarta = 0
    #MATRIZ B
    yis = 0
    xises_yis = 0
    xises2_yis = 0
    for i in range(n):
        xises += x[i]
        xises_quadrado += x[i]**2
        xises_cubo +=x[i]**3
        xises_quarta +=x[i]**4
        
        yis += y[i]
        xises_yis +=x[i] * y[i]
        xises2_yis += y[i] * (x[i]**2)
    
    A = [[n,xises,xises_quadrado],[xises,xises_quadrado,xises_cubo],[xises_quadrado,xises_cubo,xises_quarta]]
    B = [yis,xises_yis,xises2_yis]
    a,b,c = np.linalg.solve(A,B)
    return a,b,c

x = [0.041, 0.3526, 0.799, 0.9873, 1.1668, 1.5947, 1.7203, 2.011, 2.3626, 2.4671, 2.8782, 3.0178, 3.4942, 3.5389, 4.0294, 4.3132, 4.4437, 4.7168, 4.9435, 5.177, 5.5227, 5.6985, 5.9834, 6.2977, 6.7513, 6.8153, 7.0313, 7.431, 7.6184, 8.0177, 8.1266, 8.5768, 8.7888, 9.0492, 9.4178, 9.6437, 9.8633]
y = [5.4199, 5.2331, 4.8092, 4.7582, 4.4615, 4.2296, 4.2766, 4.1666, 3.9851, 4.0803, 3.6266, 3.834, 3.8127, 3.8299, 3.7276, 2.9357, 3.4704, 2.5582, 4.3451, 3.2812, 3.2147, 3.4254, 3.9267, 3.3735, 3.8445, 3.4463, 3.501, 3.7477, 2.5, 3.8885, 3.9034, 4.5688, 3.5975, 4.5869, 4.9035, 4.0313, 5.9318]

r = best_par(x,y)
print(r)
    