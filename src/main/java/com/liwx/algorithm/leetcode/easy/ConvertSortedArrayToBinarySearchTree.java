package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.leetcode.util.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author liwenxing
 * @date 9/17/19 9:19 PM
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return helper(nums, 0 , nums.length -1);
    }
    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid -1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }

}
