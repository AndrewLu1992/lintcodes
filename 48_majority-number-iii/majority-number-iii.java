/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/majority-number-iii
@Language: Java
@Datetime: 16-08-18 21:42
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        //O(n) time. O(k) space.
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num)) {
                counter.put(num, 1);
            } else {
                counter.put(num, counter.get(num) + 1);
            }
            //This situation will occur n / k times.
            //Therefore, the worst case is O(n/k * k) = O(n).
            if (counter.size() > k) {
                removeKeys(counter);
            }
        }
        
        //Recalculate counts.
        for (int num : counter.keySet()) {
            counter.put(num, 0);
        }
        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            }
        }
        //Find the max
        int result = 0;
        int count = 0;
        for (int num : counter.keySet()) {
            if (counter.get(num) > count) {
                count = counter.get(num);
                result = num;
            }
        }
        return result;
    }
    
    //If size > k, decrease count by 1 and remove keys with 0 count.
    private void removeKeys(HashMap<Integer, Integer> counter) {
        //!!! attention: cannot modify the collection while looping it.
        ArrayList<Integer> removeList = new ArrayList<>();
        for (int num : counter.keySet()) {
            counter.put(num, counter.get(num) - 1);
            if (counter.get(num) == 0) {
                removeList.add(num);
            }
        }
        for (int num : removeList) {
            counter.remove(num);
        }
    }
}
