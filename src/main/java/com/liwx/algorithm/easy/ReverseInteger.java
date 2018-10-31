package com.liwx.algorithm.easy;

/**
 * @author liwenxing
 * @date 2018/6/25 21:04
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 */
public class ReverseInteger {

    public static int reverse(int x) {
        long  result = 0;
        while (x != 0) {
            result  = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1534236461));
    }

}
