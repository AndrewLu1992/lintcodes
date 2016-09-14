/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/single-number
@Language: Java
@Datetime: 16-08-18 18:32
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        //XOR bit manipulation.
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        for (int num : A) {
            result ^= num;
        }
        return result;
    }
}