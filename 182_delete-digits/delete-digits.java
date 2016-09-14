/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/delete-digits
@Language: Java
@Datetime: 16-08-19 21:40
*/

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A == null || A.length() == 0) {
            return A;
        }
        
        StringBuilder str = new StringBuilder(A);
        for (int i = 0; i < k; i++) {
            int j = 0;
            //There must be an equal sign. Only remove the first
            //digit that is bigger than the latter one.
            while (j < str.length() - 1 &&
                str.charAt(j) <= str.charAt(j + 1)) {
                    j++;
            }
            str.delete(j, j + 1);
        }
        
        int index = 0;
        while (index < str.length() - 1 && str.charAt(index) == '0') {
            str.delete(index, index + 1);
        }
        
        return str.toString();
    }
}