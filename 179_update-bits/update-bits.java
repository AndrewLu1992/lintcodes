/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/update-bits
@Language: Java
@Datetime: 16-08-14 01:27
*/

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask = 0;
        if (j < 31) {
            mask = ~((1 << (j + 1)) - (1 << i));
        } else {
            mask = (1 << i) - 1;
        }
        return (m << i) + (mask & n); 
    }
}
