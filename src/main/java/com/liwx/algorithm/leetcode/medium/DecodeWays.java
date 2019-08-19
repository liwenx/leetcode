package com.liwx.algorithm.leetcode.medium;

/**
 * @author liwenxing
 * @date 8/13/19 7:35 PM
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("121"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }
        return memo[0];
    }

    /*解法2*/

    /**
     * https://leetcode-cn.com/problems/decode-ways/solution/dong-tai-gui-hua-fen-lei-tao-lun-by-user8973/
     *
     * https://leetcode-cn.com/problems/decode-ways/solution/fei-bo-na-qi-si-lu-by-dingmin1860/
     */

    public int numDecodings2(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            //如果该位不为'0'，说明该位单独成字母合法
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
