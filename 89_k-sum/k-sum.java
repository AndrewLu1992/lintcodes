/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/k-sum
@Language: Java
@Datetime: 16-07-13 08:31
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if (A == null) {
            return 0;
        }
        int[][][] f = new int[A.length + 1][k + 1][target + 1];
        int n = A.length;
        //Initialization
        for (int i = 0; i < n + 1; i++) {
            //when j != 0. The solution number should be 0.
            //Because you should at least choose k numbers which is impossible.
            f[i][0][0] = 1;
        }
        //Computation.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int m = 1; m <= target; m++) {
                    //When the newly added num is in the solution
                    f[i][j][m] = f[i - 1][j][m];
                    //when the newly added num is not in the solution
                    if (m >= A[i - 1] && f[i - 1][j - 1][m - A[i - 1]] > 0) {
                        f[i][j][m] += f[i - 1][j - 1][m - A[i - 1]];
                    }
                }
            }
        }
        return f[n][k][target];
    }
}
