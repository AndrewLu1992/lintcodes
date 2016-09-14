/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximum-product-subarray
@Language: Java
@Datetime: 16-07-23 15:06
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        //Dynamic Programming
        //!!! You need to consider 2 cases: nums[n] < 0 and nums[n] >= 0
        //Need to trace both max and min because of nums[n] < 0 case.
        
        //O(1) space O(n) time.
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int m = nums.length;
        int max = nums[0];
        int min = nums[0];
        int temp = max;
        int result = nums[0];
        //Greedy Algorithm.
        for (int i = 1; i < m; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                temp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], temp * nums[i]);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}