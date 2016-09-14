/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/backpack-ii
@Language: Java
@Datetime: 16-07-09 07:32
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[] f = new int[m + 1];
        int n = A.length;
        for (int i = 0; i < m + 1; i++) {
            f[i] = 0;
        }
        //Bottom - up approach.
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                if (f[j] < V[i] + f[j - A[i]]) {
                    f[j] = V[i] + f[j - A[i]];
                }
            }
        }
        return f[m];
    }
}