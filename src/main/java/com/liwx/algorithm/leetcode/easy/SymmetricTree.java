package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.leetcode.util.TreeNode;

/**
 *
 * https://leetcode.com/problems/symmetric-tree/
 *
 * @author liwenxing
 * @date 8/27/19 9:01 PM
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }

    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return p.val == q.val && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }
}
