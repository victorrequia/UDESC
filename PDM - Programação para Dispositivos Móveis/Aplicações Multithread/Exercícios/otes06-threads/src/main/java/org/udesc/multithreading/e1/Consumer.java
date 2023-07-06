package org.udesc.multithreading.e1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer extends Thread {
  private Buffer buffer;

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      int value = buffer.consume();
      System.out.println("Consumido: " + value);
    }
  }
}
