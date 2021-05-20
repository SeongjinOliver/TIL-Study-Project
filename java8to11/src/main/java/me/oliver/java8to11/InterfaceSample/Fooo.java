package me.oliver.java8to11.InterfaceSample;

import java.util.ArrayList;
import java.util.List;

public interface Fooo {

  void printName();

  /**
   * @implSpec
   * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
   *
   * 인터페이스들의 공통적인 요구사항들이 있다!!
   * 이전에는 메서드를 하나더 사용하면 인터페이스를 상속하는 모든 클래스에 에러가 났지만
   * 지금은 default 메소드를 사용해서 에러도 나지 않고 default메서드를 추가해서 사용할수 있다.
   */
  default void printNameUpperCase() {

    System.out.println(getName().toUpperCase());
  }

  String getName();

  static void printAnything() {
    System.out.println("Fooo");
  }

}
