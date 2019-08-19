package com.liwx.algorithm.leetcode.easy;

/**
 * https://leetcode.com/problems/sqrtx/
 *
 * @author liwenxing
 * @date 8/1/19 4:42 PM
 */
public class SqrtX {
    public static void main(String[] args) {

    }

    /**
     * 二分法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;

            }
        }
        return (int) left;
    }
}
