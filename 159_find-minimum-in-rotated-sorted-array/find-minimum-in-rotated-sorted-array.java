/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 16-05-16 14:37
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) return -1;
        int start = 0, end = num.length - 1;
        int target = num[num.length - 1];
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (num[mid] <= target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        //There is situation that num[start] is bigger than target, cross the pivot.
        if (num[start] <= target) {
            return num[start];
        }
        else {
            return num[end];
        }
    }
}