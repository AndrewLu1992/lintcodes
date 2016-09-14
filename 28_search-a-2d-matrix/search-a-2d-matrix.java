/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 16-05-15 20:35
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0] == null  || matrix[0].length == 0) return false;
        
        int start = 0, end = matrix.length * matrix[0].length - 1;
        int offset = matrix[0].length;
        
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (matrix[mid / offset][mid % offset] == target){
                return true;
            }
            else if (matrix[mid / offset][mid % offset] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if (matrix[start / offset][start % offset] == target){
            return true;
        }
        if (matrix[end / offset][end % offset] == target){
            return true;
        }
        return false;
    }
}
