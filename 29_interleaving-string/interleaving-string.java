/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/interleaving-string
@Language: Java
@Datetime: 16-06-12 05:26
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        //corner case: if s1 or s2 is Null or s3 is Null, return False
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        //If length is not equal to the sum of s1 and s2
        if (s3.length() != n + m) {
            return false;
        }
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            f[i][0] = f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < n + 1; j++) {
            f[0][j] = f[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        // Top - down approach
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && f[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && f[i][j - 1]))
                f[i][j] = true;
            }
        }
        return f[m][n];
    }
}