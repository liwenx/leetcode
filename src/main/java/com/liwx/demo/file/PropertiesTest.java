package com.liwx.demo.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author liwenxing
 * @date 2018/12/4 10:06
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        InputStream inStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\messages_zh_CN.properties"));
        Properties prop = new Properties();
        prop.load(new InputStreamReader(inStream, "UTF-8"));
        Map<String, String> map = new HashMap<>();
        prop.forEach((k,v) -> {
            map.put(String.valueOf(k),String.valueOf(v));
        });
        InputStream inStream2 = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\messages_en_US.properties"));
        Properties prop2 = new Properties();
        prop2.load(new InputStreamReader(inStream2, "UTF-8"));
        Map<String, String> map2 = new HashMap<>();
        List<KV> list = new LinkedList<>();
        prop2.forEach((k,v) -> {
            if (map.containsKey(String.valueOf(k))) {
                map2.put(map.get(String.valueOf(k)), String.valueOf(v));
                list.add(new KV(map.get(String.valueOf(k)), String.valueOf(v)));
            }
        });
//        map2.forEach((k,v) -> {
//            System.out.println(k + "\t" + v);
//        });
        list.forEach(kv -> {
            System.out.println(kv.getName() + "\t" + kv.getValue());
        });
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class KV {
        private String name;
        private String value;

    }
}
