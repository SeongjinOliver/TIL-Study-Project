package me.oliver.java8to11.ExcutorsSample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureTest2 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    /*
     * 두개의 스레드가 연관관계가 있는 경우
     */
    CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    });

    CompletableFuture<String> future = hello.thenCompose(CompletableFutureTest2::getWorld);
    System.out.println(future.get());

    /*
     * 두개를 독립적으로 가져와서 처리, 연관이 없는 관계에서..
     */
    CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    });

    CompletableFuture<String> world1 = CompletableFuture.supplyAsync(() -> {
      System.out.println("World " + Thread.currentThread().getName());
      return "World";
    });

    CompletableFuture<String> future1 = hello1.thenCombine(world1, (h, w) -> h + " " + w);
    System.out.println(future1.get());

    /*
     * 두개 이상일 때 여러 테스트들을 합쳐서 실행할 수 있음.
     */
    CompletableFuture<Void> future2 = CompletableFuture.allOf(hello1, world1)
        .thenAccept(System.out::println);
    System.out.println(future2.get());

    /*
     * join은 unchecked
     */
    List<CompletableFuture<String>> futures = Arrays.asList(hello1, world1);
    CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

    CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
        .thenApply(v -> futures.stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList()));
    results.get().forEach(System.out::println);
    System.out.println("==============");
    /* anyOf
     * 실행할 때마다 둘중에 아무거나 랜덤하게 나온다.
     */
    CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello1, world1).thenAccept(System.out::println);
    future3.get();

    /*
     * 에러 발생시 예외처리
     */
    boolean throwError = true;
    CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
      if (throwError) {
        throw new IllegalArgumentException();
      }

      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    }).exceptionally(ex -> {
      System.out.println(ex);
      return "Error!";
    });
    System.out.println("=============");
    /* handle(BiFunction)
     * 정상 동작 했을 때와 에러일 때 두경우 모두 사용할 수 있다.
     */
    CompletableFuture<String> hello3 = CompletableFuture.supplyAsync(() -> {
      if (throwError) {
        throw new IllegalArgumentException();
      }

      System.out.println("Hello " + Thread.currentThread().getName());
      return "Hello";
    }).handle((result, ex) -> {
      if(ex != null) {
        System.out.println(ex);
        return "ERRROR!";
      }
      return result;
    });
    System.out.println(hello3.get());
  }

  private static CompletableFuture<String> getWorld(String message) {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("World " + Thread.currentThread().getName());
      return message + " World";
    });
  }
}
