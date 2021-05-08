package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.ListNode;

/**
 * @author liwenxing
 * @date 2018/11/26 22:49
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for (int i = 1; i <= n + 1; i ++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

}
