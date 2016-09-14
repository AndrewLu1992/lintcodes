/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/longest-common-subsequence
@Language: Java
@Datetime: 16-06-08 03:49
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        //corner case
        if (A == null || A.length() == 0
            || B == null || B.length() == 0) {
            return 0;
        }
        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];
        // i: The index of char in A up to which length of LCS is computed.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m][n];
    }
}
