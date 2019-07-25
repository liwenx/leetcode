package com.liwx.algorithm.medium;

/**
 * @author liwenxing
 * @date 7/24/19 6:02 PM
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = (a ^ nums[i]) & ~b;
            b = (b ^ nums[i]) & ~a;
        }
        return a;
    }
}
