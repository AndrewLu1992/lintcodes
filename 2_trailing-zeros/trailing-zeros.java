/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/trailing-zeros
@Language: Java
@Datetime: 16-08-12 14:58
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long num = 0;
        //Compare n with 5.
        //Time complexity: O(logn). Each time cut off 4/5 * n.
        while (n != 0) {
            num += n / 5;
            n /= 5;
        }
        return num;
    }
};
