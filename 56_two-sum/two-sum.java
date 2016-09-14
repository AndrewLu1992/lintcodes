/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Java
@Datetime: 16-06-21 21:55
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    //Use a HashMap to memorize the relation between the rest and the index.
    // O(n) time + O(n) space.
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int[] result = {map.get(numbers[i]) + 1, i + 1};
                return result;
            }
            map.put(target - numbers[i], i);
        }
        //Corner Case
        int[] result = {};
        return result;
    }
}