/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/consistent-hashing-ii
@Language: Java
@Datetime: 16-08-30 09:07
*/

public class Solution {
    
    public int n, k;
    //To check if duplicates exist.
    public Set<Integer> shard_ids;
    public Map<Integer, List<Integer>> machines;

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static Solution create(int n, int k) {
        // Write your code here
        Solution sol = new Solution();
        sol.n = n;
        sol.k = k;
        sol.shard_ids = new HashSet<Integer>();
        sol.machines = new HashMap<Integer, List<Integer>>();
        return sol;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        Random ra = new Random();
        ArrayList<Integer> ids = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            int index = ra.nextInt(n);
            while(shard_ids.contains(index)) {
                index = ra.nextInt(n);
            }
            shard_ids.add(index);
            ids.add(index);
        }
        machines.put(machine_id, ids);
        return ids;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        int distance = n;
        int id = 0;
        for (Map.Entry<Integer, List<Integer>> entry : machines.entrySet()) {
            int machine_id = entry.getKey();
            List<Integer> shards = entry.getValue();
            int dist = n;
            for (int num : shards) {
                dist = num - hashcode;
                if (dist < 0) {
                    dist += n;
                }
                if (dist < distance) {
                    distance = dist;
                    id = machine_id;
                }
            }
        }
        return id;
    }
}