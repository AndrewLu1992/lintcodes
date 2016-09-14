/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 16-06-28 05:14
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    //Cannot use dp because the relative position can be changed.
    //Use HashSet.
    public int longestConsecutive(int[] num) {
        // write you code here
        if (num == null || num.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int length = 0;
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        for (int i = 0; i < num.length; i++) {
            int down = num[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = num[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            length = Math.max(length, up - down - 1);
        }
        return length;
    }
}