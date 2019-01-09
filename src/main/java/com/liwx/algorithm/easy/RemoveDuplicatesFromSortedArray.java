package com.liwx.algorithm.easy;

/**
 * @author liwenxing
 * @date 2018/12/22 15:30
 *
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

    }

    /**
     * my answer
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i  = 0;  i < nums.length -1; i ++) {
            if (nums[i] != nums[i+1]) {
                nums[count]=nums[i+1];
                count++;
            }
        }
        return count;
    }

}
