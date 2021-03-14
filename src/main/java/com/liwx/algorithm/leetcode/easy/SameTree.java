package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.util.TreeNode;

/**
 *
 * https://leetcode.com/problems/same-tree/
 *
 * @author liwenxing
 * @date 8/27/19 8:53 PM
 */
public class SameTree {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
