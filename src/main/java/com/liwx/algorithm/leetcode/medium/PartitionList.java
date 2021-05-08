package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.ListNode;

/**
 *
 * https://leetcode.com/problems/partition-list/
 *
 * @author liwenxing
 * @date 8/9/19 5:22 PM
 */
public class PartitionList {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode lHead = new ListNode(0);
        ListNode rHead = new ListNode(0);
        ListNode lNewNode = lHead;
        ListNode rNewNode = rHead;
        while (head != null) {
            if (head.val < x) {
                lNewNode.next = head;
                lNewNode = lNewNode.next;
            } else {
                rNewNode.next = head;
                rNewNode = rNewNode.next;
            }
            head = head.next;
        }
        lNewNode.next = rHead.next;
        rNewNode.next = null;
        return lHead.next;
    }
}
