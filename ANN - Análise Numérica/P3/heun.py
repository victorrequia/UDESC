import math
def heun(f, x0:float, y0:float, h:float, n:int):
    r = []
    for _ in range (n):
        #realizar as iterações
        m1 = f(x0, y0)
        m2 = f(x0 + h, y0 + h*m1)
        y1 = y0 + h * (m1+m2)/2
        #atualizando os valores 
        x0 += h
        y0 = y1
        #colocando valores na lista
        r.append((x0, y0))
    return r

if __name__ == "__main__":
    #exemplo
    #y'= 1+xy, y(1)=2
    # 
    # x0 = 1
    # y0 = 2
    #  
    def f(x, y):
        return y*(2 - x) + x + 1
    
    x0 = 1.89102
    y0 = 0.69639
    r = heun(f, x0, y0, h=0.17504, n=10)
    print(r)
