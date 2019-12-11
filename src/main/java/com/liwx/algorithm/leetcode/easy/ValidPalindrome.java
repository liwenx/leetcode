package com.liwx.algorithm.leetcode.easy;

/**
 *
 * https://leetcode.com/problems/valid-palindrome/
 *
 * @author liwenxing
 * @date 2019/12/11 下午2:53
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() -1; // head 头部 tail 尾部
        char cHead, cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
