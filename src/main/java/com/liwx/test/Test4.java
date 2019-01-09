package com.liwx.test;

import java.math.BigDecimal;

/**
 * @author liwenxing
 * @date 2018/12/27 14:47
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println( 0 == -0);
        BigDecimal bg = new BigDecimal(-0.0000001);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
}
