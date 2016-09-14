/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Java
@Datetime: 16-08-09 19:46
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    //HashTable + counting.
    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        //There are 256 characters in ASCII.
        int[] letters = new int[256];
        for (char c : a.toCharArray()) {
            letters[c]++;
        }
        for (char c : b.toCharArray()) {
            if (letters[c] == 0) {
                return false;
            }
            letters[c]--;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    //boolean array to reduce comparation.
    public List<String> anagrams(String[] strs) {
        // write your code here
        ArrayList<String> result = new ArrayList<>();
        if (strs == null || strs.length < 2) {
            return result;
        }
        
        boolean[] tracked = new boolean[strs.length];
        int index = 0;

        while (index < strs.length) {
            int nextIndex = index + 1;
            if (!tracked[index]) {
                boolean added = false;
                while (nextIndex < strs.length) {
                    if (!tracked[nextIndex] && 
                        isAnagram(strs[index], strs[nextIndex])) {
                            added = true;
                            tracked[nextIndex] = true;
                            result.add(strs[nextIndex]);
                    }
                    nextIndex++;
                }
                if (added) {
                    result.add(strs[index]);
                    tracked[index] = true;
                }
            }
            index++;
        }
        
        return result;
    }
}