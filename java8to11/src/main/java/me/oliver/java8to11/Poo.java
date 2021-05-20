package me.oliver.java8to11;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Poo {

  public static void main(String[] args) {
    Poo poo = new Poo();
    poo.run();
  }

  private void run() {
    /**
     * final이라는 키워드가 생략되어 있다. java8 부터는 생략할 수 있는데 사실상 변수가 final인 경우이면 생략할 수 있다.
     * 사실상 final -> 어디에서도 변수를 변경하지 않는 경우.
     * 이와 같은것을 java 매뉴얼에서는 effective final이라고 한다.
     * 이런 경우 로컬 클래스, 익명 클래스, 람다에서 모두 참조가 가능하다.
     * Local 클래스나, 익명 클래스는 쉐도잉이 가능(별도의 scope이기 때문에 가능)하지만 람다는 쉐도잉이 가능하지 않다.
     * <p>
     * 람다는 왜 쉐도잉이 가능하지 않냐면 사실상 run() 메소드와 scope이 같기 때문이다.
     * 쉐도잉은 로컬 또는 파라미터 변수가 외부 변수를 가린다고하여 쉐도잉이다.
     * 만약 람다에서 run 메소드에서 사용하는 로컬 변수를 파라미터로 사용하거나 람다 안에서 같은 이름의 변수를 사용하게 된다면
     * run() 메소드의 scope과 같은 scope라서 컴파일 에러가 난다.
     */

    int baseNumber = 10; // 캡처 기능 가능(익명, 내부 클래스에서도 사용된 개념)

    // 로컬 클래스
    class LocalClass {

      void printBaseNumber() {
        int baseNumber = 11;
        System.out.println(baseNumber); // 11
      }
    }

    // 익명 클래스
    Consumer<Integer> integerConsumer = new Consumer<Integer>() {
      @Override
      public void accept(Integer baseNumber) {
        System.out.println(baseNumber);
      }
    };

    // 람다
    IntConsumer printInt = (i) -> {
      System.out.println(i + baseNumber);
    };

    printInt.accept(10);
  }
}
