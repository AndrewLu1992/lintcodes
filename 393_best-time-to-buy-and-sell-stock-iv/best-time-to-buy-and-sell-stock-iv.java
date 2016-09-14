/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iv
@Language: Java
@Datetime: 16-08-01 08:58
*/

class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    //The combination of #II and #III.
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (k == 0) {
            return 0;
        }
        //if k > n / 2: whenever prices goes up, sell all holds.
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        // Dynamic Programming
        int n = prices.length;
        int[][] mustSellAti = new int[n][k + 1];
        int[][] best = new int[n][k + 1];
        
        //initialization
        for (int i = 0; i < k + 1; i++) {
            mustSellAti[0][i] = 0;
            best[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            mustSellAti[i][0] = 0;
            best[i][0] = 0;
        }
        
        //Compute:
        for (int i = 1; i < n; i++) {
            int gainOrLose = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                //local best: must sell stocks at i in # of j transactions.
                mustSellAti[i][j] = Math.max(best[i - 1][j - 1] + 
                    Math.max(0, gainOrLose), mustSellAti[i - 1][j] + 
                    gainOrLose);
                best[i][j] = Math.max(best[i - 1][j], mustSellAti[i][j]);
            }
        }
        return best[n - 1][k];
    }
};