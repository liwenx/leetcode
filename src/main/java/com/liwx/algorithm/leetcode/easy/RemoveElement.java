package com.liwx.algorithm.leetcode.easy;

/**
 * @author liwenxing
 * @date 2019/1/10 20:30
 *
 * https://leetcode.com/problems/remove-element/
 *
 */
public class RemoveElement {
    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val ) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
