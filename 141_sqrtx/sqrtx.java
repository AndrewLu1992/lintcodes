/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 16-05-17 04:59
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x == 0 || x == 1) return x;
        int start = 1, end = x;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            //importent!!! donot use mid * mid to compare with x because of possible overflow!!!!!
            int sentinel = x / mid;
            
            if (sentinel == mid){
                return mid;
            }
            else if (sentinel > mid){
                start = mid;
            }else{
                end = mid;
            }
        }
        return start;
    }
}