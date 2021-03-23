package com.liwx.designpattern.singleton;

/**
 * @author liwenxing
 * @date 2018/3/25 18:36
 */

/**
 * 通过静态代码块实现懒汉单例 线程安全
 *
 */
public class StaticBlockSingleton {
    private static StaticBlockSingleton instance = null;

    private StaticBlockSingleton(){
    }
    static {
        instance = new StaticBlockSingleton();
    }
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
