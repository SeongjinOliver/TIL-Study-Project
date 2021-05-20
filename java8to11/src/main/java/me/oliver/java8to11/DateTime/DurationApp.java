package me.oliver.java8to11.DateTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DurationApp {

  /**
   * Period는 사람용 시간을 비교 Duration은 기계용 시간을 비교
   * @param args
   */
  public static void main(String[] args) {
    Instant now = Instant.now();
    Instant plus = now.plus(10, ChronoUnit.SECONDS);
    Duration between = Duration.between(now, plus);
    System.out.println(between.getSeconds());

    LocalDateTime now1 = LocalDateTime.now();
    // custom하게 할 수 있고 정해져 있는거 사용해도 된다.
    DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    System.out.println(MMddyyyy);
  }
}
