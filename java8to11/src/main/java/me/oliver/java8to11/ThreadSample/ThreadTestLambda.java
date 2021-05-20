package me.oliver.java8to11.ThreadSample;

public class ThreadTestLambda {

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        // 누군가가 스레드가 잘 때 깨우면 IterruptedException이 처리 된다.
        e.printStackTrace();
      }
      System.out.println("Thread: " + Thread.currentThread().getName());
    });
    thread.start();

    System.out.println("Hello: " + Thread.currentThread().getName());
  }
}
