package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author liwenxing
 * @date 9/17/19 8:37 PM
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {

    }
    /**
     * 题目分析：本题与“从前序与中序遍历序列构造二叉树”属于一个套路。
     * 唯一的区别是，我们是从后序序列的最后一个节点得到根节点，同样的，再去前序序列中找到这个节点。
     * 在这个节点左侧的属于根节点的左子树部分，右侧的属于根节点右子树部分。
     * 然后根据左右子树节点的数量，在后序序列中找到他们各自的后序序列。
     * 若左子树节点个数为3，那么在后序序列中前三个节点就是左子树节点，之后的节点除了最后一个节点都是右子树节点。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(inorder, inorder.length -1, 0 ,postorder, postorder.length-1, inMap);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, Map<Integer, Integer> inMap) {
        if (postStart < 0 || inStart < inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int rIndex = inMap.get(postorder[postStart]);
        root.right = helper(inorder, inStart, rIndex+1, postorder, postStart -1, inMap);
        root.left = helper(inorder, rIndex -1, inEnd, postorder, postStart - (inStart -rIndex) -1, inMap);
        return root;
    }

}
