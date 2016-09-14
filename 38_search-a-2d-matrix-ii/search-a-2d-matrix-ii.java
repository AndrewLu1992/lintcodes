/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Java
@Datetime: 16-07-06 02:17
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    //Time complexity: O(m + n).
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0
            || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;
        int count = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] == target) {
                count++;
                x--;
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return count;
    }
}
