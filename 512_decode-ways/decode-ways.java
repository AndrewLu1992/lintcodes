/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/decode-ways
@Language: Java
@Datetime: 16-07-09 04:06
*/

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s.equals("")) {
            return 0;
        }
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        int numSolutions = 0;
        for (int i = 2; i <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num <= 26 && num >= 10) {
                numSolutions = f[i - 2];
            }
            if (s.charAt(i - 1) == '0') {
                f[i] = numSolutions;
            } else {
                f[i] = f[i - 1] + numSolutions;
            }
            numSolutions = 0;
        }
        return f[s.length()];
    }
}