package com.liwx.basic;

/**
 * @author liwenxing
 * @date 2018/3/1 13:40
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "aaa";
        System.out.println(str1.hashCode());
        String str2 = "aaa";
        System.out.println(str2.hashCode());
        String str3 = new String("aaa");
        System.out.println(str3.hashCode());
        String str4 = new StringBuffer().append("aaa").toString();
        System.out.println(str4.hashCode());

        String a = "aaa";
        a += "bbb";
        System.out.println(a);
    }
}
