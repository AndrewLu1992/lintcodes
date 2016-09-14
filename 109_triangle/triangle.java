/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 16-05-22 01:26
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int[][] cache = new int[triangle.length][triangle.length];
        //initialize
        cache[0][0] = triangle[0][0];
        //left side, right side
        for (int i = 1; i < cache.length; i++) {
            cache[i][0] = cache[i-1][0] + triangle[i][0];
            cache[i][i] = cache[i-1][i-1] + triangle[i][i];
        }
        //top down approach
        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < i; j++) {
                cache[i][j] = Math.min(cache[i - 1][j], cache[i - 1][j - 1])
                + triangle[i][j];
            }
        }
        return findMin(cache[cache.length - 1]);
    }
    
    private int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
