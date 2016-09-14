/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 16-06-21 12:38
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    // O(n) space + O(n) time.
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] forward = new int[prices.length];
        int[] backward = new int[prices.length];
        //Compute the best transaction from 0 to i where i is in [0, n].
        //Find the min value in the previous subarray
        forward[0] = 0;
        int min = prices[0];
        for (int i = 1; i < forward.length; i++) {
            min = Math.min(min, prices[i]);
            forward[i] = Math.max(forward[i - 1], prices[i] - min);
        }
        //Compute the best transaction from i to 0.
        //This time we find the max number in the previous subarray.
        //Find the maximum one.
        backward[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            backward[i] = Math.max(backward[i + 1], max - prices[i]);
        }
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (forward[i] + backward[i] > result) {
                result = forward[i] + backward[i];
            }
        }
        return result;
    }
};