package me.oliver.java8to11;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {

  public static void main(String[] args) {
//    // 익명 내부 클래스 anonymous inner class
//    RunSomething runSomething = (number) -> number + 10;
//    System.out.println(runSomething.doIt(1));
//    System.out.println(runSomething.doIt(1));
//    System.out.println(runSomething.doIt(1));
//
//    System.out.println(runSomething.doIt(2));
//    System.out.println(runSomething.doIt(2));
//    System.out.println(runSomething.doIt(2));
    //--------------------------------
    Function<Integer, Integer> plus10 = (i) -> i + 10;
    Function<Integer, Integer> multiply2 = (i) -> i * 2;
//    Plus10 plus10 = new Plus10();
    System.out.println(plus10.apply(1));
    System.out.println(multiply2.apply(1));

    /**
     * 위 2개의 Function을 조합할 수 있음
     * <p>
     * plus10.compose(multiply2).apply(2);
     * 먼저 multiply2를 계산하고 그 결과 값을 가지고 plus10을 계산
     * <p>
     * plus10.andThen(multiply2).apply(2)
     * 먼저 plus10 계산한 결과를 가지고 multiply2를 계산
     */
    Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
    System.out.println(multiply2AndPlus10.apply(2));

    System.out.println(plus10.andThen(multiply2).apply(2));

    // 받기만 하고 리턴을 하지 않음
    Consumer<Integer> printT = (i) -> System.out.println(i);
    printT.accept(10);

    // 값을 직접 받지 않고 받아올 값을 정의
    // 무조건 10을 리턴
    Supplier<Integer> get10 = () -> 10;
    System.out.println(get10);

    // 어떠한 인자값을 하나 받아서 true, false를 받음
    Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
    // 작수인지 확인하는 함수를 만듦.
    Predicate<Integer> isEven = (i) -> i%2 == 0;

    // 아래와 같이 2개의 인자가 같을 때는 UaryOperator를 사용할 수 있음
    Function<Integer, Integer> test = plus10.compose(multiply2);
    UnaryOperator<Integer> plus2 = (i) -> i + 2;
    System.out.println(multiply2AndPlus10.apply(2));

    System.out.println(plus10.andThen(multiply2).apply(2));
  }
}
