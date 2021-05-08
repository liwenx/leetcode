package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.ListNode;
import com.liwx.algorithm.leetcode.util.TreeNode;

/**
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @author liwenxing
 * @date 9/17/19 9:30 PM
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }
}
