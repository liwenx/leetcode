package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author liwenxing
 * @date 8/27/19 9:12 PM
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

    }
    /**
     * 题目分析：根据前序的第一个节点就可以确定二叉树的根节点，然后在中序序列中找到该节点。
     * 位于该节点左侧的是根节点的左子树，位于该节点右侧的是根节点的右子树。
     * 然后根据左右子树节点的数量可以在前序序列中知道各自子树的前序序列。
     * 假设左子树节点的数量为3，那么除了前序的第一个节点，往后数三个就是该左子树的节点的前序序列，
     * 相应地，后面的节点就是右子树节点的前序序列。
     *
     * 将preorder[pl.....pr]记作前序序列，将inorder[il.....ir]记作相应的中序序列，不断递归下去。
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1, preorder, inorder, inMap);
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder,int[] inorder, Map<Integer, Integer> inMap) {
        if (preStart > preorder.length -1 || inStart > inEnd) {
            return null;
        }
        TreeNode root =  new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder, inMap);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, inMap);
        return root;
    }
}
