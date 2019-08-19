package com.liwx.algorithm.leetcode.easy;

/**
 *
 * https://leetcode.com/problems/maximum-subarray/
 *
 *
 * @author liwenxing
 * @date 7/29/19 8:11 PM
 */
public class MaximumSubarray {
    public static void main(String[] args) {

    }
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            result = Math.max(result, maxEndingHere);
        }
        return result;
    }
}
