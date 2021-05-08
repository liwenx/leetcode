package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.leetcode.util.ListNode;

/**
 * @author liwenxing
 * @date 2019/1/9 20:38
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nexNode = head.next;
        ListNode newHead = reverseList(nexNode);
        nexNode.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        // is there something to reverse?
        if (head != null && head.next != null) {
            ListNode pivot = head;
            ListNode frontier = null;
            while (pivot != null && pivot.next != null) {
                frontier = pivot.next;
                pivot.next = pivot.next.next;
                frontier.next = head;
                head = frontier;
            }
        }

        return head;
    }
}
