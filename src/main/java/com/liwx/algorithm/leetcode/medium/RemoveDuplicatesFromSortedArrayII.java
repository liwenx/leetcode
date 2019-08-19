package com.liwx.algorithm.leetcode.medium;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author liwenxing
 * @date 2019/8/6 21:52
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int p = nums[0];
        int k = 1;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != p) {
                nums[k++] = nums[i];
                p = nums[i];
                j = 1;
            } else {
                j++;
                if (j == 2) {
                    nums[k++] = nums[i];
                }
            }
        }
        return k;
    }
}
