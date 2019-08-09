package com.liwx.algorithm.easy;

import com.liwx.algorithm.util.ListNode;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author liwenxing
 * @date 8/9/19 2:32 PM
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;
    }
}
