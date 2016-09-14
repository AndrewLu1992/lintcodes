/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iii
@Language: Java
@Datetime: 16-08-01 10:20
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
     
    //Partition dynamic programming
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || k > nums.length) {
            return 0;
        }
        
        int n = nums.length;
        int[][] local = new int[k + 1][n + 1];
        int[][] global = new int[k + 1][n + 1];
        
        for (int i = 1; i <= k; i++) {
            local[i][i - 1] = Integer.MIN_VALUE;
            for (int j = i; j <= n; j++) {
                /**
                *Attention: Cannot write local[i][j - 1] + nums[j - 1].
                * That may cause integer overflow when nums[j - 1] < 0 and
                * local is the minimum integer.
                **/
                local[i][j] = Math.max(local[i][j - 1],
                    global[i - 1][j - 1]) + nums[j - 1];
                if (i == j) {
                    global[i][j] = local[i][j];
                } else {
                    global[i][j] = Math.max(global[i][j - 1], local[i][j]);
                }
            }
        }
        return global[k][n];
    }
}
