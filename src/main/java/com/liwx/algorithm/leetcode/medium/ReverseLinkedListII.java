package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.util.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * @author liwenxing
 * @date 8/14/19 7:36 PM
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {

    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = head;
        int i = 1;
        while (i < m) {
            prev = curr;
            curr =  curr.next;
            i++;

        }
        ListNode node = prev; //记录第m-1个节点
        while (i<=n) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }
        node.next.next = curr;
        node.next = prev;
        return fakeHead.next;
    }

}
