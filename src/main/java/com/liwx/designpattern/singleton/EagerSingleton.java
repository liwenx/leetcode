package com.liwx.designpattern.singleton;

/**
 * @author liwenxing
 * @date 2018/2/14 10:25
 */

/**
 * 饿汉式单例，在定义静态变量时实例化单例类，在类加载的时候已经创建了单例对象
 */
public class EagerSingleton {
    private static final EagerSingleton instance  = new EagerSingleton();
    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}
