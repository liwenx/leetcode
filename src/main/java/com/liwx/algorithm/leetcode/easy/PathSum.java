package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.util.TreeNode;

/**
 *
 * https://leetcode.com/problems/path-sum/
 *
 * @author liwenxing
 * @date 9/18/19 7:56 PM
 */
public class PathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum -root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum -root.val);
    }
}
