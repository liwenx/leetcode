package com.liwx.algorithm.common.tree;

import com.liwx.algorithm.util.TreeNode;

import java.util.Stack;

/**
 *
 * 遍历二叉树
 *
 * @author liwenxing
 * @date 8/19/19 8:11 PM
 */
public class BinaryTreeTraversal {

    /**
     * 递归先序遍历
     */
    public static void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + " ");
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    /**
     * 非递归先序遍历
     * @param root
     */
    public static void preorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();

    }

}
