/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/two-sum-closest
@Language: Java
@Datetime: 16-06-22 05:13
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    //对冲指针 + Sort.
    
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (i < j) {
            // If sum < target
            if (nums[i] + nums[j] < target) {
                if (target - nums[i] - nums[j] < diff) {
                    diff = target - nums[i] - nums[j];
                }
                i++;
            // Is sum > target
            } else {
                if (nums[i] + nums[j] - target < diff) {
                    diff = nums[i] + nums[j] - target;
                }
                j--;
            }
        }
        return diff;
    }
}