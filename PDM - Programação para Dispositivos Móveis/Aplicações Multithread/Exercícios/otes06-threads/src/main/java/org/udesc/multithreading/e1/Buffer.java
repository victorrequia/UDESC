package org.udesc.multithreading.e1;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
  private Queue<Integer> queue;
  private int capacity;

  private Object empty = new Object();
  private Object full = new Object();

  public Buffer(int capacity) {
    this.capacity = capacity;

    queue = new LinkedList<>();
  }

  public boolean isFull() {
    return queue.size() == capacity;
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  private void enqueue(int value) {
    synchronized (queue) {
      queue.offer(value);
    }
  }

  private int dequeue() {
    synchronized (queue) {
      return queue.poll();
    }
  }

  public void produce(int value) {
    while (isFull()) {
      System.out.println("Buffer cheio, aguardando para produzir novas entradas... ");
      try {
        waitForProduce();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    enqueue(value);
    notifyForConsume();
  }

  public int consume() {
    while (isEmpty()) {
      System.out.println("Buffer vazio, aguardando para consumir entradas... ");
      try {
        waitForConsume();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    int value = dequeue();
    notifyForProduce();
    return value;
  }

  private void waitForConsume() throws InterruptedException {
    synchronized (empty) {
      empty.wait();
    }
  }

  private void waitForProduce() throws InterruptedException {
    synchronized (full) {
      full.wait();
    }
  }

  private void notifyForConsume() {
    synchronized (empty) {
      empty.notifyAll();
    }
  }

  private void notifyForProduce() {
    synchronized (full) {
      full.notifyAll();
    }
  }
}
