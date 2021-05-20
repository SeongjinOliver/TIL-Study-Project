package StreamSample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
      new Transaction(brian, 2011, 300),
      new Transaction(raoul, 2012, 1000),
      new Transaction(raoul, 2011, 400),
      new Transaction(mario, 2012, 710),
      new Transaction(mario, 2012, 700),
      new Transaction(alan, 2012, 950)
    );

    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
    transactions.stream()
        .filter(ts -> ts.getYear() == 2011)
        .sorted(Comparator.comparing(Transaction::getValue))
        .forEach(System.out::println);

    System.out.println("----------------------");
    // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
    transactions.stream()
        .map(ts -> ts.getTrader().getCity())
        .distinct()
        .forEach(System.out::println);

    System.out.println("----------------------");
    // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
    transactions.stream()
        .map(Transaction::getTrader)
        .filter(tr -> tr.getCity().equals("Cambridge"))
        .sorted(Comparator.comparing(Trader::getName))
        .forEach(System.out::println);

    System.out.println("----------------------");
    // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
    transactions.stream()
        .map(ts -> ts.getTrader().getName())
        .sorted()
        .forEach(System.out::println);

    System.out.println("----------------------");
    // 5. 밀라노에 거래자가 있는가?
    boolean milan = transactions.stream()
        .anyMatch(transaction -> transaction.getTrader()
                                            .getCity()
                                            .equals("Milan"));

    System.out.println("----------------------");
    // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
    transactions.stream()
        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
        .map(Transaction::getValue)
        .forEach(System.out::println);

    System.out.println("----------------------");
    // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
    transactions.stream()
        .map(transaction -> transaction.getValue())
        .reduce(Integer::max)
        .stream().collect(Collectors.toList()).forEach(System.out::println);

    System.out.println("----------------------");
    // 전체 트랜잭션 중 최솟값은 얼마인가?
    transactions.stream()
        .map(t -> t.getValue())
        .reduce(Integer::min)
        .stream().collect(Collectors.toList()).forEach(System.out::println);

    System.out.println("----------------------");
    // 피보나치
    IntSupplier fib = new IntSupplier() {
      private int previous = 0;
      private int current = 1;
      @Override
      public int getAsInt() {
        int oldPrevious = this.previous;
        int nextValue = this.previous + this.current;
        this.previous = this.current;
        this.current = nextValue;
        return oldPrevious;
      }
    };
    IntStream.generate(fib).limit(10).forEach(System.out::println);
  }
}

class Trader {
  private final String name;
  private final String city;

  public Trader(String name, String city) {
    this.name = name;
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  @Override
  public String toString() {
    return "Trader:" + this.name + " in " + this.city;
  }
}

class Transaction {

  private final Trader trader;
  private final int year;
  private final int value;

  public Transaction(Trader trader, int year, int value) {
    this.trader = trader;
    this.year = year;
    this.value = value;
  }

  public Trader getTrader() {
    return trader;
  }

  public int getYear() {
    return year;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "{" + this.trader + ", " +
        "year: " + this.year + ", " +
        "value:" + this.value + "}";
  }
}
