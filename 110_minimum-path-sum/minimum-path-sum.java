/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Java
@Datetime: 16-05-27 03:32
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        //cache to remember the minimum in each state
        int[][] cache = new int[grid.length][grid[0].length];
        //initialize
        cache[0][0] = grid[0][0];
        //initialize the path sum of only going down and going right.
        for (int i = 1; i < cache.length; i++) {
            cache[i][0] = cache[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cache[0].length; i++) {
            cache[0][i] = cache[0][i-1] + grid[0][i];
        }
        // top down approach
        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < cache[0].length; j++) {
                cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1])
                    + grid[i][j];
            }
        }
        return cache[grid.length - 1][grid[0].length - 1];
    }
}
