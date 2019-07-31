package com.liwx.algorithm.medium;

import com.liwx.algorithm.util.ListNode;

/**
 * @author liwenxing
 * @date 2018/7/2 22:07
 * <p>
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        //这一步很关键，保存链表头部节点
        ListNode l3 = result;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            l3.next = new ListNode(carry%10);
            carry /= 10;
            l3 = l3.next;
        }
        l3 = null;
        return result.next;
    }

    public static void main(String[] args) {

    }
}
