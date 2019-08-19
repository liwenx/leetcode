package com.liwx.algorithm.leetcode.hard;


/**
 * @author liwenxing
 * @date 2018-6-26 17:31:09
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 *
 * https://www.sohu.com/a/153858619_466939
 *
 */
public class InterleavingString {
    /**
     * 动态规划 空间复杂度O（n）
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] a  = new boolean[s1.length() + 1];
        a[0] =true;
        for (int i = 1 ; i < a.length; i ++) {
            a[i] = a[i-1] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int i = 1 ; i <= s2.length(); i ++) {
            a[0] = a[0] && (s2.charAt(i-1) == s3.charAt(i-1));
            for (int j = 1; j < a.length; j ++) {
                a[j] = (a[j] && s2.charAt(i-1) == s3.charAt(i + j -1))
                        || (a[j-1] && s1.charAt(j-1) == s3.charAt(i + j -1));
            }
        }

        return a[s1.length()];
    }

    /**
     * 动态规划 空间复杂度O(n*m) 二维表
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static  boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dynamic = new boolean[s1.length() + 1][s2.length() + 1];//length+1 考虑空字符串的情况
        dynamic[0][0] = true;//最开始，当两个字符串都是空时，成立
        for (int i = 1; i <=s1.length(); i ++) {//边界值
            dynamic[i][0] = dynamic[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i <=s2.length(); i ++) {//边界值
            dynamic[0][i] = dynamic[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        //
        for (int i = 1; i <= s1.length(); i ++) {
            for (int j = 1; j <=s2.length(); j ++) {
                int sum = i + j;
                dynamic[i][j] = (dynamic[i-1][j] && s1.charAt(i-1) == s3.charAt(sum-1))
                        || (dynamic[i][j-1] && s2.charAt(j-1) == s3.charAt(sum-1));
            }
        }

        return dynamic[s1.length()][s2.length()];
    }




	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
        System.out.println(isInterleave2(s1, s2, s3));
	}
}
