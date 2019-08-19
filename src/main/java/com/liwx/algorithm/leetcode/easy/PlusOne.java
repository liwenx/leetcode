package com.liwx.algorithm.leetcode.easy;

/**
 *
 * https://leetcode.com/problems/plus-one/
 *
 * @author liwenxing
 * @date 8/1/19 3:49 PM
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        System.out.println(plusOne(digits));
    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length -1;
        digits[i]++;
        while (digits[i] > 9 && i > 0) {
            digits[i-1] += (digits[i] / 10);
            digits[i] %= 10;
            i--;
        }
        if (digits[0] > 9) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

}
