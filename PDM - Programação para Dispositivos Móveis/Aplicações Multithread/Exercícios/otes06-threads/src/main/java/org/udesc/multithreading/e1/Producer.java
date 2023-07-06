package org.udesc.multithreading.e1;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Producer implements Runnable {
  private Buffer buffer;

  private static final Random RANDOM = new Random();

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      int value = Math.abs(RANDOM.nextInt() % 1000);
      buffer.produce(value);
      System.out.println("Produzido: " + value);
    }
  }
}