/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/distinct-subsequences
@Language: Java
@Datetime: 16-06-11 09:36
*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return 0;
        }
        int m = S.length();
        int n = T.length();
        int[][] f = new int[m + 1][n + 1];
        //Initialize the state transition function
        for (int i = 0; i < m + 1; i++) {
            f[i][0] = 1;
        }
        for (int j = 1; j < n + 1; j++) {
            f[0][j] = 0;
        }
        //Top - down approach
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }
}