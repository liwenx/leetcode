package com.liwx.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/subsets/
 *
 * @author liwenxing
 * @date 8/5/19 7:28 PM
 */
public class Subsets {
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }
    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j ++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() -1);
        }
    }


}
