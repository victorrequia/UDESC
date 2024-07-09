import re

import matplotlib.pyplot as plt
import numpy as np

# Texto com a saída do iperf3
texto = '''
-----------------------------------------------------------
Server listening on 5201
-----------------------------------------------------------
Accepted connection from 192.168.0.162, port 54162
[  6] local 192.168.0.129 port 5201 connected to 192.168.0.162 port 54163
[ ID] Interval           Transfer     Bandwidth
[  6]   0.00-1.00   sec  28.4 MBytes   238 Mbits/sec                  
[  6]   1.00-2.00   sec  32.1 MBytes   269 Mbits/sec                  
[  6]   2.00-3.00   sec  30.6 MBytes   257 Mbits/sec                  
[  6]   3.00-4.00   sec  30.5 MBytes   256 Mbits/sec                  
[  6]   4.00-5.00   sec  16.9 MBytes   141 Mbits/sec                  
[  6]   5.00-6.00   sec   0.896 MBytes  7.34 Mbits/sec                  
[  6]   6.00-7.00   sec   0.256 MBytes  2.10 Mbits/sec                  
[  6]   7.00-8.00   sec   0.128 MBytes  1.05 Mbits/sec                  
[  6]   8.00-9.00   sec   0.128 MBytes  1.05 Mbits/sec                  
[  6]   9.00-10.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  10.00-11.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  11.00-12.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  12.00-13.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  13.00-14.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  14.00-15.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  15.00-16.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  16.00-17.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  17.00-18.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  18.00-19.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  19.00-20.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  20.00-21.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  21.00-22.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  22.00-23.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  23.00-24.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  24.00-25.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  25.00-26.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  26.00-27.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  27.00-28.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  28.00-29.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  29.00-30.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  30.00-31.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  31.00-32.00  sec  0.00 MBytes  0.00 Mbits/sec                  
[  6]  32.00-33.00  sec   0.256 MBytes  2.10 Mbits/sec                  
[  6]  33.00-34.00  sec  24.9 MBytes   209 Mbits/sec                  
[  6]  34.00-35.00  sec  27.0 MBytes   226 Mbits/sec                  
[  6]  35.00-36.00  sec  29.5 MBytes   247 Mbits/sec                  
[  6]  36.00-37.00  sec  28.2 MBytes   237 Mbits/sec                  
[  6]  37.00-38.00  sec  29.4 MBytes   246 Mbits/sec                  
[  6]  38.00-39.00  sec  29.0 MBytes   244 Mbits/sec                  
[  6]  39.00-40.00  sec  29.4 MBytes   246 Mbits/sec                  
[  6]  40.00-40.05  sec  1.50 MBytes   239 Mbits/sec                  
- - - - - - - - - - - - - - - - - - - - - - - - -
[ ID] Interval           Transfer     Bandwidth
[  6]   0.00-40.05  sec   339 MBytes  71.0 Mbits/sec                  sender
[  6]   0.00-40.05  sec  0.00 Bytes  0.00 bits/sec                  receiver

'''

# Expressão regular para encontrar os números na coluna "Transfer"
padrao_transfer = r'\d+\.\d+\s+MBytes'

# Encontra todos os valores de "Transfer"
transfer = re.findall(padrao_transfer, texto)

# Remove o " MBytes" e converte para float
transfer = np.array([float(t.replace(' MBytes', '')) for t in transfer])

# Gera os índices para o eixo x
indices = np.arange(len(transfer))

# Plota o gráfico
plt.figure(figsize=(10, 6))
plt.plot(indices, transfer, marker='o')
plt.xlabel('Amostras')
plt.ylabel('Transfer (MBytes)')
plt.title('Valores de Transfer')
plt.xticks(indices)
plt.grid(True)
plt.show()