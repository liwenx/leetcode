package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.leetcode.util.ListNode;

/**
 * @author liwenxing
 * @date 2019/3/11 20:16
 * <p>
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
