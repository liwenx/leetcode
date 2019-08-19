package com.liwx.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/permutations-ii/
 *
 * @author liwenxing
 * @date 7/23/19 8:32 PM
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        return resList;
    }

    /**
     * 回溯算法
     * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return resList;
        }
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        findPermuteUnique(nums, 0, new Stack<>(), used, resList);
        return resList;
    }

    private static void findPermuteUnique(
            int[] nums, int depth, Stack<Integer> stack,
            boolean[] used, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                //因为排序后重复的数一定不会出现在开始，故i>0
                //和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同的分支
                //这种情况跳过即可
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                findPermuteUnique(nums, depth + 1, stack, used, res);
                stack.pop();
                used[i] = false;
            }
        }
    }
}
