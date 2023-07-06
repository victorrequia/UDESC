import matplotlib.pyplot as plt

text = '''

-----------------------------------------------------------
Server listening on 5201
-----------------------------------------------------------
Accepted connection from 177.34.71.239, port 52186
[  5] local 172.31.8.63 port 5201 connected to 177.34.71.239 port 52187
[ ID] Interval           Transfer     Bitrate         Retr  Cwnd
[  5]   0.00-1.00   sec  9.75 MBytes  81.8 Mbits/sec    0    419 KBytes       
[  5]   1.00-2.00   sec  8.50 MBytes  71.3 Mbits/sec    0    419 KBytes       
[  5]   2.00-3.00   sec  8.88 MBytes  74.4 Mbits/sec    0    419 KBytes       
[  5]   3.00-4.00   sec  8.88 MBytes  74.5 Mbits/sec    0    419 KBytes       
[  5]   4.00-5.00   sec  6.88 MBytes  57.7 Mbits/sec    0    419 KBytes       
[  5]   5.00-6.00   sec  7.00 MBytes  58.7 Mbits/sec    0    419 KBytes       
[  5]   6.00-7.00   sec  5.50 MBytes  46.1 Mbits/sec    0    419 KBytes       
[  5]   7.00-8.00   sec  2.12 MBytes  17.8 Mbits/sec   12    292 KBytes       
[  5]   8.00-9.00   sec  5.00 MBytes  41.9 Mbits/sec    0    292 KBytes       
[  5]   9.00-10.00  sec  3.62 MBytes  30.4 Mbits/sec    0    292 KBytes       
[  5]  10.00-11.00  sec  3.25 MBytes  27.3 Mbits/sec    0    292 KBytes       
[  5]  11.00-12.00  sec  3.75 MBytes  31.5 Mbits/sec    0    292 KBytes       
[  5]  12.00-13.00  sec  3.12 MBytes  26.2 Mbits/sec    0    292 KBytes       
[  5]  13.00-14.00  sec  5.25 MBytes  44.0 Mbits/sec    0    292 KBytes       
[  5]  14.00-15.00  sec  3.62 MBytes  30.4 Mbits/sec    0    292 KBytes       
[  5]  15.00-16.00  sec  2.75 MBytes  23.1 Mbits/sec    0    292 KBytes       
[  5]  16.00-17.00  sec   640 KBytes  5.24 Mbits/sec   24   1.43 KBytes       
[  5]  17.00-18.00  sec  0.00 Bytes  0.00 Mbits/sec    1   1.43 KBytes       
[  5]  18.00-19.00  sec  0.00 Bytes  0.00 Mbits/sec    1   1.43 KBytes       
[  5]  19.00-20.00  sec  0.00 Bytes  0.00 Mbits/sec    0   1.43 KBytes       
[  5]  20.00-21.00  sec  0.00 Bytes  0.00 Mbits/sec    0   1.43 KBytes       
[  5]  21.00-22.00  sec  0.00 Bytes  0.00 Mbits/sec    1   1.43 KBytes       
[  5]  22.00-23.00  sec  0.00 Bytes  0.00 Mbits/sec    0   1.43 KBytes       
[  5]  23.00-24.00  sec  0.00 Bytes  0.00 Mbits/sec    0   1.43 KBytes

'''

lines = text.split('\n')

bitrate_values = []

# Extrair os valores de Bitrate das linhas relevantes
for line in lines:
    if 'Mbits/sec' in line:
        bitrate = line.split()[6]  # Extrair o valor da coluna Bitrate
        bitrate_values.append(float(bitrate))

# Criar o gráfico
plt.plot(bitrate_values)
plt.grid(True)
plt.xlabel('Intervalo')
plt.ylabel('Bitrate (Mbits/sec)')
plt.title('Valores de Bitrate')
plt.show()