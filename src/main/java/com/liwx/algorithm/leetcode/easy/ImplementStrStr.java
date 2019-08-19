package com.liwx.algorithm.leetcode.easy;

/**
 * @author liwenxing
 * @date 2019/1/10 20:47
 * <p>
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        strStr("hello", "ll");
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
