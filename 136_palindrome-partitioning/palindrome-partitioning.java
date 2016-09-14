/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 16-07-02 05:17
*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        ArrayList<List<String>> result =
            new ArrayList<List<String>>();
        if (s.length() == 0) {
            return result;
        }
        List<String> path = new ArrayList<>();
        search(s, path, 0, result);
        return result;
    }
    private void search(String s, List<String> path,
        int pos, ArrayList<List<String>> result) {
            if (pos == s.length()) {
                result.add(new ArrayList<String>(path));
                return;
            }
            for (int i = pos + 1; i <= s.length(); i++) {
                if (isPalindrome(s.substring(pos, i))) {
                    path.add(s.substring(pos, i));
                    //This time we start search at i.
                    search(s, path, i, result);
                    path.remove(path.size() - 1);
                }
            }
        }
    private boolean isPalindrome(String s) {
        int pre = 0;
        int pos = s.length() - 1;
        while (pre < pos) {
            if (s.charAt(pre) != s.charAt(pos)) {
                return false;
            }
            pre++;
            pos--;
        }
        return true;
    }
}