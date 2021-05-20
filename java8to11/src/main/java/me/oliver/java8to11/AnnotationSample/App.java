package me.oliver.java8to11.AnnotationSample;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;

@Chicken("양념")
@Chicken("마늘간장")
public class App {

  public static void main(String[] args) {
//    Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
//    Arrays.stream(chickens).forEach(c -> {
//      System.out.println(c.value());
//    });

    ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
    Arrays.stream(chickenContainer.value()).forEach(c -> {
      System.out.println(c.value());
    });
  }
}
