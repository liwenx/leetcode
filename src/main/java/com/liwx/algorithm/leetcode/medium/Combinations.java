package com.liwx.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/combinations/
 *
 * @author liwenxing
 * @date 8/1/19 9:15 PM
 */
public class Combinations {
    List<List<Integer>> output = new ArrayList<>();
    int n;
    int k;


    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.combine(4, 2);
        result.forEach(integers -> System.out.println(integers.toString()));
    }

    public void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
        }
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return output;
    }
}
