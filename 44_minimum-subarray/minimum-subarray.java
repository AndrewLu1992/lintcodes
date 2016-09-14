/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 16-07-23 13:17
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    /**
    * !!! This is not maximum subsequence. Subarray means that the subset
    * should retain the order in original array.
    */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        //Greedy algorithm: local opt => global opt
        //O(1) space, O(n) time.
        int m = nums.size();
        int local = nums.get(0);
        int global = local;
        for (int i = 1; i < m; i++) {
            local = Math.min(local + nums.get(i), nums.get(i));
            global = Math.min(global, local);
        }
        return global;
    }
}
