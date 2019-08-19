package com.liwx.test.temp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liwenxing
 * @date 2018/11/6 14:32
 */
public class Test {

    public static void main(String args[]){
        A a = new B();
        test(a);//写出输出结果
        Map<String, String> map = new HashMap<>();
    }
    public static void test(A a){
        System.out.println("test A");
        a.whoAmI();
    }
    public static void test(B b){
        System.out.println("test B");
        b.whoAmI();
    }
}
class A {
    public void whoAmI() {
        System.out.println("I am A");
    }
}
class B extends A {
    public void whoAmI() {
        System.out.println("I am B");
    }

}
