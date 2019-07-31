package com.liwx.algorithm.medium;

import com.liwx.algorithm.util.ListNode;

/**
 * @author liwenxing
 * @date 2018/12/21 11:31
 * <p>
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {


    public static void main(String[] args) {
        ListNode six = new ListNode(6);
        six.next = null;
        ListNode five = new ListNode(5);
        five.next = six;
        ListNode four = new ListNode(4);
        four.next = five;
        ListNode three = new ListNode(3);
        three.next = four;
        ListNode two = new ListNode(2);
        two.next = three;
        ListNode one = new ListNode(1);
        one.next = two;

        ListNode res = swapPairs(one);
        while (res != null) {
            System.out.println(res.val + ",");
            res =res.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head ==null || head.next == null) {
            return head;
        }
        ListNode resNode = new ListNode(0);
        ListNode preNode = new ListNode(0);
        resNode.next = head;
        preNode.next = head;
        if (head != null && head.next != null) {
            resNode.next = head.next;
        }
        while (head != null && head.next != null) {
            preNode.next = head.next;
            head.next = preNode.next.next;
            preNode.next.next = head;
            preNode = preNode.next.next;
            head = head.next;
        }
        return resNode.next;
    }


}
