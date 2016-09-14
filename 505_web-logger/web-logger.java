/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/web-logger
@Language: Java
@Datetime: 16-09-07 03:01
*/

public class WebLogger {
    
    //Key point! implement using queue
    private Queue<Integer> hits;

    public WebLogger() {
        // initialize your data structure here.
        hits = new LinkedList<Integer>();
    }

    /**
     * @param timestamp an integer
     * @return void
     */
    public void hit(int timestamp) {
        // Write your code here
        hits.offer(timestamp);
    }

    /**
     * @param timestamp an integer
     * @return an integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // Write your code here
        while (!hits.isEmpty() && timestamp - hits.peek() >= 300) {
            hits.poll();
        }
        return hits.size();
    }
}