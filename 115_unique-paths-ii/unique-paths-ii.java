/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 16-05-29 14:11
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        //corner case
        if (obstacleGrid == null || obstacleGrid.length == 0
            || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
                return 1;
            }
        //state
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] state = new int[m][n];
        //initialize
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            state[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            state[0][i] = 1;
        }
        // top-down approach
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    state[i][j] = 0;
                } else {
                    state[i][j] = state[i - 1][j] + state[i][j - 1];
                }
            }
        }
        return state[m - 1][n - 1];
    }
}