/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock
@Language: Java
@Datetime: 16-06-20 10:46
*/

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < cost) {
                cost = prices[i];
            }
            if (prices[i] - cost > profit) {
                profit = prices[i] - cost;
            }
        }
        return profit;
    }
}