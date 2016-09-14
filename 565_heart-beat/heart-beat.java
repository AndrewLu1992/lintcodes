/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/heart-beat
@Language: Java
@Datetime: 16-09-06 04:43
*/

public class HeartBeat {
    
    private class Slave {
        public String ip;
        public int timestamp;
        
        public Slave(String ip, int timestamp) {
            this.ip = ip;
            this.timestamp = timestamp;
        }
    }
    
    private int k;
    private HashMap<String, Slave> slaves;

    public HeartBeat() {
        // initialize your data structure here
        slaves = new HashMap<String, Slave>();
    }

    // @param slaves_ip_list a list of slaves'ip addresses
    // @param k an integer
    // @return void
    public void initialize(List<String> slaves_ip_list, int k) {
        // Write your code here
        for (String slave_ip : slaves_ip_list) {
            slaves.put(slave_ip, new Slave(slave_ip, 0));
        }
        this.k = k;
    }

    // @param timestamp current timestamp in seconds
    // @param slave_ip the ip address of the slave server
    // @return nothing
    public void ping(int timestamp, String slave_ip) {
        // Write your code here
        if (slaves.containsKey(slave_ip)) {
            Slave slave = slaves.get(slave_ip);
            slave.timestamp = timestamp;
        }
    }

    // @param timestamp current timestamp in seconds
    // @return a list of slaves'ip addresses that died
    public List<String> getDiedSlaves(int timestamp) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String, Slave> entry : slaves.entrySet()) {
            int time = entry.getValue().timestamp;
            if (timestamp - time >= 2 * k) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}