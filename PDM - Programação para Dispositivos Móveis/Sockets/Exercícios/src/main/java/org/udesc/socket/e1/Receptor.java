package org.udesc.socket.e1;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

@AllArgsConstructor
public class Receptor extends Thread {
  private Socket socket;

  public void run() {
    try {
      var saida = new Scanner(socket.getInputStream());

      while (saida.hasNextLine()) {
        System.out.println(">>> " + saida.nextLine());
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
