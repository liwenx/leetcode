package com.liwx.algorithm.easy;

/**
 * @author liwenxing
 * @date 2018/3/26 21:38
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum {

    public static void main(String[] args) {
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            if (nums == null || nums.length < 2) {
                return res;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp)) {
                    res[0] = map.get(temp);
                    res[1] = i;
                    return res;
                } else {
                    map.put(nums[i], i);
                }
            }
            return res;
        }
    }

}
