/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 16-05-29 07:46
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        //dynamic programming
        int[] minSteps = new int[A.length];
        minSteps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            minSteps[i] = minSteps[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (A[j] + j >= i) {
                    minSteps[i] = minSteps[j] + 1;
                    break;
                }
            }
        }
        return minSteps[A.length - 1];
    }
}
