package com.liwx.designpattern.singleton;

/**
 * @author liwenxing
 * @date 2018/3/25 14:32
 */

/**
 * 通过静态内部类的方式 实现懒汉式单例 线程安全
 *
 * Java静态内部类的特性是，加载的时候不会加载内部静态类，使用的时候才会进行加载。而使用到的时候类加载又是线程安全的，
 *
 */
public class InnerClassSingleton {
    //内部类方式
    private static class SingletonHandler {
        private static InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

    private InnerClassSingleton(){
    }

    public static InnerClassSingleton getInstance(){
        return SingletonHandler.innerClassSingleton;
    }

}
