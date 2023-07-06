import re
import numpy as np
import matplotlib.pyplot as plt

# Texto com a saída do iperf3
texto = '''
-----------------------------------------------------------
Server listening on 5201
-----------------------------------------------------------
-----------------------------------------------------------
Server listening on 5201
-----------------------------------------------------------
Accepted connection from 192.168.0.162, port 53989
[  6] local 192.168.0.129 port 5201 connected to 192.168.0.162 port 53990
[ ID] Interval           Transfer     Bandwidth
[  6]   0.00-1.00   sec  25.4 MBytes   213 Mbits/sec                  
[  6]   1.00-2.00   sec  30.2 MBytes   254 Mbits/sec                  
[  6]   2.00-3.00   sec  28.1 MBytes   236 Mbits/sec                  
[  6]   3.00-4.00   sec  29.8 MBytes   249 Mbits/sec                  
[  6]   4.00-5.00   sec  30.9 MBytes   259 Mbits/sec                  
[  6]   5.00-6.00   sec  29.6 MBytes   248 Mbits/sec                  
[  6]   6.00-7.00   sec  28.8 MBytes   241 Mbits/sec                  
[  6]   7.00-8.00   sec  27.9 MBytes   234 Mbits/sec                  
[  6]   8.00-9.00   sec  29.0 MBytes   243 Mbits/sec                  
[  6]   9.00-10.00  sec  29.2 MBytes   246 Mbits/sec                  
[  6]  10.00-11.00  sec  28.6 MBytes   240 Mbits/sec                  
[  6]  11.00-12.00  sec  30.5 MBytes   256 Mbits/sec                  
[  6]  12.00-13.00  sec  28.5 MBytes   239 Mbits/sec                  
[  6]  13.00-14.00  sec  29.9 MBytes   251 Mbits/sec                  
[  6]  14.00-15.00  sec  29.1 MBytes   244 Mbits/sec                  
[  6]  15.00-16.00  sec  29.4 MBytes   246 Mbits/sec                  
[  6]  16.00-17.00  sec  30.0 MBytes   252 Mbits/sec                  
[  6]  17.00-18.00  sec  29.0 MBytes   243 Mbits/sec                  
[  6]  18.00-19.00  sec  28.9 MBytes   242 Mbits/sec                  
[  6]  19.00-20.00  sec  29.6 MBytes   249 Mbits/sec                  
[  6]  20.00-20.04  sec  1.25 MBytes   247 Mbits/sec                  
- - - - - - - - - - - - - - - - - - - - - - - - -
[ ID] Interval           Transfer     Bandwidth
[  6]   0.00-20.04  sec   584 MBytes   244 Mbits/sec                  sender
[  6]   0.00-20.04  sec  0.00 Bytes  0.00 bits/sec                  receiver

'''

# Expressão regular para encontrar os números na coluna "Bandwidth"
padrao = r'\d+\s+Mbits/sec'

# Encontra todos os números na coluna "Bandwidth"
bandwidth = re.findall(padrao, texto)

# Remove o " Mbits/sec" e converte para float
bandwidth = np.array([float(b.replace(' Mbits/sec', '')) for b in bandwidth])

# Gera os índices para o eixo x
indices = np.arange(len(bandwidth))

# Plota o gráfico
plt.figure(figsize=(10, 6))
plt.plot(indices, bandwidth, marker='o')
plt.xlabel('Amostras')
plt.ylabel('Bandwidth (Mbits/sec)')
plt.title('Valores de Bandwidth')
plt.xticks(indices)
plt.grid(True)
plt.show()