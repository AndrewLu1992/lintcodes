/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/4sum
@Language: Java
@Datetime: 16-07-30 13:20
*/

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        // O(n ^ 3) time and O(n) space.
        ArrayList<ArrayList<Integer>> res = 
            new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 4) {
            return res;
        }
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left]
                        + numbers[right];
                    if (sum == target) {
                        ArrayList<Integer> item = new ArrayList<>();
                        item.add(numbers[i]);
                        item.add(numbers[j]);
                        item.add(numbers[left]);
                        item.add(numbers[right]);
                        res.add(item);
                        left++;
                        right--;
                        while (numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                        while (numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}