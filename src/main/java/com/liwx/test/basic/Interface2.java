package com.liwx.basic;

public interface Interface2 {
    void test1(Integer a);
     void test1(int a);

    default String test2() {
        return "interface2 default";
    }
}
