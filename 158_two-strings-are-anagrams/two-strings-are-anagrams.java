/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 16-05-05 18:02
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) return false;
        
        int[] arr_map = new int[256];
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr_map[c] += 1; 
        }
        for (int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            arr_map[c] -= 1;
            if (arr_map[c] < 0) return false;
        }
        return true;
    }
};