package com.liwx.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/permutations/
 *
 * @author liwenxing
 * @date 7/23/19 7:13 PM
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> resList = permute2(nums);
        System.out.println(resList.size());
        resList.forEach(l -> System.out.println(l));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length == 0) {
            return resList;
        }
        List<Integer> list0 = new ArrayList<>();
        list0.add(nums[0]);
        resList.add(list0);
        for (int i = 1; i < nums.length; ++i) {
            List<List<Integer>> res_list_temp = new ArrayList<>();
            for (int j = 0; j <=i; ++j) {
                for (List<Integer> l : resList) {
                    List<Integer> new_l = new ArrayList<>(l);
                    new_l.add(j, nums[i]);
                    res_list_temp.add(new_l);
                }
            }
            resList = res_list_temp;
        }

        return resList;
    }

    /**
     * 回溯算法
     * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     */
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        generatePermution(nums, used, 0, len, new Stack<>(), res);
        return res;
    }

    //curSize表示当前的path里面有多少个元素
    private static void generatePermution(
            int[] nums, boolean[] visited, int curSize,
            int len, Stack<Integer> path,List<List<Integer>> res) {
        if (curSize == len) {
            //此时path已经保存了nums中的所有数字，已经成为了一个排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                //回溯的时候，一定要将状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }

}
