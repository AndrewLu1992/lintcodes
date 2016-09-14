/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 16-06-20 12:14
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max_ending = nums[0];
        int max_so_far = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //If previous summation <= 0, it does not contribute anything.
            if (max_ending <= 0) {
                max_ending = nums[i];
            } else {
                max_ending += nums[i];
            }
            // Determine if nums[i] or new sum of subarray
            // is bigger than the previous one.
            max_so_far = Math.max(max_so_far, max_ending);
        }
        return max_so_far;
    }
}