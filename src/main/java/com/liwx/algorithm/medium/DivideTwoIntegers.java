package com.liwx.algorithm.medium;

/**
 * @author liwenxing
 * @date 19-5-13 下午8:44
 * <p>
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));
//        System.out.println(divide(Integer.MIN_VALUE, 1));
    }

    /**
     * 会 Time Limit Exceeded
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        //只有此条件下会溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long) dividend), dvs = Math.abs(divisor);
        long answer = 0;
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
        return (int) (sign * answer);
    }

    public static int divide2(int dividend, int divisor) {
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }
        long lans = ldivide(ldividend, ldivisor);
        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private static long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

}
