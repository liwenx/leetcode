package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.ListNode;

/**
 *
 * https://leetcode.com/problems/linked-list-cycle-ii
 *
 * @author liwenxing
 * @date 2019/12/18 下午4:07
 */
public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
