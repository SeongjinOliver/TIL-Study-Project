package me.oliver.java8to11.DateTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {

  public static void main(String[] args) {
    // Instant -> 기계용
//    Instant instant = Instant.now();
//    System.out.println(instant);
//    System.out.println(instant.atZone(ZoneId.of("UTC")));
//
//    ZoneId zone = ZoneId.systemDefault();
//    System.out.println(zone);
//    ZonedDateTime zonedDateTime = instant.atZone(zone);
//    System.out.println(zonedDateTime);

    // LocaDateTime -> 사람용
//    LocalDateTime now = LocalDateTime.now();
//    System.out.println(now);
//    LocalDateTime birthday = LocalDateTime.of(1991, Month.MARCH, 24, 0, 0, 0);
//    ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
//    System.out.println(nowInKorea);
//
//    Instant nowInstant = Instant.now();
//    ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
//    System.out.println(zonedDateTime1);

    // 기간
    LocalDate today = LocalDate.now();
    LocalDate thisYearyBirthday = LocalDate.of(2020, Month.MARCH, 24);

    /**
     * Period는 사람용 시간으로 비교, Duration은 기계용 시간으로 비교
     */
    // Period
//    Period period = Period.between(today, thisYearyBirthday);
//    System.out.println(period.getDays());
//
//    Period until = today.until(thisYearyBirthday);
//    System.out.println(until.get(ChronoUnit.DAYS));

    //Duration
//    Instant now = Instant.now();
//    Instant plus = now.plus(10, ChronoUnit.SECONDS);
//    Duration between = Duration.between(now, plus);
//    System.out.println(between.getSeconds());

    // DateTimeFormatter
    // Formatting
//    LocalDateTime now1 = LocalDateTime.now();
//    DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//    System.out.println(now1.format(MMddyyyy));

    // Parsing
//    LocalDate parse = LocalDate.parse("03/24/1991", MMddyyyy);
//    System.out.println(parse);

    Date date = new Date();
    Instant instant = date.toInstant();
    Date newDate = Date.from(instant);

    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
        .toLocalDateTime();

    ZonedDateTime dateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
    GregorianCalendar from = GregorianCalendar.from(dateTime1);

    ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
    TimeZone timeZone = TimeZone.getTimeZone(zoneId);

  }

}
