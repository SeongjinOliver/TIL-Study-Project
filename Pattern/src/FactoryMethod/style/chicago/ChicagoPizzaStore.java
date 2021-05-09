package FactoryMethod.style.chicago;

import FactoryMethod.Pizza;
import FactoryMethod.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {

  @Override
  public Pizza createPizza(String type) {
    Pizza pizza = null;
    if(type.equals("cheese")) pizza = new ChicagoStyleCheesePizza();
//    if(type.equals("cheese")) pizza = new ChicagoStylePepperoniPizza();
//    if(type.equals("cheese")) pizza = new ChicagoStyleClamPizza();
//    if(type.equals("cheese")) pizza = new ChicagoStyleVeggiePizza();
    return pizza;
  }
}

