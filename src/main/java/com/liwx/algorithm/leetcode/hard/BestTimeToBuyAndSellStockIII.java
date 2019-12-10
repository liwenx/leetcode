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
            buy1 = Math.max(buy1, -prices[i]);         // -------①
            sell1 = Math.max(sell1, buy1 + prices[i]); // -------②
            buy2 = Math.max(buy2, sell1 - prices[i]);  // -------③
            sell2 = Math.max(sell2, buy2 + prices[i]); // -------④
        }
        return sell2;
    }

    /**
     * 这个写法和上面那个 都是正确做法
     *
     * buy1 sell1 buy2 sell2 这四个操作 在一个循环里最多出现一次
     *
     * 所以上面和下面的代码 是一致的
     *
     * 所以①②③④ 这四个语句，顺序无所谓，可以打乱
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int sell1 = 0, sell2=0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            sell2 = Math.max(sell2, buy2 + prices[i]); // -------④
            buy2 = Math.max(buy2, sell1 - prices[i]);  // -------③
            sell1 = Math.max(sell1, buy1 + prices[i]); // -------②
            buy1 = Math.max(buy1, -prices[i]);         // -------①
        }
        return sell2;
    }
}
