package me.oliver.java8to11.ExcutorsSample;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
//    ExecutorService executorService = Executors.newFixedThreadPool(4);
//    Future<String> future = executorService.submit(() -> "hello");
//
//    // TODO
//
//    future.get();

    CompletableFuture<String> future0 = new CompletableFuture<>();
    future0.complete("keesun");

    System.out.println(future0.get());

    // 위와 같다
    CompletableFuture<String> future = CompletableFuture.completedFuture("keesun");
    System.out.println(future.get());

    /* CompletableFuture.runAsync()
    *  return이 없는 타입
    * */
    CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
    });
    future.get();
    System.out.println("================");

    /* CompletableFutures.supplyAsync()
    *  return이 있는 타입
    * */
    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    });
    System.out.println(future2.get());

    /* thenApply
    * 더 구현하고자하는 코드를 추가로 구현할 수 있으며 return 타입이 있음
    * */
    CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    }).thenApply((s) -> {
      System.out.println(Thread.currentThread().getName());
      return s.toUpperCase();
    });
    System.out.println(future3.get());

    /* thenAppept
     * return이 없고 thenAccept 안에서 하고자하는 내용만 코딩하면 된다.
     */
    CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    }).thenAccept((s) -> {
      System.out.println(Thread.currentThread().getName());
      System.out.println(s.toUpperCase());
    });

    future4.get();

    /* thenRun
     * Runnable이 매개변수로? 안에서 참고를 하여 코딩이 불가능하다.
     */
    CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    }).thenRun(() -> {
      System.out.println(Thread.currentThread().getName());
    });

    /*
     * 기존에 있던 Pool을 매개변수로 사용 가능하다.
     */
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    }, executorService).thenRun(() -> {
      System.out.println(Thread.currentThread().getName());
    });

    /* thenRunAsync, ***Async.... 등등
     * 기존에 있던 Pool을 매개변수로 사용 가능하다.
     */
    ExecutorService executorService1 = Executors.newFixedThreadPool(4);
    CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    }, executorService).thenRunAsync(() -> {
      System.out.println(Thread.currentThread().getName());
    }, executorService);

    executorService1.shutdown();
  }
}
