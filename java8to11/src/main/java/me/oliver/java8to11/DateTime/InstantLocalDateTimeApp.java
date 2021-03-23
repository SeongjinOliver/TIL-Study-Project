package me.oliver.java8to11.DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantLocalDateTimeApp {

  public static void main(String[] args) {
    /**
     * Instant와 LocalDateTime은 서로 변환이 가능하다
     */
    /**
     * Instant
     * 기계용
     * 시간을 제거나 메서드 실행 시간을 비교하거나 할 때 사용하는 API
     */
    Instant instant = Instant.now();
    System.out.println(instant); // 기준시 UTC, GMT
    System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT

    ZoneId zone = ZoneId.systemDefault();
    System.out.println(zone);
    ZonedDateTime zonedDateTime = instant.atZone(zone);
    System.out.println(zonedDateTime);

    /**
     * LocalDateTime
     * 사람용
     */

    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    LocalDateTime of = LocalDateTime.of(1991, Month.MARCH, 24, 0, 0, 0);
    ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    System.out.println(nowInKorea);

    Instant nowInstant = Instant.now();
    ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
    System.out.println(zonedDateTime1);

  }
}
