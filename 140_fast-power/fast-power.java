/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Java
@Datetime: 16-08-14 06:47
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    //Use node property (a * b) % c = (a % c * b % c) % c. 
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (a == 0) {
            return 0;
        }
        
        //Exit case:
        if (n == 0 || a == 1) {
            return 1 % b;
        }
        
        if (n == 1) {
            return a % b;
        }
        //Divide
        long product = fastPower(a, b, n/2);
        product = (product * product) % b;
        //Combine
        if (n % 2 == 1) {
            product = (product * (a % b)) % b;
        }
        
        return (int)product;
    }
};