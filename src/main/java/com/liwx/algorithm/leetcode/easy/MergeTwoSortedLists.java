package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.util.ListNode;

/**
 * liwenxing
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    /**
     * my answer
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * the one i think is very beautiful
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if( l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newList;
        if(l1.val < l2.val) {
            newList = l1;
            newList.next = mergeTwoLists2(l1.next, l2);
        } else {
            newList = l2;
            newList.next = mergeTwoLists2(l1,l2.next);
        }
        return newList;
    }
}
