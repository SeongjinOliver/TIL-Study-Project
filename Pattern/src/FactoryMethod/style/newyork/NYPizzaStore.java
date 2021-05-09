package FactoryMethod.style.newyork;

import FactoryMethod.Pizza;
import FactoryMethod.PizzaStore;

public class NYPizzaStore extends PizzaStore {
  @Override
  public Pizza createPizza(String type) {
    Pizza pizza = null;
    if(type.equals("cheese")) pizza = new NYStyleCheesePizza();
//    if(type.equals("pepper")) pizza = new NYStylePepperoniPizza();
//    if(type.equals("calm")) pizza = new NYStyleClamPizza();
//    if(type.equals("veggie")) pizza = new NYStyleVeggiePizza();
    return pizza;
  }
}
