package com.liwx.designpattern.singleton.enumsingleton;

/**
 * @author liwenxing
 * @date 2018/12/3 20:31
 */
public enum EnumSingleton {
    INSTANCE;
    private EnumSingleton () {
        System.out.println("enum singleton init!");
    }
}
