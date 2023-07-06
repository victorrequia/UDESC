package org.udesc.multithreading.e3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer extends Thread {
  private Buffer buffer;

  @Override
  public void run() {
    int i = 0;
    while (i++ < 10) {
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
