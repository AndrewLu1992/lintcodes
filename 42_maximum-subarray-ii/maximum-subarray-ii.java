/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximum-subarray-ii
@Language: Java
@Datetime: 16-06-21 13:34
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    //Use forward and backward traversal.
    //Similar to the buy and sell stock III problem.
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        //Key: Enumrate the separation point.
        int[] forward = new int[nums.size()];
        int[] backward = new int[nums.size()];
        //Forward part:
        forward[0] = nums.get(0);
        int sum = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (sum > 0) {
                sum += nums.get(i);
            } else {
                sum = nums.get(i);
            }
            forward[i] = Math.max(forward[i - 1], sum);
        }
        //Backward part:
        int m = nums.size();
        sum = nums.get(m - 1);
        backward[m - 1] = nums.get(m - 1);
        for (int i = m - 2; i >= 0; i--) {
            if (sum > 0) {
               sum += nums.get(i); 
            } else {
                sum = nums.get(i);
            }
            backward[i] = Math.max(sum, backward[i + 1]);
        }
        //Merge
        //!!! forward[i] <=> backward[i + 1].
        //!!! i from 0 to m - 1
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < m - 1; i++) {
            if (forward[i] + backward[i + 1] > result) {
                result = forward[i] + backward[i + 1];
            }
        }
        return result;
    }
}

