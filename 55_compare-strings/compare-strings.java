/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 16-05-05 18:15
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        
        int[] arr_temp = new int[256];
        for(int i=0; i<A.length(); i++){
            char c = A.charAt(i);
            arr_temp[c] += 1;
        }
        for (int j=0; j<B.length(); j++){
            char c = B.charAt(j);
            arr_temp[c] -= 1;
            if (arr_temp[c] < 0) return false;
        }
        return true;
    }
}