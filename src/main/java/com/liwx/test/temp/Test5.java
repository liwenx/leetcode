package com.liwx.test.temp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author liwenxing
 * @date 10/22/19 2:08 PM
 */
public class Test5 {
    public static void main(String[] args) {
//        Long currentTimestamps=System.currentTimeMillis();
//        Long oneDayTimestamps= Long.valueOf(60*60*24*1000);
//        System.out.println(currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps);
//        SubClass subClass = new SubClass();
//        subClass.sout1();
//        long now = new Date().getTime();
//        System.out.println(now);
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String arriveTime = ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));
        System.out.println(arriveTime);
    }
}
