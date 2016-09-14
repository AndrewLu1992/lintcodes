/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 16-06-17 02:23
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    //Point: Because we need move all subsequent items in array
    //if starting from left, instead we start from the end.
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int indexA = m - 1;
        int indexB = n - 1;
        int index = m + n - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (A[indexA] > B[indexB]) {
                A[index] = A[indexA];
                indexA--;
            } else {
                A[index] = B[indexB];
                indexB--;
            }
            index--;
        }
        //If all integers in B are moved to A, 
        //we donot need process anything.
        if (indexB >= 0) {
            while (indexB >= 0) {
                A[index] = B[indexB];
                indexB--;
                index--;
            }
        }
    }
}