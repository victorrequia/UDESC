package org.udesc.socket.e1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
  public static void main(String[] args) throws IOException {
    var socket = new Socket("127.0.0.1", 12345);
    System.out.println("Conexão estabelecida com o servidor");

   new Receptor(socket).start();
   new Emissor(socket).start();
  }
}
