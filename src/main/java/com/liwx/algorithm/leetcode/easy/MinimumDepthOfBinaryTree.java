package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.leetcode.util.TreeNode;

/**
 * @author liwenxing
 * @date 9/18/19 7:43 PM
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

}
