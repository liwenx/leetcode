package com.liwx.designpattern.singleton.enumsingleton;

/**
 * @author liwenxing
 * @date 2018/12/3 20:31
 */
public class Test {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        Singleton.getInstance().doSomething();
    }
}
