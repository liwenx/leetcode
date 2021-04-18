package com.liwx.test.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;


/**
 * @author liwenxing
 * @date 2018/1/5 10:32
 */
public class ReflectionDemo {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    // 去掉类名前面的包名
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            // 反射获得对象c所属类的方法
            Method[] methods = c.getMethods();
            // 反射获得对象c所属类的构造
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods)
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                for (Constructor ctor : ctors)
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
