/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 16-07-30 04:36
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0 || colors.length == 1) {
            return;
        }
        int sortedColors = 0;
        int left = 0;
        int right = colors.length - 1;
        
        while (sortedColors < k) {
            int max = 1;
            int min = k;
            // First find the max  and min num in the given range.
            for (int i = left; i <= right; i++) {
                if (colors[i] > max) {
                    max = colors[i];
                }
                if (colors[i] < min) {
                    min = colors[i];
                }
            }
            
            if (left >= right || max == min) {
                break;
            } else {
                //swap the min to the leftmost position
                for (int i = left; i <= right; i++) {
                    if (colors[i] == min) {
                        swap(colors, i, left);
                        left++;
                    }
                }
                //swap the max num to the rightmost position
                for (int i = right; i >= left; i--) {
                    if (colors[i] == max) {
                        swap(colors, i, right);
                        right--;
                    }
                }
            }
            sortedColors += 2;
        }
    }
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}