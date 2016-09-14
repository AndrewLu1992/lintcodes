/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 16-06-22 09:18
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    //Challenge: In place and O(n)
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    int i = 0;
	    int j = nums.length - 1;
	    while (i <= j) {
	        if (nums[i] < k) {
	            i++;
	            continue;
	        }
	        while (j > i && nums[j] >= k) {
	            j--;
	        }
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	        i++;
	        j--;
	    }
	    return j + 1;
    }
}