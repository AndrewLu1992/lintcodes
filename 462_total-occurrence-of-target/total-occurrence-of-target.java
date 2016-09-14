/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 16-07-05 04:35
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    //O(1) space. O(logn) time.
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int prev = 0;
        //Find the minimum index of item that is < target.
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        //If end was not pointing to target. There is no such target in num.
        if (A[end] != target) {
            return 0;
        }
        //Store the prev pointer.
        prev = start;
        //Reset the end pointer
        end = A.length - 1;
        //Find the last occurence of target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //The Occurrence of target in between.
        int result = start - prev;
        //Check if end and prev is pointing to the target.
        if (A[end] == target) {
            result++;
        }
        if (A[prev] == target) {
            result++;
        }
        //Return the result.
        return result;
    }
}