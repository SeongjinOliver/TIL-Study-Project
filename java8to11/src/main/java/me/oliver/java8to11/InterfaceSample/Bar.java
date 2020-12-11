package me.oliver.java8to11.InterfaceSample;

public interface Bar extends Fooo{
  /**
   *  Bar에서는 Fooo에서 제공하는 default 메소드를 구현하고 싶지 않다!!!!!!는 경우에는
   *  추상 메서드로 다시 구현하면 된다.
   */

  void printNameUpperCase(); // 이것을 선언 안하면 기본 구현체가 제공이 된다.

}
