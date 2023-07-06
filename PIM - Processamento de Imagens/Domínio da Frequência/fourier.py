import numpy as np
from matplotlib import pyplot as plt

# Dados da expressão de śerie de Fourier para uma "dente de serra"
T=2*np.pi;
a0=1/4;
W0=2*np.pi/T;
MAX=300 #30;  # número de componentes da série
cont=0;
X=[]
Y=[]
for t in np.arange(0, 2*np.pi,np.pi/32):
		acum=a0/2;
		for n in range(1,MAX):
				an=(np.cos(n*np.pi)-1)/(n*np.pi)**2;
				bn=-np.cos(n*np.pi)/(n*np.pi);
				acum=acum+(an*np.cos(n*W0*t)+bn*np.sin(n*W0*t));
	  
		cont=cont+1;
		X.append(t)
		Y.append(acum);

# Forma recuperada a partir da série gerada
plt.plot(X,Y)
plt.title("Line graph")
plt.ylabel('Y axis')
plt.xlabel('X axis')
plt.show()

