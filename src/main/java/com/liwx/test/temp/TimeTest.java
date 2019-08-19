package com.liwx.test.temp;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Set;

/**
 * @author liwenxing
 * @date 2018/11/10 15:12
 */
public class TimeTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.lengthOfMonth());
        System.out.println(today.get(ChronoField.YEAR));
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalDateTime nowDateTime  = LocalDateTime.now();
        System.out.println(nowDateTime);
        System.out.println(nowDateTime.plusYears(2));

        System.out.println( today.plusDays(30));
//        System.out.println(LocalDate.parse("20181011"));
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Instant.ofEpochSecond(2, 1000000000).getEpochSecond());
        LocalDate localDate = LocalDate.parse("20181101",DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

        LocalDateTime newDate = ldt.parse(strDate2, dtf2);
        System.out.println(newDate);

        //对时区的操作ZonedDate/ZonedTime/ZonedDateTime
        Set<String> set = ZoneId.getAvailableZoneIds();
//        set.forEach(System.out::println);

        LocalDateTime ldt3 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt3);

        LocalDateTime ldt4 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ldt4.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);

        System.out.println(Period.ofDays(10).getYears());
        System.out.println("ubuntu root commit test");

    }
}
