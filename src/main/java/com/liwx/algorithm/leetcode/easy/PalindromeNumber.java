package com.liwx.algorithm.leetcode.easy;

/**
 * @author liwenxing
 * @date 2018/6/25 22:29
 *
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        boolean result = false;
        if (x < 0) {
            return result;
        }
        int y = 0,z = x;
        while (z != 0) {
            y = y*10 + z%10;
            z /= 10;
        }
        if (x == y ) {
            result = true;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(1534236461));
        System.out.println(isPalindrome(123454321));
    }
}
