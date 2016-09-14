/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 16-06-08 05:04
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        //corner case
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int[][] f = new int[A.length() + 1][B.length() + 1];
        int ans = 0;
        //DP -- top - down approach
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                //search over all pairs of substrings to find the longest one
                if (f[i][j] > ans) {
                    ans = f[i][j];
                }
            }
        }
        return ans;
    }
}