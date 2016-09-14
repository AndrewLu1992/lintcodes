/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: Java
@Datetime: 16-07-13 07:11
*/

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        s = " " + s;
        p = " " + p;
        int slen = s.length();
        int plen = p.length();
        
        boolean[] f = new boolean[slen];
        TreeSet<Integer> firstTrueSet = new TreeSet<>();
        firstTrueSet.add(0);
        f[0] = true;
        
        boolean allStar = true;
        for (int pi = 1; pi < plen; pi++) {
            if (p.charAt(pi) != '*')
                allStar = false;
            for (int si = slen - 1; si >= 0; si--) {
                if (si == 0) {
                    f[si] = allStar ? true : false;
                } else if (p.charAt(pi) != '*') {
                    if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')
                        f[si] = f[si-1];
                    else f[si] = false;
                } else {
                    int firstTruePos = firstTrueSet.isEmpty() ?
                        Integer.MAX_VALUE : firstTrueSet.first();
                    if (si >= firstTruePos) f[si] = true;
                    else f[si] = false;
                }
                if (f[si]) firstTrueSet.add(si);
                else firstTrueSet.remove(si);
            }
        }
        return f[slen - 1];
     }
}