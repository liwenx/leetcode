package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.ListNode;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author liwenxing
 * @date 8/9/19 11:19 AM
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean deleteFlag = false;
        ListNode preHead = new ListNode(0);
        ListNode result = preHead;
        preHead.next = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                preHead.next = head.next;
                head = head.next;
                deleteFlag = true;
            } else if (deleteFlag) {
                preHead.next = head.next;
                head = head.next;
                deleteFlag = false;
            } else {
                preHead = head;
                head = head.next;
            }
        }
        if (deleteFlag) {
            preHead.next = null;
        }
        return result.next;
    }
}
