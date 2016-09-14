/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-07-05 09:14
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] > num[end]) {
                start = mid;
            } else if (num[mid] < num[end]) {
                end = mid;
            } else if (num[mid] == num[end]) {
                end--;
            }
        }
        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
}