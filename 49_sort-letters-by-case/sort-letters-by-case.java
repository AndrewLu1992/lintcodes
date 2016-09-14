/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/sort-letters-by-case
@Language: Java
@Datetime: 16-07-30 13:30
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    private void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    // O(n) time O(1) space.
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length < 2) {
            return;
        }
        int left = 0;
        int right = chars.length - 1;
        for (int i = left; i < right; i++) {
            if (chars[i] <= 'z' && chars[i] >= 'a') {
                swap(chars, i, left);
                left++;
            }
        }
        for (int i = right; i >= left; i--) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                swap(chars, i, right);
                right--;
            }
        }
    }
}
