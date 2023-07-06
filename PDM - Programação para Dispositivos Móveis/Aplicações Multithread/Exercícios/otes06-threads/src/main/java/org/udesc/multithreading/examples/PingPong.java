package org.udesc.multithreading.examples;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PingPong extends Thread {
  private String palavra;

  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.print(palavra + " ");

      try {
        Thread.sleep(10);
      } catch(InterruptedException e) {
      }
    }
  }

  public static void main(String args[]) throws InterruptedException {
    var ping = new PingPong("ping");
    var pong = new PingPong("pong");

    ping.start();
    pong.start();

    ping.join();
    pong.join();

    System.out.println("\nPrograma finalizado, threads encerradas!");
  }
}
