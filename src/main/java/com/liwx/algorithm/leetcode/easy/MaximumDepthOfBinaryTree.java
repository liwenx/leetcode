package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.util.TreeNode;

/**
 * @author liwenxing
 * @date 2019/3/11 20:25
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
