import math

def ralston(f, x0, y0, h, n):
    r = []
    for _ in range(n):
        #realizar as iterações
        m1 = f(x0, y0)
        m2 = f(x0 + (3/4)*h, y0 + (3/4)*h*m1)
        yk = y0 + h * (m1+2*m2)/3
        #atualizando os valores 
        x0 += h
        y0 = yk
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
    
    x0 = 0.88143
    y0 = 0.37337
    r = ralston(f, x0, y0, h=0.16381, n=10)
    print(r)