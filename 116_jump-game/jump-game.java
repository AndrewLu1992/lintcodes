/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 16-05-28 04:17
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        //greedy algorithm
        if (A == null || A.length == 0) {
            return true;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && i + A[i] > farthest) {
                farthest = i + A[i];
            }
        }
        return farthest >= A.length - 1;
    }
}