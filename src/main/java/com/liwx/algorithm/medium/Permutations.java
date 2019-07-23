package com.liwx.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwenxing
 * @date 7/23/19 7:13 PM
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> resList = permute(nums);
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
}
