/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii
@Language: Java
@Datetime: 16-08-10 04:09
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        boolean twice = false;
        //Add a boolean value.
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[size] == nums[i] && !twice) {
                nums[++size] = nums[i];
                twice = true;
            } else if (nums[size] != nums[i]) {
                nums[++size] = nums[i];
                twice = false;
            }
        }
        return size + 1;
    }
}