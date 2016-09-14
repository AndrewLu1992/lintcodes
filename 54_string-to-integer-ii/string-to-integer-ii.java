/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/string-to-integer-ii
@Language: Java
@Datetime: 16-08-22 19:01
*/

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.length() == 0) {
            return 0;
        }
        //str may contain leading and trailing whitespaces.
        str = str.trim();
        int dotPos = str.length();
        char[] digits = str.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            //Case1: check MSD.
            if (i == 0 &&(digits[i] == '-' || digits[i] == '+')) {
                continue;
            }
            //Case2: str contains non digit characters.
            if (digits[i] > '9' || digits[i] < '0') {
                dotPos = i;
                break;
            }
        }
        //check if all characters before dotPos are not digits.
        if (dotPos == 0 || 
            (dotPos == 1 && (digits[0] == '-' || digits[0] == '+'))) {
            return 0;
        }
        
        //Case3: str is out of integer range.
        if (dotPos > 11) {
            if (digits[0] == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        
        long number = Long.parseLong(str.substring(0, dotPos));
        if (number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)number;
        }
    }
}