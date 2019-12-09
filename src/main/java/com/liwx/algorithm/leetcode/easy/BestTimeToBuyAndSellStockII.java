package com.liwx.algorithm.leetcode.easy;

/**
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author liwenxing
 * @date 11/15/19 5:24 PM
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]) {
                total += prices[i+1] - prices[i];
            }
        }
        return total;
    }
}
