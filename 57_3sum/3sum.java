/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 16-09-13 01:10
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = 
            new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        //Firstly, sort the array.
        Arrays.sort(numbers);
        //Greedy Algorithm:
        for (int i = 0; i < numbers.length - 2; i++) {
            //Remove Duplicates
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(numbers[i]);
                    triplet.add(numbers[left]);
                    triplet.add(numbers[right]);
                    res.add(triplet);
                    left++;
                    right--;
                    //Remove Duplicates
                    //Because we moves the pointer, need to make sure 
                    //left and right do not cross over.
                    while (left < right && 
                        numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && 
                        numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}