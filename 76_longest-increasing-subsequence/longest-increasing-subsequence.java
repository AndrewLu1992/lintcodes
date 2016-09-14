/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 16-05-29 14:28
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] arr = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i] && arr[j] + 1 > arr[i]) {
                    arr[i] = arr[j] + 1;
                }
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
