package com.liwx.algorithm.leetcode.easy;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * @author liwenxing
 * @date 8/1/19 6:05 PM
 */
public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2;
        int i  = 3;
        int result = 0;
        while ( i <= n) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
            i++;
        }
        return result;
    }
}
