/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 16-06-21 11:57
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    //If a subarray sum[m:n] is summed to 0, sum[:m - 1] == sum sum[:n].
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        //Use HashMap to memorize previous result
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                //start at the next index
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }
            map.put(sum, i);
        }
        return ans;
    }
}