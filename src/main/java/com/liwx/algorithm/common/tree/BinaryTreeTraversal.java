package com.liwx.algorithm.common.tree;

import com.liwx.algorithm.leetcode.util.TreeNode;

import java.util.Stack;

/**
 *
 * 遍历二叉树
 *
 * 先序：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
 *
 * 中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
 *
 * 后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
 *
 * @author liwenxing
 * @date 8/19/19 8:11 PM
 */
public class BinaryTreeTraversal {

    /**
     * 参考：1.https://www.jianshu.com/p/456af5480cee
     *
     */
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
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                // 为了之后能找到该节点的右子树，暂存该节点
                System.out.println(node.val + " ");
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 递归中序遍历
     */
    public static void recursionMiddleorderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            System.out.println(root.val + " ");
            recursionMiddleorderTraversal(root.right);
        }
    }
    /**
     * 非递归中序遍历
     */
    public static void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node!= null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.println(node.val + " ");
                node = node.right;
            }
        }
    }

    /**
     * 递归后序遍历
     */
    public static void recursionPostorderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostorderTraversal(root.left);
            recursionPostorderTraversal(root.right);
            System.out.println(root.val + " ");
        }
    }

    /**
     * 非递归后序遍历
     *
     * 后序遍历在决定是否可以输出当前节点的值的时候，需要考虑其左右子树是否都已经遍历完成。
     *
     * @param root
     */
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.println(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }

}
