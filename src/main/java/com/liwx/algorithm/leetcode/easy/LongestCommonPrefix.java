package com.liwx.algorithm.leetcode.easy;

/**
 * @author liwenxing
 * @date 2018/11/4 20:23
 *
 * https://leetcode.com/problems/longest-common-prefix/
 *
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String minWord = strs[0];
        for (int i = 0; i < strs.length; i ++) {
            if (strs[i].length() < minWord.length()) {
                minWord = strs[i];
            }
        }

        while (minWord.length() > 0) {
            boolean isTrue = true;
            for (int i = 0; i < strs.length; i ++) {
                if (!strs[i].startsWith(minWord)) {
                    isTrue = false;
                    break;
                }
            }
            if (!isTrue) {
                minWord = minWord.substring(0, minWord.length() - 1);
            } else {
                break;
            }
        }
        return minWord;
    }
}
