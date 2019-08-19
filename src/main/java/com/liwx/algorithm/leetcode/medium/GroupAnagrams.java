package com.liwx.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * @author liwenxing
 * @date 7/26/19 4:07 PM
 */
public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
        List<List<String>> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = resList.get(map.get(key));
            } else {
                t = new ArrayList<>();
                resList.add(t);
                map.put(key, resList.size() - 1);
            }
            t.add(s);
        }
        return resList;
    }
}
