package com.liwx.test.temp;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author liwenxing
 * @date 19-6-5 上午10:49
 */
public class Map2StringTest {
    public static void main(String[] args) {
        Map<String, Object> map = new TreeMap<>();
        map.put("a", "ddddd");
        map.put("c", "bbbbb");
        map.put("d", "aaaaa");
        map.put("b", 222);

        //这里将map.entrySet()转换成list
        List<Map.Entry<String,Object>> list = new ArrayList<>(map.entrySet());
        //然后通过比较器来实现排序
        //升序排序
        Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
        System.out.println(JSON.toJSONString(list));
        StringBuffer sb = new StringBuffer("{");
        for(Map.Entry<String,Object> mapping:list){
            sb.append("\"").append(mapping.getKey()).append("\":\"").append(mapping.getValue()).append("\",");
        }
        sb.setCharAt(sb.length() - 1, '}');
        System.out.println(sb.toString());
        System.out.println("liwenxing mbp test");
    }
}
