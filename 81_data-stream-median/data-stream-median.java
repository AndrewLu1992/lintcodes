/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/data-stream-median
@Language: Java
@Datetime: 16-08-23 02:30
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int count = nums.length;
        Comparator<Integer> reverseComp = new Comparator<Integer>() {
            public int compare(Integer left, Integer right) {
                return right.compareTo(left);
            }
        };
        //MinHeap and MaxHeap
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(count, reverseComp);
        Queue<Integer> minHeap = new PriorityQueue<Integer>(count);
        //add nums into heaps
        int i = 0;
        //O(nlogn) algorithm.
        for (int num : nums) {
            if (maxHeap.size() == 0 || maxHeap.peek() > num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            //left size - right size must be <= 1.
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            //right side can not contains elements more than left.
            } else if (minHeap.size() - maxHeap.size() > 0) {
                maxHeap.offer(minHeap.poll());
            }
            res[i] = maxHeap.peek();
            i++;
        }
        return res;
    }
}