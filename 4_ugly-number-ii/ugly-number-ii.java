/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 16-06-28 13:51
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n == 1) {
            return 1;
        }
        //PriorityQueue to achieve log time min value retrieve.
        Queue<Long> heap = new PriorityQueue<>(n * 2);
        //HashSet to achieve constant time contains method.
        HashSet<Long> set = new HashSet<>(n * 2);
        long[] primes = {2, 3, 5};
        for(long i : primes) {
            heap.offer(i);
            set.add(i);
        }
        long num = 0;
        for (int i = 1; i < n; i++) {
            num = heap.poll();
            set.remove(num);
            for(long prime : primes) {
                //Linear time operation.
                if (!set.contains(prime * num)) {
                    heap.offer(prime * num);
                    set.add(prime * num);
                } 
            }
        }
        return (int)num;
    }
};
