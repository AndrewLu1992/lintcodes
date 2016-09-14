/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Java
@Datetime: 16-08-09 20:11
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length < 1) {
            return "";
        }
        
        if (strs.length == 1) {
            return strs[0];
        }
        
        int maxLen = 0;
        int k = strs.length;
        boolean quit = false;
        while (maxLen < strs[0].length()) {
            char chr = strs[0].charAt(maxLen);
            for (int i = 1; i < k; i++) {
                if (strs[i].length() <= maxLen) {
                    quit = true;
                    break;
                }
                if (strs[i].charAt(maxLen) != chr) {
                    quit = true;
                    break;
                }
            }
            if (quit) {
                break;
            }
            maxLen++;
        }
        
        //System.out.println(maxLen);
        return strs[0].substring(0, maxLen);
    }
}