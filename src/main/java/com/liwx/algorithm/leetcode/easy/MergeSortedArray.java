package com.liwx.algorithm.leetcode.easy;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @author liwenxing
 * @date 8/9/19 5:39 PM
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1)
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        while (j > -1)
            nums1[k--] = nums2[j--];
    }
}
