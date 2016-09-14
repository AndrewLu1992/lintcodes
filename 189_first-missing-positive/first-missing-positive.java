/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Java
@Datetime: 16-08-11 16:25
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        //Step1: sort array as much as possibile using
        //index and arrange element consistent with indices.
        //Step2: check if there is any inconsistency between
        //indices and elements.
        if (A == null || A.length == 0) {
            return 1;
        }
        //Ensure that index == A[i] - 1.
        for (int i = 0; i < A.length; i++) {
            //Use while but not if to ensure put element into place.
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i + 1)) {
                int temp = A[A[i] - 1];
                //If temp == A[i], no change will be made in A[i],
                //which will cause infinite loop.
                if (temp == A[i]) {
                    break;
                }
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        //Check if there is any inconsistency from left to the right.
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 || A[i] > A.length || A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}