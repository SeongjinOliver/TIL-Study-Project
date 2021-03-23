package me.oliver.java8to11.ExcutorsSample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsServiceTest2 {

  public static void main(String[] args) {
    // 스레드를 2개 가지고 있는 ExecutorService를 만들었다.
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    // 이렇게 5개를 돌려도 Thread 2개로 관리를 한다.
    // 2개는 Thread pool에서 작업을 시행하고 나머지 3개는 Priority Queue에서 대기 하면서 작업을 진행
    executorService.submit(getRunnable("Hello"));
    executorService.submit(getRunnable("Keesun"));
    executorService.submit(getRunnable("The"));
    executorService.submit(getRunnable("Java"));
    executorService.submit(getRunnable("Thread"));

    executorService.shutdown();
  }

  private static Runnable getRunnable(String message) {
    return () -> System.out.println(message + Thread.currentThread().getName());
  }
}
