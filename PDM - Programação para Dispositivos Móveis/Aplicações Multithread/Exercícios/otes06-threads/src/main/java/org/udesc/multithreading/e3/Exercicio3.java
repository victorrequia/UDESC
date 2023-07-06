package org.udesc.multithreading.e3;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercicio3 {
  public static void main(String[] args) throws InterruptedException {
    Buffer buffer = new Buffer(10);

    var executor = Executors.newFixedThreadPool(10);

    for (int i = 0; i < 10; i++) {
      executor.execute(new Producer(buffer));
      executor.execute(new Consumer(buffer));
    }

    System.out.println("Threads submetidas");
    executor.shutdown();

    if (!executor.awaitTermination(60, TimeUnit.MINUTES)) {
      executor.shutdownNow();
    }

    System.out.println("Threads finalizadas");
    System.out.println("Tempo ocioso das threads: " + buffer.getIdleTimeInSeconds() + "s");
  }
}
