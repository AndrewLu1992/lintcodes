/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/single-number-iii
@Language: Java
@Datetime: 16-08-18 19:56
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        //XOR all numbers
        int xor = 0;
        for (int num : A) {
            xor ^= num;
        }
        //Extract the the postition of the least significant bit in XOR.
        xor = xor - ((xor - 1) & xor);
        //use xor to differ elements in A.
        int group1 = 0;
        int group2 = 0;
        
        for (int num : A) {
            if ((num & xor) == 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }
        
        res.add(group1);
        res.add(group2);
        return res;
    }
}