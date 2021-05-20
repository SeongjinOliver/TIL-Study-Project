package me.oliver.java8to11.ExcutorsSample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableMultiple {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
//    ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    Callable<String> hello = () ->  {
      Thread.sleep(2000L);
      return "Hello";
    };

    Callable<String> java = () ->  {
      Thread.sleep(3000L);
      return "Java";
    };

    Callable<String> keesun = () ->  {
      Thread.sleep(1000L);
      return "Keesun";
    };

    /* invokeAll
    * hello의 2초, java의 3초, keesun의 1초를 모두 기다린다. 결론은 가장 늦게 끝나는 java를 기다린다.
    * 예시) 모든 주가를 가져와서 계산할 때 이렇게 사용
    * */
    List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, keesun));
    for(Future<String> f : futures) {
      System.out.println(f.get());
    }
    /* invokeAny
    * 빨리 끝나는 순으로 출력이 된다.
    * 스레드를 newSingleThreadScheduledExecutor 이렇게 하면 안되고
    * newFixedThreadPool를 사용해서 3개 이상 스레드를 처리할 수 있는 용량이 되어야 확인이 가능하다.
    * ExecutorService executorService = Executors.newFixedThreadPool(3);
    * */
    String futures1 = executorService.invokeAny(Arrays.asList(hello, java, keesun));
    for(Future<String> f : futures) {
      System.out.println(f.get());
    }

    executorService.shutdown();
  }
}
