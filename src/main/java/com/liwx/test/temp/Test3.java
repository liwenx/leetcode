package com.liwx.test.temp;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liwenxing
 * @date 2018/11/19 15:07
 */
public class Test3 {
    public static void main(String[] args) {

        @NotNull String name = null;
        System.out.println(name);
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        System.out.println(String.join(",", stringList));
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(integerList.stream().map(i -> Integer.toString(i)).collect(Collectors.joining("/")));

        System.out.println("merge test 3");
        System.out.println("test");
    }
}
