/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 16-06-04 03:37
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    private int findMaxLength(Set<String> dict) {
        int max = 0;
        for (String s : dict) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (dict.size() == 0) {
            return s.length() == 0;
        }
        
        int n = s.length();
        int maxLength = findMaxLength(dict);
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        
        for (int i = 1; i < n + 1; i++) {
            f[i] = false;
            for (int j = 1; j < Math.min(i, maxLength) + 1; j++) {
                if (!f[i - j]) {
                    continue;
                }
                if (dict.contains(s.substring(i - j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}