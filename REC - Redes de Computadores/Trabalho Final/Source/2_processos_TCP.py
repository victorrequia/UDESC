import re
import numpy as np
import matplotlib.pyplot as plt

# Texto com a saída do iperf3
texto = '''
-----------------------------------------------------------
Server listening on 5201
-----------------------------------------------------------
Accepted connection from 192.168.0.162, port 54444
[  6] local 192.168.0.129 port 5201 connected to 192.168.0.162 port 54445
[  8] local 192.168.0.129 port 5201 connected to 192.168.0.162 port 54446
[ ID] Interval           Transfer     Bandwidth
[  6]   0.00-1.00   sec  15.4 MBytes   129 Mbits/sec                  
[  8]   0.00-1.00   sec  14.2 MBytes   119 Mbits/sec                                  
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   1.00-2.00   sec  16.4 MBytes   137 Mbits/sec                  
[  8]   1.00-2.00   sec  15.5 MBytes   130 Mbits/sec                                  
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   2.00-3.00   sec  16.8 MBytes   141 Mbits/sec                  
[  8]   2.00-3.00   sec  15.6 MBytes   131 Mbits/sec                                 
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   3.00-4.00   sec  16.5 MBytes   138 Mbits/sec                  
[  8]   3.00-4.00   sec  15.4 MBytes   129 Mbits/sec                                    
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   4.00-5.00   sec  17.6 MBytes   148 Mbits/sec                  
[  8]   4.00-5.00   sec  16.1 MBytes   135 Mbits/sec                                  
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   5.00-6.00   sec  17.5 MBytes   147 Mbits/sec                  
[  8]   5.00-6.00   sec  16.4 MBytes   137 Mbits/sec                                 
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   6.00-7.00   sec  17.9 MBytes   150 Mbits/sec                  
[  8]   6.00-7.00   sec  16.0 MBytes   134 Mbits/sec                                  
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   7.00-8.00   sec  17.2 MBytes   145 Mbits/sec                  
[  8]   7.00-8.00   sec  16.0 MBytes   134 Mbits/sec                               
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   8.00-9.00   sec  17.2 MBytes   145 Mbits/sec                  
[  8]   8.00-9.00   sec  16.1 MBytes   135 Mbits/sec                                    
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]   9.00-10.00  sec  17.2 MBytes   145 Mbits/sec                  
[  8]   9.00-10.00  sec  16.0 MBytes   134 Mbits/sec                                  
- - - - - - - - - - - - - - - - - - - - - - - - -
[  6]  10.00-10.05  sec   768 KBytes   127 Mbits/sec                  
[  8]  10.00-10.05  sec   640 KBytes   106 Mbits/sec                                  
- - - - - - - - - - - - - - - - - - - - - - - - -

'''

# Expressão regular para encontrar os números na coluna "Transfer"
padrao_transfer = r'\d+\.\d+\s+MBytes'

# Encontra todos os valores de "Transfer" excluindo a linha [SUM]
transfer = re.findall(padrao_transfer, texto)
transfer = [t for t in transfer if '[SUM]' not in t]

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