package com.liwx.algorithm.leetcode.easy;

/**
 * https://leetcode.com/problems/single-number/
 *
 * @author liwenxing
 * @date 7/24/19 5:58 PM
 */
public class SingleNumber {

    public static void main(String[] args) {
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
