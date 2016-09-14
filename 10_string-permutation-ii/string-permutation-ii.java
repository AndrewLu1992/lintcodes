/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Java
@Datetime: 16-08-04 11:09
*/

public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        char[] s = str.toCharArray();
        Arrays.sort(s);
        res.add(String.valueOf(s));
        while (s != null) {
            s = nextPermutation(s);
            if (s != null) res.add(String.valueOf(s));
        }
        return res;
    }
    //Important nextPermutation rotation method
    private char[] nextPermutation(char[] c) {
        int index = -1;
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] > c[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        for (int i = c.length - 1; i > index; i--) {
            if (c[i] > c[index]) {
                char temp = c[i];
                c[i] = c[index];
                c[index] = temp;
                break;
            }
        }
        reverse(c, index + 1, c.length - 1);
        return c;
    }
    
    private void reverse(char[] c, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }
}