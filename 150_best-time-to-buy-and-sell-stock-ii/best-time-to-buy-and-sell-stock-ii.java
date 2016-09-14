/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Java
@Datetime: 16-06-21 12:03
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    //Algorithm: Whenever the stock goes up, I buy and sell by one step until
    //the next one goes down.
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
};