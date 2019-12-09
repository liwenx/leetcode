package com.liwx.algorithm.leetcode.hard;

/**
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author liwenxing
 * @date 12/9/19 7:09 PM
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2=0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
