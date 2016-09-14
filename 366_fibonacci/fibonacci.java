/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/fibonacci
@Language: Java
@Datetime: 16-08-24 21:43
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n < 2) {
            return n == 1 ? 0 : 1;
        }
        
        int prev = 0;
        int curr = 1;
        for (int i = 2; i < n; i++) {
            int temp = prev;
            prev = curr;
            curr = prev + temp;
        }
        return curr;
    }
}

