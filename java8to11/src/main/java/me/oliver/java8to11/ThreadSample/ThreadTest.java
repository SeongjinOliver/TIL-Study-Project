package me.oliver.java8to11.ThreadSample;

public class ThreadTest {

  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    myThread.start();

    System.out.println("Hello: " + Thread.currentThread().getName());
  }

  static class MyThread extends Thread {
    @Override
    public void run() {
      System.out.println("Thread: " + Thread.currentThread().getName());
    }
  }
}
