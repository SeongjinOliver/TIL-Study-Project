package FactoryMethod;

import FactoryMethod.style.chicago.ChicagoPizzaStore;
import FactoryMethod.style.newyork.NYPizzaStore;

public class PizzaTestDrive {

  public static void main(String[] args) {
    PizzaStore nyStore = new NYPizzaStore();
    PizzaStore chicagoStore = new ChicagoPizzaStore();

    Pizza nyStylePizza = nyStore.createPizza("cheese");
    System.out.println(nyStylePizza.getName());
    System.out.println();
    Pizza chicagoStylePizza = chicagoStore.orderPizza("cheese");
    System.out.println(chicagoStylePizza.getName());
  }
}
