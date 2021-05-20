package me.oliver.java8to11.ExcutorsSample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsServiceCollable {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Callable<String> hello = () -> {
      Thread.sleep(2000L);
      return "Hello";
    };

    /* helloFuture.isDone()
     * 끝났으면 True, 안끝났으면 False를 리턴
     * helloFuture.cancel()을 하게 되면 isDone()는 무조건 true가 된다.
     * */
    Future<String> helloFuture = executorService.submit(hello);
    System.out.println(helloFuture.isDone());
    System.out.println("Started!");

    // get을 만나는 순간 결과값을 가져올 때까지 기다린다. 위에서 Callable에서 2초를 주었기 때문에 2초동안 기다린다.
//    helloFuture.get();
    /* helloFuture.cancel(true)
    * 진행중인 작업을 cancel 할 수 있음.
    * true를 주면 interrupt할 수 있고.
    * false를 주면 기다리게 된다. 그리고 기다렸다 한들 helloFuture.get()해서 가져 올수가 없다. 에러가 난다.
    * */
    helloFuture.cancel(true);

    System.out.println(helloFuture.isDone());

    System.out.println("End!!");
    executorService.shutdown();
  }
}
