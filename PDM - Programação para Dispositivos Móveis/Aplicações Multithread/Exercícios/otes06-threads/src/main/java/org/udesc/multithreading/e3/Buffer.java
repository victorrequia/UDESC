package org.udesc.multithreading.e3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Buffer {
  private Queue<Integer> queue;
  private int capacity;

  private Object empty = new Object();
  private Object full = new Object();

  private List<Long> idle;

  public Buffer(int capacity) {
    queue = new LinkedList<>();
    idle = new ArrayList<>();

    this.capacity = capacity;
  }

  public boolean isFull() {
    synchronized (queue) {
      return queue.size() == capacity;
    }
  }

  public boolean isEmpty() {
    synchronized (queue) {
      return queue.isEmpty();
    }
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
    long start = System.currentTimeMillis();

    while (isFull()) {
      System.out.println("Buffer cheio, aguardando para produzir novas entradas... ");
      try {
        waitForProduce();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    idle.add(System.currentTimeMillis() - start);

    enqueue(value);
    notifyForConsume();
  }

  public int consume() {
    long start = System.currentTimeMillis();

    while (isEmpty()) {
      System.out.println("Buffer vazio, aguardando para consumir entradas... ");
      try {
        waitForConsume();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    idle.add(System.currentTimeMillis() - start);

    int value = dequeue();
    notifyForProduce();
    return value;
  }

  public long getIdleTimeInSeconds() {
    Long total = idle.stream().reduce(0L, Long::sum);
    return TimeUnit.MILLISECONDS.toSeconds(total);
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
      empty.notify();
    }
  }

  private void notifyForProduce() {
    synchronized (full) {
      full.notify();
    }
  }
}
