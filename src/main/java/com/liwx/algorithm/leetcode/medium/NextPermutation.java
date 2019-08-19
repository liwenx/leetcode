package com.liwx.algorithm.leetcode.medium;

/**
 * @author liwenxing
 * @date 19-5-14 下午8:01
 *
 * https://leetcode.com/problems/next-permutation/
 *
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,9,10,6,5,4,3};
        nextPermutation(arr);
        System.out.println(arr);

    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        //找到下降序列第一个
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        System.out.println("i:" + i);
        if (i >= 0) {
            int j = nums.length -1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            System.out.println("j:" + j);
            swap(nums, i ,j);
        }
        reverse(nums, i+1, nums.length - 1);
    }
    public static void  swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
