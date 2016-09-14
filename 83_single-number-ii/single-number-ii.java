/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/single-number-ii
@Language: Java
@Datetime: 16-08-18 19:23
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        //Think all integers in bit representation.
        //O(1) space and O(n) time.
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        //check if 1's only occured 1 time at a bit position.
        int oneTime = 0;
        //# of times to left shift integers.
        for (int i = 0; i < 32; i++) {
            oneTime = 0;
            for (int num : A) {
                oneTime += (num >> i) & 1;
            }
            oneTime %= 3;
            result |= oneTime << i;
        }
        return result;
    }
}