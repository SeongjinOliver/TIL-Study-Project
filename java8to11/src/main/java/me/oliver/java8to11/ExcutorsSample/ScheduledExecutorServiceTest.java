package me.oliver.java8to11.ExcutorsSample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

  public static void main(String[] args) {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//    3초뒤에 실행
//    executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
    // initialDelay 1, 주기적 시간 2
    executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
  }

  private static Runnable getRunnable(String message) {
    return () -> System.out.println(message + Thread.currentThread().getName());
  }
}
