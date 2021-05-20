package FactoryMethod;

public abstract class PizzaStore {
  public Pizza orderPizza(String type) {
    Pizza pizza;

    pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }

  // Pizza 인스턴스를 만드는 일은 팩토리 역할을 하는 메소드에서 맡아 처리
  public abstract Pizza createPizza(String type);
}
