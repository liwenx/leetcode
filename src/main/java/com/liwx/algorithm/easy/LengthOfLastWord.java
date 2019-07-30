package com.liwx.algorithm.easy;

/**
 *
 * https://leetcode.com/problems/length-of-last-word/
 *
 * @author liwenxing
 * @date 7/30/19 8:48 PM
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "h";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start)!= ' ') {
            start--;
        }
        return end - start;
    }
}
