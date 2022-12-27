import math
import random
import numpy as np
from typing import List

#x = a + (b-a) * np.random.rand(10)
#x.sort()
x = [0.0019, 0.0738, 0.1507, 0.204, 0.2666, 0.2825, 0.3699, 0.419, 0.4368, 0.5341, 0.5758, 0.6053, 0.7076, 0.7345, 0.7944, 0.8346, 0.8931, 0.9322, 1.0047, 1.0451, 1.1196, 1.1514, 1.2508, 1.2841, 1.3255, 1.3932, 1.4567, 1.4978, 1.5516, 1.5998, 1.6433, 1.6975, 1.784, 1.8039, 1.8795, 1.9339, 2.0092, 2.053, 2.0924, 2.1275, 2.1829, 2.2588, 2.3287, 2.3504, 2.4441, 2.5072, 2.5328, 2.5833, 2.6205, 2.7256, 2.7638, 2.8249, 2.8878, 2.9311, 2.971]
y = [2.4476, 2.3441, 2.3605, 2.6018, 2.5732, 2.7948, 2.8224, 2.957, 2.7009, 2.6264, 3.4205, 2.9077, 3.0151, 3.1825, 3.5297, 4.1131, 3.3253, 3.4864, 3.6154, 3.726, 3.6375, 4.7576, 4.4396, 3.9615, 4.1764, 5.3966, 4.2798, 5.3268, 4.6565, 4.0794, 5.5701, 4.7266, 4.1353, 4.8496, 5.248, 5.6379, 5.6563, 6.3066, 5.9173, 5.9788, 5.9741, 6.1544, 6.3307, 6.851, 6.7201, 7.2818, 6.131, 5.8266, 7.3032, 7.8236, 9.591, 8.1555, 8.3144, 9.1475, 8.4129]

def best_exp(x: List[float],y: List[float]):
    sum_x = sum(x)
    sum_x2 = sum(xi**2 for xi in x)
    A = [[len(x),sum_x],[sum_x,sum_x2]]
    y_ = [math.log(yi) for yi in y]
    sum_xy = sum(xi * yi for xi,yi in zip(x,y_))
    B = [sum(y_),sum_xy]
    a0,a1 = np.linalg.solve(A,B) 
    a,b = math.exp(a0),a1
    return a,b

r = best_exp(x,y)
print(r)
