/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/load-balancer
@Language: Java
@Datetime: 16-09-07 04:57
*/

public class LoadBalancer {
    
    private List<Integer> servers;
    //To get index in O(1) time. We use HashMap to chieve the goal.
    private HashMap<Integer, Integer> hash;

    public LoadBalancer() {
        // Initialize your data structure here.
        servers = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        // Write your code here
        if (!hash.containsKey(server_id)) {
            int index = servers.size();
            hash.put(server_id, index);
            servers.add(server_id);
        }
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        if (hash.containsKey(server_id)) {
            int index = hash.get(server_id);
            //Trick: To achieve O(1) Remove, we can only remove 
            //the last element in the list. Thus we swap the server_id to
            //the last and then remove.
            int m = servers.size();
            int lastServer = servers.get(m - 1);
            servers.set(index, lastServer);
            servers.remove(m - 1);
            hash.put(lastServer, index);
        }
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        int n = servers.size();
        Random rd = new Random();
        int index = rd.nextInt(servers.size());
        return servers.get(index);
    } 
}