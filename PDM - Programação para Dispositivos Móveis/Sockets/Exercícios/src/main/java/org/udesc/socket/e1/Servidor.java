package org.udesc.socket.e1;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {
  public static void main(String[] args) throws IOException {
    var servidor = new ServerSocket(12345);
    System.out.println("Servidor iniciado");

   while (true) {
     var socket = servidor.accept();
     System.out.println("Nova conexão estabelecida");

     new Receptor(socket).start();
     new Emissor(socket).start();
   }
  }
}
