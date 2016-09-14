/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/gas-station
@Language: Java
@Datetime: 16-08-19 11:22
*/

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    //Greedy Algorithm
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if (gas == null || cost == null
            || gas.length == 0 || cost.length == 0) {
                return -1;
        }
        //Do not think it circularly. Flaten the process.
        int startIndex = 0;
        //Used to detect the startIndex.
        int sum = 0;
        //Used to determine if such startIndex exists.
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                startIndex = i + 1;
            }
        }
        return total < 0 ? -1 : startIndex;
    }
}