/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 16-08-18 23:45
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return nums;
        }
        //Step1: from right to left, find the first element 
        //that is smaller than the previous one
        int partitionIndex = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                partitionIndex = i - 1;
                break;
            }
        }
        //Step2: from right to left, find the number that
        //is larger than the partition number.
        int nextIndex = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[partitionIndex]) {
                nextIndex = i;
                break;
            }
        }
        //Step3: Swap two indiced elements.
        int temp = nums[partitionIndex];
        nums[partitionIndex] = nums[nextIndex];
        nums[nextIndex] = temp;
        //Step4: Reverse nums[partitonIndex + 1 :]
        int i = partitionIndex + 1;
        if (partitionIndex == 0 && nextIndex == 0) {
            i = 0;
        }
        int j = nums.length - 1;
        while(i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        
        return nums;
    }
}