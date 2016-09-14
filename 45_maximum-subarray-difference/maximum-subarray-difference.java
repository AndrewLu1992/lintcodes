/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximum-subarray-difference
@Language: Java
@Datetime: 16-08-01 02:41
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //Greedy Algorithm: Enumerate breaking point.
        //Forward part:
        int[] forwardMax = new int[nums.length];
        forwardMax[0] = nums[0];
        int sumMax = nums[0];
        int[] forwardMin = new int[nums.length];
        forwardMin[0] = nums[0];
        int sumMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (sumMax > 0) {
                sumMax += nums[i];
            } else {
                sumMax = nums[i];
            }
            if (sumMin < 0) {
                sumMin += nums[i];
            } else {
                sumMin = nums[i];
            }
            forwardMax[i] = Math.max(sumMax, forwardMax[i - 1]);
            forwardMin[i] = Math.min(sumMin, forwardMin[i - 1]);
        }
        
        //Backward traversal. The second part
        int[] backwardMax = new int[nums.length];
        backwardMax[nums.length - 1] = nums[nums.length - 1];
        sumMax = nums[nums.length - 1];
        int[] backwardMin = new int[nums.length];
        backwardMin[nums.length - 1] = nums[nums.length - 1];
        sumMin = nums[nums.length - 1];
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (sumMax > 0) {
                sumMax += nums[i];
            } else {
                sumMax = nums[i];
            }
            if (sumMin < 0) {
                sumMin += nums[i];
            } else {
                sumMin = nums[i];
            }
            backwardMax[i] = Math.max(sumMax, backwardMax[i + 1]);
            backwardMin[i] = Math.min(sumMin, backwardMin[i + 1]);
        }
        
        //Merge the left part and the right part. 
        //Case1: LeftMax - rightMin.
        //Case2: rightMax - leftMin.
        //Find the maximum value out of case1 and case2.
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int maxDiff = Math.max(forwardMax[i] - backwardMin[i + 1],
                backwardMax[i + 1] - forwardMin[i]);
            result = Math.max(maxDiff, result);
        }
        return result;
    }
}

