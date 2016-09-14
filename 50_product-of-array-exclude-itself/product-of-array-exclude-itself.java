/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 16-08-10 06:43
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    // Enumerate breaking point.
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        
        ArrayList<Long> result =new ArrayList<>();
        if (A == null || A.size() == 0) {
            return result;
        }
        if (A.size() == 1) {
            result.add((long)1);
            return result;
        }
        
        long[] forward = new long[A.size()];
        forward[0] = (long) A.get(0);
        long[] backward = new long[A.size()];
        backward[A.size() - 1] = (long) A.get(A.size() - 1);
        
        for (int i = 1; i < A.size(); i++) {
           forward[i] = forward[i - 1] * A.get(i); 
        }
        for (int i = A.size() - 2; i >= 0 ; i--) {
            backward[i] = backward[i + 1] * A.get(i);
        }
        
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                result.add(backward[i + 1]);
            }else if (i == A.size() - 1) {
                result.add(forward[i - 1]);
            } else {
                result.add(forward[i - 1] * backward[i + 1]);
            }
        }
        return result;
    }
}
