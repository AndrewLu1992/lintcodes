/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 16-08-02 01:53
*/

public class Solution {
    
    private int maxSize;
    
    private PriorityQueue<Integer> pq;

    public Solution(int k) {
        // initialize your data structure here.
        maxSize = k;
        pq = new PriorityQueue<Integer>();
    }

    public void add(int num) {
        // Write your code here
        if (pq.size() < maxSize) {
            pq.offer(num);
        } else {
            if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
    }

    public List<Integer> topk() {
        // Write your code here
        Iterator it = pq.iterator();
        List<Integer> res = new ArrayList<>();
        while (it.hasNext()) {
            res.add((Integer)(it.next()));
        }
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
};