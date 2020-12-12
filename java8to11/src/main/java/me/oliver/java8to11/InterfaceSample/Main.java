package me.oliver.java8to11.InterfaceSample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.oliver.java8to11.Foo;

public class Main {

  public static void main(String[] args) {

//    Fooo fooo = new DefaultFoo("keesun");
//    fooo.printName();
//    fooo.printNameUpperCase();
//
//    Fooo.printAnything();
//
    List<String> names = new ArrayList<>();
    names.add("keesun");
    names.add("whiteship");
    names.add("toby");
    names.add("foo");
//
//    // consumer를 받음.
//    names.forEach(System.out::println);
//    System.out.println();
//
//    // 쪼갤수 있는 기능을 가지고 있는 iterator.
//    Spliterator<String> spliterator = names.spliterator();
//    // trySplit을 하면은 반으로 쪼갠다.
//    Spliterator<String> spliterator1 = spliterator.trySplit();
//    while (spliterator.tryAdvance(System.out::println));
//    System.out.println("==========");
//    // tryAdvance() 이 괄호 안에도 역시 consumer를 받음.
//    while (spliterator1.tryAdvance(System.out::println));
//
    // Collection의 하위 인터페이스들은 모두 stream을 가지고 있다.
    long k = names.stream().map(String::toUpperCase)
        .filter(s -> s.startsWith("K"))
        .count();
    System.out.println(k);

    System.out.println("===============");
//    // k로 시작하는 것을 빼라
//    names.removeIf(s -> s.startsWith("k"));
//    names.forEach(System.out::println);

//    Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//    names.sort(compareToIgnoreCase.reversed());
//    System.out.println("=====================");

    // stream으로 처리하는 데이터는 변경되지 않는다.
    Stream<String> collect = names.stream().map(String::toUpperCase);

    // 출력 안된다. 중개형 operator들은 종료 operator가 없으면 실행을 하지 않는다. 현재는 정의만 되어있는 것임.
    List<String> collect1 = names.stream().map(s -> {
      System.out.println(s);
      return s.toUpperCase();
    }).collect(Collectors.toList());
    collect1.forEach(System.out::println);

    System.out.println("============");
    names.forEach(System.out::println);

    System.out.println("============");
  }
}
