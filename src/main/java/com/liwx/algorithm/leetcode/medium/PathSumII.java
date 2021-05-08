package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liwenxing
 * @date 9/23/19 7:56 PM
 */
public class PathSumII {
    public static void main(String[] args) {
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> currentResult = new LinkedList<>();
        pathSumHepler(root, sum, currentResult, result);
        return result;
    }
    public void pathSumHepler(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        currentResult.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);
            return;
        } else {
            pathSumHepler(root.left, sum - root.val, currentResult, result);
            pathSumHepler(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
}
