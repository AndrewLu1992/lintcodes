/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/closest-number-in-sorted-array
@Language: Java
@Datetime: 16-07-05 04:43
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (target - A[start] > A[end] - target) {
            return end;
        } else {
            return start;
        }
    }
}