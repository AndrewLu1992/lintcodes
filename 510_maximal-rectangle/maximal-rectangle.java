/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximal-rectangle
@Language: Java
@Datetime: 16-06-25 14:47
*/

public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0
            || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    height[i][j] = matrix[i][j] ? 1 : 0;
                } else {
                    height[i][j] = matrix[i][j] ? 1 + height[i - 1][j] : 0;
                }
            }
        }
        // Find the maximum rectangle.
        int max = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= n; j++) {
                int curr = j == n ? -1 : height[i][j];
                while (!stack.empty() && curr < height[i][stack.peek()]) {
                    int h = height[i][stack.pop()];
                    int w = stack.empty() ? j : j - stack.peek() - 1;
                    max = Math.max(max, h * w);
                }
                stack.push(j);
            }
        }
        return max;
    }
}