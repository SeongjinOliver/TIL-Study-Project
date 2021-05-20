package me.oliver.java8to11.ExcutorsSample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsServiceTest {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.submit(() -> {
      System.out.println("Thread " + Thread.currentThread().getName());
    });
    executorService.shutdown();


//    executorService.execute(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("Thread " + Thread.currentThread().getName());
//      }
//    });
  }
}
