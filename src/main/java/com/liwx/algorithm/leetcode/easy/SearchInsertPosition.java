package com.liwx.algorithm.leetcode.easy;

/**
 * @author liwenxing
 * @date 2019/5/27 22:53
 */
public class SearchInsertPosition {
    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0, mid, high = nums.length;
        while (low < high) {
            mid = low + (high - low)/2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
