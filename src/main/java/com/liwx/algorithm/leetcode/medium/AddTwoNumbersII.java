package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 *  链表 两数相加 II
 * @author liwenxing
 * @date 2021/5/9 16:32
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        while (l1 != null) {
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.push(l2.val);
            l2 = l2.next;
        }
        int temp = 0;
        ListNode res = null;
        while (!deque1.isEmpty() || !deque2.isEmpty() || temp != 0) {
            int a = deque1.isEmpty() ? 0 : deque1.pop();
            int b = deque2.isEmpty() ? 0 : deque2.pop();
            int val = a + b + temp;
            ListNode currNode = new ListNode(val % 10);
            temp = val / 10;
            currNode.next = res;
            res = currNode;
        }

        return res;
    }
}
