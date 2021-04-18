package com.liwx.test.basic;

public class Interface1Impl implements Interface1,Interface2{
    @Override
    public void test1(Integer a) {
        System.out.println("integer");
    }

    @Override
    public void test1(int a) {
        System.out.println("int");
    }
}
