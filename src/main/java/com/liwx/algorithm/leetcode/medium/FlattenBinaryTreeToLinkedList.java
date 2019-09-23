package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.util.TreeNode;

/**
 * @author liwenxing
 * @date 9/23/19 8:33 PM
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode pre) {
        System.out.println(root.val);
        if (root == null) return pre;
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }
}
