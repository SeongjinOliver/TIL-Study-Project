package me.oliver.java8to11.DateTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class PeriodApp {

  /**
   * Period는 사람용 시간을 비교 Duration은 기계용 시간을 비교
   * @param args
   */
  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    LocalDate thisYearBirthday = LocalDate.of(2020, Month.DECEMBER, 31);

    java.time.Period period = java.time.Period.between(today, thisYearBirthday);
    System.out.println(period.getDays());

    java.time.Period until = today.until(thisYearBirthday);
    System.out.println(until.get(ChronoUnit.DAYS));
  }
}
