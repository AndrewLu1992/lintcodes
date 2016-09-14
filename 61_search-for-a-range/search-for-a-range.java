/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 16-05-18 03:09
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        //write your code here
        if (A == null || A.length == 0) {
            return new int[]{-1, -1}; 
        }
        
        int start = 0;
        int end = A.length - 1;
        int[] range = {-1, -1};
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[start] == target) {
            range[0] = start;
        }
        else if (A[end] == target) {
            range[0] = end;
        }
        else {
            return range;
        }
        
        start = range[0];
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (A[end] == target) {
            range[1] = end;
        }
        else {
            range[1] = start;
        }
        return range;
    }
}
