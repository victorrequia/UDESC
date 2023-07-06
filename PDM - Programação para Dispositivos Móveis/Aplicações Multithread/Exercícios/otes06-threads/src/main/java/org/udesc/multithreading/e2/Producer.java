package org.udesc.multithreading.e2;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Producer implements Runnable {
  private Buffer buffer;

  private static final Random RANDOM = new Random();

  @Override
  public void run() {
    int i = 0;
    while (i++ < 10) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      int value = Math.abs(RANDOM.nextInt() % 1000);
      buffer.produce(value);
      System.out.println("Produzido: " + value);
    }
  }
}