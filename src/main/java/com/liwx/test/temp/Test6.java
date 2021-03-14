package com.liwx.test.temp;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author liwenxing
 * @date 2020/1/6 下午3:51
 */
public class Test6 {
    public static void main(String[] args) throws UnknownHostException {
//        System.out.println(LocalDate.now().toString());
//        Integer a = 10;
//        Integer b = a;
//        a = 20;
//        System.out.println(a);
//        System.out.println(b);
//
//        List<Integer> list = new ArrayList<>();
//        list.add(a);
//        list.add(b);
//        list.add(null);
//        System.out.println(list.size());
//        System.out.println(list);
//        System.out.println(list.get(2));
//        System.out.println(StringUtils.join(list, ","));
//        for (int i = 0; i < 100; i++) {
//            Random random = new Random();
//            System.out.println(random.nextInt((9 - 0) + 1));
//        }
//        Integer a = null;
//        int b = a.intValue();
//        System.out.println(b);
//        System.out.println(new Date(System.currentTimeMillis()));
//        Integer a = null;
//        System.out.println();
//        BigDecimal bg = new BigDecimal(50);
//        bg = bg.divide(new BigDecimal(3), 0);
//        int prizeBase = bg.intValue();
//        System.out.println(prizeBase);

//        int a = 150;
//        Number b;
//        if (a % 100 == 0) {
//            b = a / 100;
//        } else {
//            b  = a / (float) 100;
//        }
//
//        System.out.println(b);

//        BigDecimal bg = new BigDecimal(532);
//        bg = bg.divide(new BigDecimal(100), 2);
//        System.out.println( String.format("%.2f", bg));
//        System.out.println(String.format("%.2f", (double) 532 / 100));
//        LocalDate localDate = LocalDate.now();
//        LocalDate localDate2 = Instant.ofEpochMilli(System.currentTimeMillis() + 24 * 60 * 60 * 1000).atZone(ZoneOffset.ofHours(8)).toLocalDate();
//        Period period = Period.between(localDate2, localDate);
//        System.out.println(localDate);
//        System.out.println(Bytes.toLong(Bytes.toBytesBinary("\\x00\\x00\\x01W\\xB8wr\\xD4")));

//        long time = 1591064320000L;
//        LocalDate firstVisitDate = Instant.ofEpochMilli(time).atZone(ZoneOffset.ofHours(8)).toLocalDate();
//        LocalDate now = LocalDate.now();
//        Period period = Period.between(firstVisitDate, now);
//        System.out.println(now.toEpochDay() - firstVisitDate.toEpochDay());
//        System.out.println(period.getDays() + 1);
//        int a = 11;
//        System.out.println(a&(a-1));
//        String a = "0123456";
//        System.out.println(a.substring(5,6));
//        String a = "123456789";
//        int l = a.length() - (2 % a.length());
//        l = 8;
//        System.out.println(a.substring(l,l+1));

//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= 100; i++) {
//            list.add(i);
//        }
//        System.out.println(list.subList(93, 102));
//        List<Long> miIds = new ArrayList<>();
//        miIds.add(3150067669L);
//        miIds.add(3150063052L);
//        miIds.add(3150060783L);
//        for (int i = 0; i < miIds.size(); i++) {
//            for (int j = 1; j <= 4; j++) {
//                for (int k = 1; k <= 4; k++) {
//                    System.out.print(getOptionalOrder(miIds.get(i), j, k) + "--");
//                }
//            }
//            System.out.print("\n");
//        }
//    }
//
//    public static int getOptionalOrder(long miId, long groupOrder, long questionOrder) {
//        String miIdStr = Long.toString(miId);
//        int pos = miIdStr.length() - ((int) groupOrder % miIdStr.length());
//        int a = Integer.parseInt(miIdStr.substring(pos % miIdStr.length(), (pos % miIdStr.length()) + 1));
//        return a % (int) questionOrder;
//    }
//        System.out.println(Long.toBinaryString((long) (Math.pow(2, 28) - 1)));

//        System.out.println(Integer.valueOf("GG",16));
//        String hostname = InetAddress.getLocalHost().getHostName();
//        System.out.println(hostname);
//        System.out.println(Math.pow(2, 28) - 1);
//        System.out.println(LocalDate.now().toString());

//        Integer a = null;
//        System.out.println(a.intValue());
//        for (int i = 0; i < 10; i++) {
//            System.out.println(System.currentTimeMillis());
//            System.out.println(System.currentTimeMillis() / 60000 * 60000);
//        }
//
//        String a= "aaa".substring(0,4);

//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate.toString());
//        List<Long> prizeGroupList = Arrays.stream(StringUtils.split("1,2,3",",")).map(NumberUtils::toLong).collect(Collectors.toList());
//        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0, 0)).);
//        System.out.println(1);
//        System.out.println(Math.pow(2, 28) - 1);
//        LocalDate localDate = Instant.ofEpochMilli(1614614400000L -1).atZone(ZoneOffset.ofHours(8)).toLocalDate();
//        int a = LocalDate.now().compareTo(localDate);
//        System.out.println(a);
//        double a = 56156 / (double) 556;
//        System.out.println(a);
//        System.out.println(Math.floor(a));
//        System.out.println(56155 / 556);
        long multiple = 101;
        long beforeCoinAmount = 5;
        long addAmount = (long) Math.ceil((multiple * beforeCoinAmount / (double)100)) - beforeCoinAmount;
        System.out.println(addAmount);
        System.out.println(LocalDate.now().toString().compareTo("2021-03-01"));
    }
}
