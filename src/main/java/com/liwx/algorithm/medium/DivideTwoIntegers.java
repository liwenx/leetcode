package com.liwx.algorithm.medium;

/**
 * @author liwenxing
 * @date 19-5-13 下午8:44
 *
 * https://leetcode.com/problems/divide-two-integers/
 *
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {

    }

    public static int divide(int dividend, int divisor) {
        //只有此条件下会溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs(dividend), dvs = Math.abs(divisor);
        int answer = 0;
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        while (dvd >= dvs) {
            long temp = dvs, m = 1;
            while (temp << 1 <= dvd) {
                temp <<= 1;
                m <<= 1;
            }
            dvd -= temp;
            answer += m;
        }
        return sign * answer;
    }
}
