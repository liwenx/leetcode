package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.leetcode.util.TreeNode;

/**
 * @author liwenxing
 * @date 9/18/19 7:25 PM
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return balancedHepler(root) != -1;
    }
    public int balancedHepler(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balancedHepler(root.left);
        int right = balancedHepler(root.right);
        if (left == -1 || right == -1 || Math.abs(left -right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
