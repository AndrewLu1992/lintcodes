/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/singleton
@Language: Java
@Datetime: 16-08-23 03:03
*/

class Solution {
    /**
     * @return: The same instance of this class every time
     */
    private static Solution instance;
    public static Solution getInstance() {
        // write your code here
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
};