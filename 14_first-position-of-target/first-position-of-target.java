/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 16-05-15 19:46
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        //corner case
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            // a little change here
            if (nums[mid] == target){
                end = mid;
            }
            else if (nums[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}