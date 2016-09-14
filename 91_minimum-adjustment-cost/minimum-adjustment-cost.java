/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Java
@Datetime: 16-07-12 08:15
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        //the total number of elements in the array
        int n = A.size();
        /*f: The minimum total cost of changing
        the last num at index i to j*/
        int[][] f = new int[n + 1][101];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                //Initial case: len(A) == 1:
                if (i == 1) {
                    f[i][j] = Math.abs(A.get(i - 1) - j);
                } else {
                    //Find the minimum cost so far.
                    for (int k = 1; k <= 100; k++) {
                        if (Math.abs(j - k) > target) {
                            continue;
                        }
                        int dif = f[i - 1][k] + Math.abs(j - A.get(i - 1));
                        f[i][j] = Math.min(f[i][j], dif);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 1; j < 100; j++) {
            if (f[n][j] < result) {
                result = f[n][j];
            }
        }
        return result;
    }
}