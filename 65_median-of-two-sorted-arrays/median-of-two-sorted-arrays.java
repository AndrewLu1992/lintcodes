/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/median-of-two-sorted-arrays
@Language: Java
@Datetime: 16-06-20 10:37
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    //Median of median algorithm.
    //Each time we remove 1/4 of elements from arrays that are smaller than
    //the lower median. These elements could not be the median.
    //We can also
    private int findKth(int[] A, int startA, int[] B, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int A_key = startA + k / 2 - 1 < A.length ?
            A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = startB + k / 2 - 1 < B.length ?
            B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (A_key < B_key) {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
    }
}
