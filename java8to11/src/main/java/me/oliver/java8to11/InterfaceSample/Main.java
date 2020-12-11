package me.oliver.java8to11.InterfaceSample;

import me.oliver.java8to11.Foo;

public class Main {

  public static void main(String[] args) {

    Fooo fooo = new DefaultFoo("keesun");
    fooo.printName();
    fooo.printNameUpperCase();

    Fooo.printAnything();
  }
}
