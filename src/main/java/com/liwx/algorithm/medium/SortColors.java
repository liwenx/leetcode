package com.liwx.algorithm.medium;

/**
 * https://leetcode.com/problems/sort-colors/
 *
 * @author liwenxing
 * @date 8/1/19 8:13 PM
 */
public class SortColors {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}
