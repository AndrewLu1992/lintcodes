/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/3sum-closest
@Language: Java
@Datetime: 16-08-11 21:49
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return -1;
        }
        //The same stratergy as 3 sum
        Arrays.sort(numbers);
        int best = numbers[0] + numbers[1] + numbers[2];
        //Attention ! length - 2 for stop at last 2.
        for (int i = 0; i < numbers.length - 2; i++) {
            
            int start = i + 1;
            int end = numbers.length - 1;
            //Collision pointer.
            while (start < end) {
                
                int sum = numbers[i] + numbers[start] + numbers[end];
            
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    break;
                }
            }
            
            if (best == target) {
                break;
            }
        }
        
        return best;
    }
}
