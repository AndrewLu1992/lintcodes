/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 16-06-17 03:58
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    //Version 1: Sort + Merge. Attention, index++ is in the assignment closure.
    //Version 2: HashSet
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        //Build a look-up HashSet
        HashSet<Integer> dict = new HashSet<>();
        for (int num : nums1) {
            dict.add(num);
        }
        //Build Result
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (dict.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }
        //Copy to array
        int[] arr = new int[result.size()];
        int i = 0;
        for (int num : result) {
            arr[i] = num;
            i++;
        }
        return arr;
    }
}