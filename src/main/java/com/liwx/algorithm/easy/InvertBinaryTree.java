package com.liwx.algorithm.easy;

/**
 * @author liwenxing
 * @date 2019/3/11 19:03
 * <p>
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode.com/problems/invert-binary-tree/discuss/62819/Easy-iterative-in-java
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null || root.right == null) {
            return root;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree2(root.left);
            invertTree2(root.right);
        }
        return root;
    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
