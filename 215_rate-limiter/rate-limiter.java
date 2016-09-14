/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/rate-limiter
@Language: Java
@Datetime: 16-09-07 13:06
*/

public class RateLimiter {
    /**
     * @param timestamp the current timestamp
     * @param event the string to distinct different event
     * @param rate the format is [integer]/[s/m/h/d]
     * @param increment whether we should increase the counter
     * @return true or false to indicate the event is limited or not
     */
    private HashMap<String, List<Integer>> eventTable =
        new HashMap<String, List<Integer>>();
    
    private int findSeconds(String c) {
        if (c.equals("s")) {
            return 1;
        }
        if (c.equals("m")) {
            return 60;
        }
        if (c.equals("h")) {
            return 3600;
        }
        return 3600 * 24;
    }
    
    //Binary Search
    private int findStartTimeIndex(List<Integer> uses, 
        int currentTime, int interval) {
            //Check corner cases
            if (uses == null || uses.isEmpty()) {
                return 0;
            }
            int start = 0;
            int end = uses.size() - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                //if the time of use is within the interval
                if (currentTime - uses.get(mid) < interval) {
                    end = mid;
                } else {
                    /**
                    *if the time is too early or equal to
                    * currentTime - inteval
                    */
                    start = mid;
                }
            }
            //check if the final finding satisfies property
            if (currentTime - uses.get(start) < interval) {
                return start;
            } else if (currentTime - uses.get(end) < interval) {
                return end;
            }
            //if both are still not satisfying, it means no element
            //in the list satisfies. Return the Size of the list
            return end + 1;
    }
    
    //Log(n) time.
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // Write your code here
        if (!eventTable.containsKey(event)) {
           eventTable.put(event, new ArrayList<Integer>()); 
        }
        String[] tmp = rate.trim().split("/");
        int limit = Integer.parseInt(tmp[0]);
        int interval = findSeconds(tmp[1]);
        List<Integer> uses = eventTable.get(event);
        //Binary Search to find freqnecy of uses in given time interval.
        boolean res = uses.size() - 
            findStartTimeIndex(uses, timestamp, interval) >= limit;
        if (!res && increment) {
            uses.add(timestamp);
        }
        return res;
    }
}