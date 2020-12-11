package me.oliver.java8to11.InterfaceSample;


public class DefaultFoo implements Fooo {

  String name;

  public DefaultFoo(String name) {
    this.name = name;
  }

  /**
   * default 메서드 재정의도 가능
   */
//  @Override
//  public void printNameUpperCase() {
//
//  }

  @Override
  public void printName() {

    System.out.println(this.name);
  }

  @Override
  public String getName() {
    return this.name;
  }
}
