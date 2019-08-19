package com.liwx.algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liwenxing
 * @date 2018/11/24 15:51
 */
public class FourSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        return findSum(nums, 0, 4, 0);
    }

    private static List<List<Integer>> findSum(int[] nums, int target, int count, int start) {
        List<List<Integer>> results = new LinkedList<>();
        if(count == 1) {
            for(int i = start; i < nums.length; i ++) {
                if(nums[i] == target) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    results.add(list);
                    break;
                }
            }
            return results;
        }

        for(int i = start; i <= nums.length - count; i ++) {
            if(target > 0 && nums[i] > target || target < 0 && nums[i] >= 0) {
                break;
            }
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> lists = findSum(nums, target - nums[i], count - 1, i + 1);
            for(List<Integer> list: lists) {
                list.add(0, nums[i]);
                results.add(list);
            }
        }

        return results;
    }
}
