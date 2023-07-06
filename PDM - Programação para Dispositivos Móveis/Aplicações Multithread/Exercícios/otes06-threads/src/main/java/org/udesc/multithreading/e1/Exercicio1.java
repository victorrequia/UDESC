package org.udesc.multithreading.e1;

public class Exercicio1 {
  public static void main(String[] args) {
    Buffer buffer = new Buffer(5);

    Thread producer = new Thread(new Producer(buffer));
    Thread consumer = new Thread(new Consumer(buffer));

    producer.start();
    consumer.start();
  }
}
