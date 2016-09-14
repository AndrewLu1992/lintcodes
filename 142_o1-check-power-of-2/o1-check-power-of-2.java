/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 16-08-12 02:26
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        int count = 0;
        //The leftmost bit is MSB. Negative num is 1 and pos num is 0.
        //That bit should not be considered.
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        
        if (count == 1) {
            return true;
        }
        return false;
    }
};