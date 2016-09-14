/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-07-06 01:42
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    //The Worst Case Complexity is O(n). eg. [1, 1, 1, -1, 1].
    //This is because if we allow duplicate numbers. Whenever we
    //find A[mid] == A[start] or == A[end], no clue indicating the
    //part the mid falls in.
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] > A[start]) {
                if (A[mid] > target && target >= A[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[mid] == A[start]) {
                    start++;
                } else if (A[mid] == A[end]) {
                    end--;
                } else {
                if (target < A[end] && target > A[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target || A[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
