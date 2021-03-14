package com.liwx.algorithm.leetcode.easy;

/**
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author liwenxing
 * @date 11/15/19 4:14 PM
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int sofarMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > sofarMin) {
                max = Math.max(max, prices[i] -sofarMin);
            } else {
                sofarMin = prices[i];
            }
        }
        return max;
    }

    /**
     * DP思想
     * 1.记录[今天之前买入的最小值]
     * 2.计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     * 3.比较【每天的最大获利】，取最大值即可
     */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
