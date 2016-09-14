/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 16-06-22 10:14
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    //3 ćé
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        int pl = 0;
        int pr = nums.length - 1;
        int i = 0;
        // Attension it has equal to !!!
        while (i <= pr) {
            if (nums[i] == 0) {
               swap(nums, i, pl);
               pl++;
               i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, pr);
                pr--;
            }
        }
    }
}