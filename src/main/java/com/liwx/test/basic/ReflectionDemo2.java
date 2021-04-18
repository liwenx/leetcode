package com.liwx.test.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 泛型用在编译期，编译过后泛型擦除（消失掉），利用反射越过泛型检查
 * @author liwenxing
 * @date 2018/1/5 13:49
 */
public class ReflectionDemo2 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        Class listClass = strList.getClass();
        Method m = listClass.getMethod("add", Object.class);
        m.invoke(strList,100);
        for (Object obj : strList){
            System.out.println(obj);
        }

    }
}
