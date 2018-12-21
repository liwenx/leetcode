package com.liwx.demo.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author liwenxing
 * @date 2018/11/6 23:15
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//        System.out.println(SuperClass.value);
        System.out.println(SuperClass.HELLOWORLD);
        System.out.println("ubuntu commit test");
        List<Long> longList = new ArrayList<>();
        longList.add(231L);
        longList.add(232L);
        longList.add(233L);
        System.out.println(new StringJoiner(",").add(""));
    }
}
