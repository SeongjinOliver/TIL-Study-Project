package FactoryMethod.style.chicago;

import FactoryMethod.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

  public ChicagoStyleCheesePizza() {
    this.name = "Chicago Style CheesePizza";
    this.dough = "Extra Thick Crust Dough";
    this.sauce = "Plum Tomato Sauce";
    this.toppings.add("Shredded mozzarella Cheese");
  }

  @Override
  public void cut() {
    System.out.println("Cutting the pizza into square slices");
  }
}
