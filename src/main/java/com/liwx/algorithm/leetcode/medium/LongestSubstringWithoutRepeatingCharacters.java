package com.liwx.algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liwenxing
 * @date 2018/7/2 22:49
 *
 * Longest Substring Without Repeating Characters
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i-1));
            }
            while (rk + 1 < n && ! occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
