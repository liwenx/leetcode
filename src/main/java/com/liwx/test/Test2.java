package com.liwx.test;

import java.math.BigDecimal;

/**
 * @author liwenxing
 * @date 2018/11/15 16:26
 */
public class Test2 {



    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(String.valueOf((8240-7635) * 100));
        BigDecimal b2 = new BigDecimal(String.valueOf(7635));

        double value = b1.divide(b2, 2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        System.out.println(value);

        System.out.println("merge test 2");
    }

}
