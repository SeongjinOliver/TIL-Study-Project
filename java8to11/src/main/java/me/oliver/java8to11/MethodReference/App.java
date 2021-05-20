package me.oliver.java8to11.MethodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

  public static void main(String[] args) {

    // 생성자 참조
    Supplier<Greeting> newGreeting = Greeting::new; // 이 자체로는 아무런 일도 벌어지지 않는다.
    Greeting greeting1 = newGreeting.get(); // 이렇게 해야 얻어지는것이다.

    // 인스턴스 메서드 참조
    Greeting greeting = new Greeting();
    UnaryOperator<String> hello = greeting::hello; // 메서드를 호출한것이 아님 아무런 일도 벌어지지 않는다.
    System.out.println(hello.apply("keesun")); // 이렇게 해야 사용하게 되는것이다.

    //UnaryOperator<String> hi = (s) -> "hi" + s;
    // static method 참조
    UnaryOperator<String> hi = Greeting::hi;

    /**
     * *************************************************
     */

    // 이 두개가 같아 보이지만 다른 참조를 사용한다.
    Function<String, Greeting> keesunGreeting = Greeting::new; // 문자열을 받는 생성자를 참조
    Greeting keesun = keesunGreeting.apply("keesun");
    System.out.println(keesun.getName());
    Supplier<Greeting> newGreeting1 = Greeting::new; // 문자열을 받지 않는 생성자를 참조

    /**
     * *************************************************
     */
    String[] names = {"keesun", "whiteship", "toby"};
    Arrays.sort(names, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(names));
  }
}
