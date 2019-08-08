package com.liwx.algorithm.medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @author liwenxing
 * @date 8/8/19 7:22 PM
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int a = 3, b = 4;
        boolean result = ((a + b) / 2) == (a + (b - a) / 2);
        System.out.println(result);
        System.out.println((-1) / 2);
    }

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;
            //去重
            if (nums[mid] == nums[end]) {
                end--;
            } else if (nums[mid] < nums[end]) {
                // mid 到 right 是顺序数组
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // left 到 mid 是顺序数组
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
