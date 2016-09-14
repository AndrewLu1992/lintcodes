/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Java
@Datetime: 16-07-05 05:30
*/

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    //O(1) space O(log(n) + k) time.
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        //We need to deal with the k.
        //Otherwise the final while loop will fail.
        if (A == null || A.length == 0 || k > A.length || k == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
               start = mid - 1;
               end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int i = 0;
        //Attention to how to deal with the corner case.
        while (i < k) {
            //When there is no more left num can be added
            //We add right nums.
            if (start < 0) {
                result[i] = A[end];
                end++;
            //If there is no nums in the right side.
            } else if (end >= A.length) {
                result[i] = A[start];
                start--;
            }
            //If the element in the right side is more close to target
            //We add the num and move up the pointer.
            else if (target - A[start] > A[end] - target) {
                result[i] = A[end];
                end++;
            } else {
            //If the element on the left side is more close 
            //Or they are the same close, in both case we favor
            //add num on the left side into the array.
                result[i] = A[start];
                start--;
            }
            i++;
        }
        return result;
        }
    }