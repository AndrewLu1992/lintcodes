/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/classical-binary-search
@Language: Java
@Datetime: 16-05-15 19:32
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        int start = 0, end = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target){
                return mid;
            }
            else if (A[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[start] == target){
            return start;
        }
        if (A[end] == target){
            return end;
        }
        return -1;
    }
}