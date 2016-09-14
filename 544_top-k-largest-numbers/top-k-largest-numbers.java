/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 16-06-28 15:13
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0
                || k == 0 || k > nums.length) {
                    return new int[0];
                }
        //Use Heap to store k results.
        Queue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                pq.poll();
            }
            pq.offer(nums[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[k - i - 1] = pq.poll();
        }
        return result;
    }
};

