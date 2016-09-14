/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 16-08-12 02:11
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        //XOR operation.
        int count = 0;
        //!!! >> : signed left shift. Propagate Most significant bit.
        //    >>>: unsigned left shift. Always fill in 0s on leftmost.
        for(int num = a ^ b; num != 0; num = num >>> 1) {
            count += num & 1;
        }
        return count;
    }
};
