/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Java
@Datetime: 16-06-28 09:16
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    //Policy: A[i * 2 + 1] >= A[i], A[i * 2 + 2] >= A[i].
    //@Params: A the array implemented heap
    //         k: The index of item to be sifted down.
    private void siftDown(int[] A, int k) {
        while (k < A.length) {
            int min = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[k]) {
                min = k * 2 + 1;
            }
            //Attension: Here We sshould comapre right with min node.
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[min]) {
                min = k * 2 + 2;
            }
            if (min == k) {
                break;
            }
            int temp = A[k];
            A[k] = A[min];
            A[min] = temp;
            k = min;
        }
    }
    public void heapify(int[] A) {
        // write your code here
        for (int i = A.length / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }
}