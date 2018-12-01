package com.liwx.algorithm.easy;

/**
 * liwenxing
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 */
public class ErgeTwoSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        while (l1 != null || l2 != null) {
            int value = 0;
            if (l1 == null) {
                value = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                value = l1.val;
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    value = l1.val;
                    l1 = l1.next;
                } else {
                    value = l2.val;
                    l2 = l2.next;
                }
            }
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        temp.next = null;
        return listNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
