/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 16-06-17 02:07
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int[] result = new int[A.length + B.length];
        int pA = 0;
        int pB = 0;
        int index = 0;
        while (pA < A.length && pB < B.length) {
            if (A[pA] < B[pB]) {
                result[index] = A[pA];
                pA += 1;
            } else {
                result[index] = B[pB];
                pB += 1;
            }
            index += 1;
        }
        if (pA != A.length) {
            while (pA < A.length) {
                result[index] = A[pA];
                pA += 1;
                index += 1;
            }
        } else {
            while (pB < B.length) {
                result[index] = B[pB];
                pB += 1;
                index += 1;
            }
        }
        return result;
    }
}