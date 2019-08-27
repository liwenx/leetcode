package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * @author liwenxing
 * @date 8/14/19 8:52 PM
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        middleorderTraversal(root, list);
        return list;
    }
    public static void middleorderTraversal(TreeNode root, List<Integer> list) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node!= null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }
}
