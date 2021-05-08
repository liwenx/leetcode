package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * @author liwenxing
 * @date 7/31/19 7:37 PM
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode5.next = null;
//        listNode4.next = listNode5;
//        listNode3.next = listNode4;
//        listNode2.next = listNode3;
        listNode2.next = null;
        listNode1.next = listNode2;
        ListNode result = rotateRight(listNode1, 2);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode first = head;
        int length = 0;
        while (first != null) {
            length++;
            first = first.next;
        }
        if (k % length == 0) {
            return head;
        }
        first = head;
        int j = length - (k % length);
        while (first != null && j > 1) {
            first = first.next;
            j--;
        }
        ListNode result = first.next;
        first.next = null;
        first = result;
        while (first.next != null) {
            first = first.next;
        }
        first.next = head;
        return result;
    }

}
