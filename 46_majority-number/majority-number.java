/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 16-08-18 20:21
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        //Because majority number occurs more than half.
        //We can use greedy approach.
        int major = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else if (num == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}