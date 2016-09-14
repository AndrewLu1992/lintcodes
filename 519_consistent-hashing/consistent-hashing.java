/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/consistent-hashing
@Language: Java
@Datetime: 16-08-30 03:35
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 1) {
            return res;
        }
        //First, consider about n == 1.
        ArrayList<Integer> machine = new ArrayList<>();
        machine.add(0);
        machine.add(359);
        machine.add(1);
        res.add(machine);
        //consider all from 1 to n
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> new_machine = new ArrayList<>();
            int max_index = 0;
            //Find the maximal interval
            for (int j = 1; j < i; j++) {
                if (res.get(j - 1).get(1) - res.get(j - 1).get(0) >
                    (res.get(max_index).get(1) - res.get(max_index).get(0))) {
                        max_index = j - 1;
                    }
            }
            //Divide into 2 intervals.
            int x = res.get(max_index).get(0);
            int y = res.get(max_index).get(1);
            res.get(max_index).set(1, (x + y) / 2);
            new_machine.add((x + y) / 2 + 1);
            new_machine.add(y);
            new_machine.add(i);
            res.add(new_machine);
        }
        return res;
    }
}