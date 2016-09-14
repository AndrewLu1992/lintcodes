/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 16-07-09 06:44
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0 || m == 0) {
            return 0;
        }
        int n = A.length;
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                f[i + 1][j] = f[i][j];
                if (A[i] <= j && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (f[n][i]) {
                return i;
            }
        }
        return 0;
    }
}