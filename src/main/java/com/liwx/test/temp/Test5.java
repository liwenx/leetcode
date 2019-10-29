package com.liwx.test.temp;

/**
 * @author liwenxing
 * @date 10/22/19 2:08 PM
 */
public class Test5 {
    public static void main(String[] args) {
        Long currentTimestamps=System.currentTimeMillis();
        Long oneDayTimestamps= Long.valueOf(60*60*24*1000);
        System.out.println(currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps);
    }
}
