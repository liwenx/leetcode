package com.liwx.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liwenxing
 * @date 2018/11/6 18:57
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = - nums[i];
            while (j < k) {
                if (target == nums[j] + nums[k]) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j ++;
                    k --;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j ++;
                    }
                    while (j < k && nums[k] == nums[k + 1] ) {
                        k --;
                    }
                } else if (nums[j] + nums[k] > target) {
                    k --;
                } else {
                    j ++;
                }
            }
        }
        return result;
    }


}
