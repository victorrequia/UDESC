from socket import *

serverPort = 12000
serverSocket = socket(AF_INET, SOCK_DGRAM)
serverSocket.bind(('', serverPort))
print "SERVER READY"

while 1:
    message, clientAddress = serverSocket.recvfrom(2048)
    modifiedMessage = "%s ... %s" %(message, message)
    serverSocket.sendto(modifiedMessage, clientAddress)
